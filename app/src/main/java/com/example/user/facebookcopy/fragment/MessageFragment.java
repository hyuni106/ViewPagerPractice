package com.example.user.facebookcopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.facebookcopy.ChatActivity;
import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.adapter.MessageAdapter;
import com.example.user.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-04.
 */

public class MessageFragment extends Fragment{
    ListView messageListView;
    MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message_list, container, false);
        messageListView = (ListView) v.findViewById(R.id.messageListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setValues();
        setupEvents();
    }

    private void setValues() {
        messageAdapter = new MessageAdapter(getActivity(), GlobalDatas.messageDatas);
        messageListView.setAdapter(messageAdapter);
    }

    private void setupEvents() {
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
    }
}
