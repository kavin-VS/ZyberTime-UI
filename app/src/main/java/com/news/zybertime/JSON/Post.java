package com.news.zybertime.JSON;

import com.google.gson.annotations.SerializedName;

public class Post {

    private Integer id;
    private String userId;
    private String userPass;
    private String fullName;
    private String phoneNum;
    private String location;

    @SerializedName("body")
    private String text;

    public Post(String userId, String userPass, String fullName,
                String phoneNum, String location) {

        this.userId = userId;
        this.userPass = userPass;
        this.fullName = fullName;
        this.phoneNum = phoneNum;
        this.location = location;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIds() {
        return id;
    }

    public String getText() {
        return text;
    }
}
