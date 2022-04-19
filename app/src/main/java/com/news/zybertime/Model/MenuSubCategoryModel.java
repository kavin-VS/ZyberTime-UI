package com.news.zybertime.Model;

import android.widget.TextView;

public class MenuSubCategoryModel {
    private String subCatText;

    public MenuSubCategoryModel(String subCatText) {
        this.subCatText = subCatText;
    }

    public String getSubCatText() {
        return subCatText;
    }

    public void setSubCatText(String subCatText) {
        this.subCatText = subCatText;
    }
}
