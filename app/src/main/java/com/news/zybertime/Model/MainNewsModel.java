package com.news.zybertime.Model;

import android.widget.ImageView;

public class MainNewsModel {

    private int newsImage;
    private String newsHeadline;
    private String newsReason;
    private String newsUploadedTime;
    private boolean bookmarked;
    private boolean setAD;

    public MainNewsModel(int newsImage, String newsHeadline, String newsReason, String newsUploadedTime, boolean bookmarked, boolean setAD) {
        this.newsImage = newsImage;
        this.newsHeadline = newsHeadline;
        this.newsReason = newsReason;
        this.newsUploadedTime = newsUploadedTime;
        this.bookmarked = bookmarked;
        this.setAD = setAD;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(int newsImage) {
        this.newsImage = newsImage;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public void setNewsHeadline(String newsHeadline) {
        this.newsHeadline = newsHeadline;
    }

    public String getNewsReason() {
        return newsReason;
    }

    public void setNewsReason(String newsReason) {
        this.newsReason = newsReason;
    }

    public String getNewsUploadedTime() {
        return newsUploadedTime;
    }

    public void setNewsUploadedTime(String newsUploadedTime) {
        this.newsUploadedTime = newsUploadedTime;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public boolean isSetAD() {
        return setAD;
    }

    public void setSetAD(boolean setAD) {
        this.setAD = setAD;
    }
}
