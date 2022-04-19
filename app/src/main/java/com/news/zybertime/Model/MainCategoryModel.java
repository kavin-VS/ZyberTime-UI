package com.news.zybertime.Model;

import android.widget.ImageView;
import android.widget.TextView;

public class MainCategoryModel {

    private int catImage;
    private String catTitle;

    public MainCategoryModel(int catImage, String catTitle) {
        this.catImage = catImage;
        this.catTitle = catTitle;
    }

    public int getCatImage() {
        return catImage;
    }

    public void setCatImage(int catImage) {
        this.catImage = catImage;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }
}
