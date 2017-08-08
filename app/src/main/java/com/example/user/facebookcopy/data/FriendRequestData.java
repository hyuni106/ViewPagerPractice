package com.example.user.facebookcopy.data;

/**
 * Created by user on 2017-08-08.
 */

public class FriendRequestData {
    private String imgPath;
    private int commonFriendCount;
    private String name;

    public FriendRequestData() {
    }

    public FriendRequestData(String imgPath, int commonFriendCount, String name) {
        this.imgPath = imgPath;
        this.commonFriendCount = commonFriendCount;
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getCommonFriendCount() {
        return commonFriendCount;
    }

    public void setCommonFriendCount(int commonFriendCount) {
        this.commonFriendCount = commonFriendCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
