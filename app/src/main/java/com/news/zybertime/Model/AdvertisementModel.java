package com.news.zybertime.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class AdvertisementModel {
    private int adImageView;
    private String adTextView;

    public AdvertisementModel(int adImageView, String adTextView) {
        this.adImageView = adImageView;
        this.adTextView = adTextView;
    }

    public int getAdImageView() {
        return adImageView;
    }

    public void setAdImageView(int adImageView) {
        this.adImageView = adImageView;
    }

    public String getAdTextView() {
        return adTextView;
    }

    public void setAdTextView(String adTextView) {
        this.adTextView = adTextView;
    }
}