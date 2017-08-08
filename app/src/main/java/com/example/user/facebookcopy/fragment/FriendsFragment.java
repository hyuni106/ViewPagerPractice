package com.example.user.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.adapter.FriendRequestAdapter;
import com.example.user.facebookcopy.util.GlobalDatas;

/**
 * Created by user on 2017-08-04.
 */

public class FriendsFragment extends Fragment {
    ListView friendList;
    FriendRequestAdapter friendRequestAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend_request, container, false);
        friendList = (ListView) v.findViewById(R.id.friendList);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // fragment 에서 onCreate 대신 사용하는 메소드
        setupEvents();
        setValues();
    }

    private void setValues() {
        // 화면에 표시될 데이터 가공 / set
        friendRequestAdapter = new FriendRequestAdapter(getActivity(), GlobalDatas.friendRequestDatas);
        friendList.setAdapter(friendRequestAdapter);
    }

    private void setupEvents() {
        // 객체들이 터치된 이벤트를 처리
        friendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            }
        });
    }
}
