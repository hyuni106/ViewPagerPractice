package com.example.user.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by user on 2017-08-09.
 */

public class ReplyData {
    int replyId;
    int parentReplyId;
    // 0이면 그냥 댓글, 그 외에는 대댓글
    private String name;
    private String comment;
    Calendar createdAt;

    public ReplyData() {
    }

    public ReplyData(int replyId, int parentReplyId, String name, String comment, Calendar createdAt) {
        this.replyId = replyId;
        this.parentReplyId = parentReplyId;
        this.name = name;
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(int parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }
}
