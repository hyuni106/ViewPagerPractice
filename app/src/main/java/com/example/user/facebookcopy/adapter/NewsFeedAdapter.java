package com.example.user.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.data.NewsFeedData;

import java.util.List;

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

        NewsFeedData data = mList.get(position);

        TextView userTxt = row.findViewById(R.id.userTxt);
        TextView writeTimeTxt = row.findViewById(R.id.writeTimeTxt);
        TextView contentTxt = row.findViewById(R.id.contentTxt);
        TextView likeCountTxt = row.findViewById(R.id.likeCountTxt);

        userTxt.setText(data.getUserName());
        writeTimeTxt.setText(data.getWriteTime()+"분 전");
        contentTxt.setText(data.getText());
        likeCountTxt.setText("좋아요 " + data.getLikeCount() + "개");

        return row;
    }
}
