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
import com.example.user.facebookcopy.data.NotificationData;
import com.example.user.facebookcopy.util.TimeAgoUtil;

import java.util.List;
import java.util.Locale;

/**
 * Created by user on 2017-08-08.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationData> {
    Context mContext;
    List<NotificationData> mList;
    LayoutInflater inf;

    public NotificationAdapter(Context context, List<NotificationData> list) {
        super(context, R.layout.notification_item_list, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.notification_item_list, null);
        }

        NotificationData data = mList.get(position);
        TextView notiTxt = (TextView) row.findViewById(R.id.notiTxt);
        TextView minuteAgoTxt = (TextView) row.findViewById(R.id.minuteAgoTxt);

        notiTxt.setText(data.getNotiMessage());

        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
        minuteAgoTxt.setText(minuteStr);

        return row;
    }
}
