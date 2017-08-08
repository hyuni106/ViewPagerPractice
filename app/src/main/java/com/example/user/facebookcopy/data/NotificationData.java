package com.example.user.facebookcopy.data;

/**
 * Created by user on 2017-08-08.
 */

public class NotificationData {
    private String imgPath;
    private String notiMessage;
    private int notiType;
    // 1 : -가 댓글을 남겼습니다.
    // 2 : -가 내 글을 좋아합니다.
    private int minuteAgo;
    // 2분 이내 : 방금 전, 2-59분 : n분 전, 60~119분 : 1시간 전
//    private Calendar createAt; // 실제로 적합한 방법

    public NotificationData() {
    }

    public NotificationData(String imgPath, String notiMessage, int notiType, int minuteAgo) {
        this.imgPath = imgPath;
        this.notiMessage = notiMessage;
        this.notiType = notiType;
        this.minuteAgo = minuteAgo;
    }

    public int getNotiType() {
        return notiType;
    }

    public void setNotiType(int notiType) {
        this.notiType = notiType;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getNotiMessage() {
        return notiMessage;
    }

    public void setNotiMessage(String notiMessage) {
        this.notiMessage = notiMessage;
    }

    public int getNotiTime() {
        return minuteAgo;
    }

    public void setNotiTime(int notiTime) {
        this.minuteAgo = notiTime;
    }
}
