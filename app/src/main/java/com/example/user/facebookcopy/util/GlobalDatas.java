package com.example.user.facebookcopy.util;

import com.example.user.facebookcopy.data.FriendRequestData;
import com.example.user.facebookcopy.data.MessageData;
import com.example.user.facebookcopy.data.NewsFeedData;
import com.example.user.facebookcopy.data.NotificationData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-08.
 */

public class GlobalDatas {
    public static List<FriendRequestData> friendRequestDatas = new ArrayList<>();
    public static List<NotificationData> notificationDatas = new ArrayList<>();
    public static List<NewsFeedData> newsFeedDatas = new ArrayList<>();
    public static List<MessageData> messageDatas = new ArrayList<>();

    public static void initDatas() {
        friendRequestDatas.clear();
        friendRequestDatas.add(new FriendRequestData("", 7, "고동윤"));
        friendRequestDatas.add(new FriendRequestData("", 2, "권성민"));
        friendRequestDatas.add(new FriendRequestData("", 5, "김현철"));
        friendRequestDatas.add(new FriendRequestData("", 8, "박석영"));
        friendRequestDatas.add(new FriendRequestData("", 3, "박수현"));
        friendRequestDatas.add(new FriendRequestData("", 9, "박영주"));
        friendRequestDatas.add(new FriendRequestData("", 10, "손익상"));
        friendRequestDatas.add(new FriendRequestData("", 1, "이승헌"));
        friendRequestDatas.add(new FriendRequestData("", 4, "이요한"));
        friendRequestDatas.add(new FriendRequestData("", 6, "최종환"));
        friendRequestDatas.add(new FriendRequestData("", 11, "한상열"));

        notificationDatas.clear();
        notificationDatas.add(new NotificationData("", "10명이 내 글을 좋아합니다.", 1, 1));
        notificationDatas.add(new NotificationData("", "--가 내 글에 댓글을 남겼습니다.", 2, 40));
        notificationDatas.add(new NotificationData("", "--가 회원님을 팔로우합니다.", 3, 70));
        notificationDatas.add(new NotificationData("", "--가 내 댓글을 좋아합니다.", 4, 230));
        notificationDatas.add(new NotificationData("", "--가 친구 요청을 수락했습니다.", 5, 600));

        newsFeedDatas.clear();
        newsFeedDatas.add(new NewsFeedData("http://www.naver.com", "", 2, "네이버로 링크를 걸어주는 뉴스피드입니다.", 12));
        newsFeedDatas.add(new NewsFeedData("http://www.google.com", "", 10, "구글로 링크를 걸어주는 뉴스피드입니다.", 5));
        newsFeedDatas.add(new NewsFeedData("", "", 45, "글만 적힌 뉴스피드", 125));
        newsFeedDatas.add(new NewsFeedData("", "", 230, "사진 올린 뉴스피드", 2453));
        newsFeedDatas.add(new NewsFeedData("", "", 800, "동영상 뉴스피드", 121371));
    }
}
