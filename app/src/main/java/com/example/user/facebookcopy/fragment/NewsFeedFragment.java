package com.example.user.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.user.facebookcopy.R;
import com.example.user.facebookcopy.adapter.NewsFeedAdapter;
import com.example.user.facebookcopy.data.NewsFeedData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-04.
 */

public class NewsFeedFragment extends Fragment {
    private ListView newsFeedList;
    List<NewsFeedData> newsFeedDataList = new ArrayList<>();
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

        newsFeedDataList.add(new NewsFeedData("페이스북", "뉴스피드 리스트", 5, 3));
        newsFeedDataList.add(new NewsFeedData("트위터", "타임라인", 35, 10));
        newsFeedDataList.add(new NewsFeedData("인스타그램", "웅앵ㅇ웅", 50, 6));
        newsFeedDataList.add(new NewsFeedData("미미박스 memebox", "55% 초특가 할인! 슬림한 라인의 비결! " +
                "다리, 팔, 발 입체 안마기를 정말 저렴한 가격에 만나보세요!", 53, 10));
        newsFeedDataList.add(new NewsFeedData("다음모바일", "<다음 모바일 세상>에 숨어있는 다음의 모바일 서비스는 몇 개일까요?", 57, 28));

        newsFeedAdapter = new NewsFeedAdapter(getActivity(), newsFeedDataList);
        newsFeedList.setAdapter(newsFeedAdapter);
    }
}
