package com.news.zybertime.Model;

import java.util.List;

public class HomePageModel {

    public static final int AD_VIEW = 0;
    public static final int MAIN_NEWS = 1;

    private int type;


    //TODO: AD VIEW ################################################################################

    private List<AdvertisementModel> advertisementModels;
    private String adBGColor;

    public HomePageModel(int type, List<AdvertisementModel> advertisementModels, String adBGColor) {
        this.type = type;
        this.advertisementModels = advertisementModels;
        this.adBGColor = adBGColor;
    }

    public List<AdvertisementModel> getAdvertisementModels() {
        return advertisementModels;
    }

    public void setAdvertisementModels(List<AdvertisementModel> advertisementModels) {
        this.advertisementModels = advertisementModels;
    }

    public String getAdBGColor() {
        return adBGColor;
    }

    public void setAdBGColor(String adBGColor) {
        this.adBGColor = adBGColor;
    }

    //TODO: AD VIEW ################################################################################

    //TODO: BANNER SLIDER###########################################################################

    private List<MainNewsBannerModel> mainNewsBannerModels;

    public HomePageModel(int type, List<MainNewsBannerModel> mainNewsBannerModels) {
        this.type = type;
        this.mainNewsBannerModels = mainNewsBannerModels;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<MainNewsBannerModel> getMainNewsBannerModels() {
        return mainNewsBannerModels;
    }

    public void setMainNewsBannerModels(List<MainNewsBannerModel> mainNewsBannerModels) {
        this.mainNewsBannerModels = mainNewsBannerModels;
    }

    //TODO: BANNER SLIDER###########################################################################

    //TODO: NEWS SLIDER###########################################################################

    private int temp;
    private List<MainNewsModel> mainNewsModels;

    public HomePageModel(int type, int temp, List<MainNewsModel> mainNewsModels) {
        this.type = type;
        this.temp = temp;
        this.mainNewsModels = mainNewsModels;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public List<MainNewsModel> getMainNewsModels() {
        return mainNewsModels;
    }

    public void setMainNewsModels(List<MainNewsModel> mainNewsModels) {
        this.mainNewsModels = mainNewsModels;
    }

    //TODO: NEWS SLIDER###########################################################################

}
