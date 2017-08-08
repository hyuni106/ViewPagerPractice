package com.example.user.facebookcopy.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.adapter.NewsFeedAdapter;
import com.example.user.facebookcopy.data.NewsFeedData;
import com.example.user.facebookcopy.util.GlobalDatas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-04.
 */

public class NewsFeedFragment extends Fragment {
    private ListView newsFeedList;
    NewsFeedAdapter newsFeedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newspeed_list, container, false);
        newsFeedList = (ListView) v.findViewById(R.id.newsFeedList);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        newsFeedAdapter = new NewsFeedAdapter(getActivity(), GlobalDatas.newsFeedDatas);
        newsFeedList.setAdapter(newsFeedAdapter);
    }

    private void setupEvents() {

    }
}
