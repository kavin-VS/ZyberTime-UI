package com.news.zybertime.Fonts;

import android.app.Application;

public class CustomFont extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "font/lato_regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "font/lato_regular.ttf");
    }
}
