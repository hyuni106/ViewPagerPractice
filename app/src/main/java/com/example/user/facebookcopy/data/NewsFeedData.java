package com.example.user.facebookcopy.data;

/**
 * Created by user on 2017-08-04.
 */

public class NewsFeedData {
    private String linkUrl;
    private String userImgPath;
    private int minuteAgo;
    private String contentTxt;
    private int likeCount;

    public NewsFeedData() {
    }

    public NewsFeedData(String linkUrl, String userImgPath, int minuteAgo, String contentTxt, int likeCount) {
        this.linkUrl = linkUrl;
        this.userImgPath = userImgPath;
        this.minuteAgo = minuteAgo;
        this.contentTxt = contentTxt;
        this.likeCount = likeCount;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getUserImgPath() {
        return userImgPath;
    }

    public void setUserImgPath(String userImgPath) {
        this.userImgPath = userImgPath;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }

    public String getContentTxt() {
        return contentTxt;
    }

    public void setContentTxt(String contentTxt) {
        this.contentTxt = contentTxt;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
