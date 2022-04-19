package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.AdvertisementModel;
import com.news.zybertime.Model.HomePageModel;
import com.news.zybertime.Model.MainNewsBannerModel;
import com.news.zybertime.Model.MainNewsModel;
import com.news.zybertime.R;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModels;

    public HomePageAdapter(List<HomePageModel> homePageModels) {
        this.homePageModels = homePageModels;
    }

    @Override
    public int getItemViewType(int position) {

        switch (homePageModels.get(position).getType()) {
            case 0:
                return HomePageModel.AD_VIEW;
            case 1:
                return HomePageModel.MAIN_NEWS;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case HomePageModel.AD_VIEW:
                View adView = LayoutInflater.from(parent.getContext()).inflate(R.layout.medium_ad_view_layout, parent, false);
                return new ADViewHolder(adView);
            case HomePageModel.MAIN_NEWS:
                View newsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_news_card_layout, parent, false);
                return new MainNewsViewHolder(newsView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (homePageModels.get(position).getType()) {

            case HomePageModel.AD_VIEW:
                List<AdvertisementModel> advertisementModels = homePageModels.get(position).getAdvertisementModels();
                ((ADViewHolder) holder).adImage.setImageResource(advertisementModels.get(position).getAdImageView());
                ((ADViewHolder) holder).adTitle.setText(advertisementModels.get(position).getAdTextView());
                break;

            case HomePageModel.MAIN_NEWS:
                List<MainNewsModel> mainNewsModels = homePageModels.get(position).getMainNewsModels();
                ((MainNewsViewHolder) holder).newsImage.setImageResource(mainNewsModels.get(position).getNewsImage());
                ((MainNewsViewHolder) holder).newsHeadlines.setText(mainNewsModels.get(position).getNewsHeadline());
                ((MainNewsViewHolder) holder).newsReason.setText(mainNewsModels.get(position).getNewsReason());
                ((MainNewsViewHolder) holder).newsUploadedTime.setText(mainNewsModels.get(position).getNewsUploadedTime());
                break;

            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModels.size();
    }

    public static class ADViewHolder extends RecyclerView.ViewHolder {

        private ImageView adImage;
        private TextView adTitle;

        public ADViewHolder(@NonNull View itemView) {
            super(itemView);
            adImage = itemView.findViewById(R.id.med_ad_image_view);
            adTitle = itemView.findViewById(R.id.med_ad_text_view);
        }
    }

    public static class MainNewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView newsImage;
        private TextView newsHeadlines;
        private TextView newsReason;
        private TextView newsUploadedTime;
        private ImageView favIcon;

        public MainNewsViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.main_news_card_image_view);
            newsHeadlines = itemView.findViewById(R.id.main_news_title_text);
            newsReason = itemView.findViewById(R.id.main_news_reason_text);
            newsUploadedTime = itemView.findViewById(R.id.main_news_uploaded_time);
            favIcon = itemView.findViewById(R.id.news_fav_icon_btn);

        }
    }
}
