package com.example.user.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.ReplyListActivity;
import com.example.user.facebookcopy.data.ReplyData;
import com.example.user.facebookcopy.util.TimeAgoUtil;

import java.util.List;

/**
 * Created by user on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {
    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;

    public ReplyAdapter(Context context, List<ReplyData> list) {
        super(context, R.layout.reply_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        final ReplyData data = mList.get(position);
        LinearLayout replyLayout = (LinearLayout)row.findViewById(R.id.replyLayout);
        LinearLayout reReplyLayout = (LinearLayout)row.findViewById(R.id.reReplyLayout);

        if (data.getParentReplyId() == 0) {
            replyLayout.setVisibility(View.VISIBLE);
            reReplyLayout.setVisibility(View.GONE);
            TextView nameTxt = (TextView) row.findViewById(R.id.nameTxt);
            TextView commentTxt = (TextView) row.findViewById(R.id.commentTxt);
            TextView minuteAgoTxt = (TextView) row.findViewById(R.id.minuteAgoTxt);
            TextView makeRorTxt1 = (TextView) row.findViewById(R.id.makeRorTxt1);

            nameTxt.setText(data.getName());
            commentTxt.setText(data.getComment());

            makeRorTxt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int originalReplyNum = data.getReplyId();
                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);
                }
            });

        } else {
            replyLayout.setVisibility(View.GONE);
            reReplyLayout.setVisibility(View.VISIBLE);
            TextView reNameTxt = (TextView) row.findViewById(R.id.reNameTxt);
            TextView reCommentTxt = (TextView) row.findViewById(R.id.reCommentTxt);
            TextView reMinuteAgoTxt = (TextView) row.findViewById(R.id.reMinuteAgoTxt);
            TextView makeRorTxt2 = (TextView) row.findViewById(R.id.makeRorTxt2);

            reNameTxt.setText(data.getName());
            reCommentTxt.setText(data.getComment());

            makeRorTxt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int originalReplyNum = data.getParentReplyId();
                    // Adapter처럼 부속품으로 활용되는 코드에서 Activity에 접근을 해야하는 상황 발생
                    // ((액티비티이름) mContext).객체 활용
                    // 액티비티에서는 반드시 public 으로 열어줘야함 or getter, setter 활용
                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);
                }
            });
        }

        return row;
    }

}
