package com.news.zybertime.Model;

public class MainLargeCategoryModel {

    private int largeImageView;
    private String largeTitle;

    public MainLargeCategoryModel(int largeImageView, String largeTitle) {
        this.largeImageView = largeImageView;
        this.largeTitle = largeTitle;
    }

    public int getLargeImageView() {
        return largeImageView;
    }

    public void setLargeImageView(int largeImageView) {
        this.largeImageView = largeImageView;
    }

    public String getLargeTitle() {
        return largeTitle;
    }

    public void setLargeTitle(String largeTitle) {
        this.largeTitle = largeTitle;
    }
}
