package com.example.user.facebookcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.ReplyListActivity;
import com.example.user.facebookcopy.data.NewsFeedData;
import com.example.user.facebookcopy.util.TimeAgoUtil;

import java.util.List;
import java.util.Locale;

/**
 * Created by user on 2017-08-04.
 */

public class NewsFeedAdapter extends ArrayAdapter<NewsFeedData> {
    Context mContext;
    List<NewsFeedData> mList;
    LayoutInflater inf;

    public NewsFeedAdapter(Context context, List<NewsFeedData> list) {
        super(context, R.layout.newsfeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null) {
            row = inf.inflate(R.layout.newsfeed_list_item, null);
        }

        final NewsFeedData data = mList.get(position);

        TextView minuteAgoTxt = (TextView)row.findViewById(R.id.minuteAgoTxt);
        TextView contentTxt = (TextView)row.findViewById(R.id.contentTxt);
        LinearLayout urlPreviewLayout = (LinearLayout) row.findViewById(R.id.urlPreviewLayout);
        TextView urlTxt = (TextView)row.findViewById(R.id.urlTxt);
        TextView likeCountTxt = (TextView)row.findViewById(R.id.likeCountTxt);
        Button likeBtn = (Button) row.findViewById(R.id.likeBtn);
        Button commentBtn = (Button) row.findViewById(R.id.commentBtn);

        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "좋아요 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                mContext.startActivity(intent);
            }
        });

        // Adapter의 getView에서 if를 통해 작업할 때는 반드시 esle의 경우도 작업해야함
        // Adapter를 활용하는 View는 재활용이 기본 옵션
        if (!data.getLinkUrl().equals("")) {    // data.getLinkUrl().length() != 0
            urlPreviewLayout.setVisibility(View.VISIBLE);
            urlPreviewLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(data.getLinkUrl()));
                    mContext.startActivity(intent);
                }
            });
            urlTxt.setText(data.getLinkUrl());
        } else {
            urlPreviewLayout.setVisibility(View.GONE);
        }

        contentTxt.setText(data.getContentTxt());

        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
        minuteAgoTxt.setText(minuteStr);

        String likeStr = String.format(Locale.KOREA, "%,d개", data.getLikeCount());
        likeCountTxt.setText(likeStr);

        return row;
    }

}
