package com.example.user.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.adapter.NotificationAdapter;
import com.example.user.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-04.
 */

public class NotificationFragment extends Fragment {
    ListView notificationList;
    NotificationAdapter notificationAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification_list, container, false);
        notificationList = (ListView) v.findViewById(R.id.notificationList);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        notificationAdapter = new NotificationAdapter(getActivity(), GlobalDatas.notificationDatas);
        notificationList.setAdapter(notificationAdapter);
    }

    private void setupEvents() {
        notificationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });
    }


}
