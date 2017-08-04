package com.example.user.facebookcopy.data;

/**
 * Created by user on 2017-08-04.
 */

public class NewsFeedData {
    String userName;
    String text;
    int writeTime;
    int likeCount;

    public NewsFeedData() {
    }

    public NewsFeedData(String userName, String text, int writeTime, int likeCount) {
        this.userName = userName;
        this.text = text;
        this.writeTime = writeTime;
        this.likeCount = likeCount;
    }

    public int getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(int writeTime) {
        this.writeTime = writeTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
