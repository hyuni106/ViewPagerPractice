package com.example.user.facebookcopy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.facebookcopy.adapter.ChatAdapter;
import com.example.user.facebookcopy.data.MessageData;
import com.example.user.facebookcopy.util.GlobalDatas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    List<MessageData> chatDataList = new ArrayList<>();
    private android.widget.ListView chatList;
    ChatAdapter chatAdapter;
    private android.widget.EditText sendMsgEdt;
    private android.widget.Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        bindViews();
        setupEvents();
        setValues();
        addmessageDatas();
    }

    private void addmessageDatas() {
        chatDataList.clear();
        chatDataList.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(10, "ㅋㅋㅋ", Calendar.getInstance()));
        chatDataList.add(new MessageData(9, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(9, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(9, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(9, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        chatDataList.add(new MessageData(10, "마지막", Calendar.getInstance()));

        chatAdapter.notifyDataSetChanged();
    }

    private void setValues() {
        chatAdapter = new ChatAdapter(this, chatDataList);
        chatList.setAdapter(chatAdapter);
    }

    private void setupEvents() {

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendStr = sendMsgEdt.getText().toString();
                if (sendStr.length() > 0) {
                    chatDataList.add(new MessageData(GlobalDatas.loginUserId, sendStr, Calendar.getInstance()));
                    chatAdapter.notifyDataSetChanged();

                    hideKeyboard();
                    scrollMyListViewToBottom();
//                    chatList.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);

                    sendMsgEdt.setText("");
                } else {
                    Toast.makeText(ChatActivity.this, "메세지를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void scrollMyListViewToBottom() {
        chatList.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                chatList.setSelection(chatAdapter.getCount() - 1);
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void bindViews() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.sendMsgEdt = (EditText) findViewById(R.id.sendMsgEdt);
        this.chatList = (ListView) findViewById(R.id.chatList);
    }
}
