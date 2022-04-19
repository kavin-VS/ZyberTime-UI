package com.news.zybertime.Model;

public class MainNewsBannerModel {

    private int bannerImage;
    private String bannerTitle;
    private String bannerReason;

    public MainNewsBannerModel(int bannerImage, String bannerTitle, String bannerReason) {
        this.bannerImage = bannerImage;
        this.bannerTitle = bannerTitle;
        this.bannerReason = bannerReason;
    }

    public int getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(int bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerReason() {
        return bannerReason;
    }

    public void setBannerReason(String bannerReason) {
        this.bannerReason = bannerReason;
    }
}
