package com.news.zybertime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.news.zybertime.Adapter.DetailNewsViewPagerAdapter;
import com.news.zybertime.Model.DetailNewsModel;

import java.util.ArrayList;
import java.util.List;

public class DetailNewsActivity extends AppCompatActivity {

    private ImageView detailBackBtn;

    private ViewPager detailedViewPager;
    private List<DetailNewsModel> detailNewsModels = new ArrayList<>();
    private DetailNewsViewPagerAdapter detailNewsViewPagerAdapter;

    int[] imageArray = {R.drawable.sample_img_2, R.drawable.sample_img_3, R.drawable.sample_img_4, R.drawable.sample_img_5,
            R.drawable.sample_img_6, R.drawable.sample_img_7, R.drawable.sample_img_8, R.drawable.sample_img_1};
    String title = "Breaking News";
    String time = " Hours Ago";
    String head = "The public is helping us see Jupiter like it's never been seen before";
    String date = "3 Sep 2020 | 12 : 00 AM";
    String text = "From the outside, the agency may appear a monolith, but in reality, citizen " +
            "scientists can play a substantial role perhaps none more so than in the ongoing Juno " +
            "mission. Since 2016, the Juno spacecraft has circled Jupiter, scanning the atmosphere and " +
            "mapping its magnetic and gravitational fields. It's also carrying JunoCam, a camera " +
            "specifically designed to record images of the poles; areas of the gas giant not " +
            "previously well documented. We do not have a formal imaging science team on Juno, " +
            "so we have turned to the public to help us out, says Candice Hansen-Koharcheck, " +
            "Juno co-investigator responsible for JunoCam The amateur astronomy community assists " +
            "with planning, she explains, determining when JunoCam should photograph the planet " +
            "and where. Once images are sent back to Earth, the public has access to raw data, " +
            "which with a little photo editing know-how, have been processed into some of the most " +
            "stunning images yet seen of Jupiter.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        detailedViewPager = findViewById(R.id.detail_view_pager);
        detailBackBtn = findViewById(R.id.detail_front_btn);

        for (int d = 0; d < imageArray.length; d++) {
            detailNewsModels.add(new DetailNewsModel(imageArray[d], head, date, text));
        }

        setExtraViewPager(detailNewsModels);

        detailBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailNewsActivity.super.onBackPressed();
            }
        });
    }

    private void setExtraViewPager(List<DetailNewsModel> detailNewsModel) {
        detailNewsViewPagerAdapter = new DetailNewsViewPagerAdapter(detailNewsModel, this);
        detailedViewPager.setAdapter(detailNewsViewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}