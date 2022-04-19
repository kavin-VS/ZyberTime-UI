package com.news.zybertime.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.news.zybertime.DashBoardActivity;
import com.news.zybertime.Model.BannerSliderModel;
import com.news.zybertime.Model.MainNewsBannerModel;
import com.news.zybertime.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.news.zybertime.DashBoardActivity.dashNewsVP;
import static com.news.zybertime.DashBoardActivity.dashViewFlipper;

public class BannerSliderAdapter extends PagerAdapter {

    private List<MainNewsBannerModel> mainNewsBannerModels;

    public BannerSliderAdapter(List<MainNewsBannerModel> mainNewsBannerModels) {
        this.mainNewsBannerModels = mainNewsBannerModels;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.main_banner_news_layout,
                container, false);

        ImageView imageView = view.findViewById(R.id.banner_image_view);
        TextView bannerTitle = view.findViewById(R.id.banner_title);
        TextView bannerReason = view.findViewById(R.id.banner_reason);

        imageView.setImageResource(mainNewsBannerModels.get(position).getBannerImage());
        bannerTitle.setText(mainNewsBannerModels.get(position).getBannerTitle());
        bannerReason.setText(mainNewsBannerModels.get(position).getBannerReason());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dashViewFlipper.setInAnimation(container.getContext(), R.anim.slide_in_right);
                dashViewFlipper.setOutAnimation(container.getContext(), R.anim.slide_out_left);
                dashViewFlipper.showNext();
                dashNewsVP.setCurrentItem(position);
            }
        });

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mainNewsBannerModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
