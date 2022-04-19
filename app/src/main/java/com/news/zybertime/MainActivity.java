package com.news.zybertime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.news.zybertime.Adapter.MainCategoryAdapter;
import com.news.zybertime.Adapter.MainNewsAdapter;
import com.news.zybertime.Model.MainCategoryModel;
import com.news.zybertime.Model.MainNewsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainCategoryAdapter.MainCategoryClickListener {

    private RecyclerView mainCategoryRV;
    private List<MainCategoryModel> categoryModels = new ArrayList<>();
    private MainCategoryAdapter mainCategoryAdapter;

    private RecyclerView mainNewsRV;
    private List<MainNewsModel> mainNewsModels = new ArrayList<>();
    private MainNewsAdapter mainNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainCategoryRV = findViewById(R.id.main_category_recycle_view);
        mainNewsRV = findViewById(R.id.main_news_recycle_view);

        /*mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "2 Hours Ago"));
        mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "4 Hours Ago"));
        mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "6 Hours Ago"));
        mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "8 Hour Ago"));
        mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "10 Hours Ago"));
        mainNewsModels.add(new MainNewsModel(R.drawable.sample_img_1, "Breaking News",
                "Video games saved this man from the streets", "12 Hours Ago"));*/

//        categoryModels.add(new MainCategoryModel(R.drawable.icons_news_feed, "Daily Feeds"));
//        categoryModels.add(new MainCategoryModel(R.drawable.icons_fire, "Trending"));
//        categoryModels.add(new MainCategoryModel(R.drawable.icons_bookmark, "Bookmark"));
//        categoryModels.add(new MainCategoryModel(R.drawable.icons_blind, "Unread"));

        mainCategoryAdapter = new MainCategoryAdapter(categoryModels, this);
        LinearLayoutManager categoryLinearManager = new LinearLayoutManager(this);
        categoryLinearManager.setOrientation(RecyclerView.HORIZONTAL);
        mainCategoryRV.setLayoutManager(categoryLinearManager);
        mainCategoryRV.setAdapter(mainCategoryAdapter);

        /*mainNewsAdapter = new MainNewsAdapter(mainNewsModels);
        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(this);
        mainNewsRV.setLayoutManager(newsLayoutManager);
        mainNewsRV.setAdapter(mainNewsAdapter);*/

    }

    @Override
    public void MainCategoryClick(int position) {

    }
}