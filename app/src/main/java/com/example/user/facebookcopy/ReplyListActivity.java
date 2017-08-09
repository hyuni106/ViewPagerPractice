package com.example.user.facebookcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.facebookcopy.adapter.ChatAdapter;
import com.example.user.facebookcopy.adapter.ReplyAdapter;
import com.example.user.facebookcopy.data.MessageData;
import com.example.user.facebookcopy.data.ReplyData;
import com.example.user.facebookcopy.util.GlobalDatas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReplyListActivity extends AppCompatActivity {

    private android.widget.ListView replyList;
    public android.widget.EditText replyEdt;
    private android.widget.Button replySendBtn;
    ReplyAdapter replyAdapter;
    List<ReplyData> replyDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        bindViews();
        setupEvents();
        setValues();
        setDatas();
    }

    private void setDatas() {
        replyDatas.clear();
        replyDatas.add(new ReplyData(1, 0, "김태희", "김태희입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2, 1, "아이유", "아이유입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3, 1, "수지", "수지입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4, 0, "비", "비입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5, 4, "조경진", "조경진입니다.", Calendar.getInstance()));

        replyAdapter.notifyDataSetChanged();
    }

    private void setValues() {
        replyAdapter = new ReplyAdapter(this, replyDatas);
        replyList.setAdapter(replyAdapter);
    }

    private void setupEvents() {
        replySendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyStr = replyEdt.getText().toString();
                // 어뎁터에서 edittext에 달아둔 태그를 받아서 숫자로 저장하는 부분
                int parentId = Integer.parseInt(replyEdt.getTag().toString());
                // 파고들어갈 위치를 찾는 알고리즘
                int index = replyDatas.size();

                if (parentId != 0) {
                    // 누군가의 답댓일 경우
                    for (int i=0; i<replyDatas.size(); i++) {
                        ReplyData data = replyDatas.get(i);
                        if (parentId == data.getReplyId()) {
                            index = i + 1;
                        } else if (parentId == data.getParentReplyId()) {
                            index = i + 1;
                        }
                    }
                }

                if (replyStr.length() > 0) {
                    int count = replyDatas.size();
                    replyDatas.add(index, new ReplyData(count+1, parentId, GlobalDatas.loginUserName, replyStr, Calendar.getInstance()));
                    replyAdapter.notifyDataSetChanged();

                    scrollMyListViewToBottom();

                    replyEdt.setText("");
                } else {
                    Toast.makeText(ReplyListActivity.this, "메세지를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void scrollMyListViewToBottom() {
        replyList.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                replyList.setSelection(replyAdapter.getCount() - 1);
                // 리스트뷰 맨 밑으로 끌어내리기
            }
        });
    }

    private void bindViews() {
        this.replySendBtn = (Button) findViewById(R.id.replySendBtn);
        this.replyEdt = (EditText) findViewById(R.id.replyEdt);
        this.replyList = (ListView) findViewById(R.id.replyList);
    }
}
