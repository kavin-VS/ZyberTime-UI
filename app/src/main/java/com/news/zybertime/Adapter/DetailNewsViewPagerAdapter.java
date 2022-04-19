package com.news.zybertime.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.news.zybertime.DashBoardActivity;
import com.news.zybertime.Model.DetailNewsModel;
import com.news.zybertime.R;

import java.util.List;

public class DetailNewsViewPagerAdapter extends PagerAdapter {

    private List<DetailNewsModel> detailNewsModels;
    private Context context;

    public DetailNewsViewPagerAdapter(List<DetailNewsModel> detailNewsModels, Context context) {
        this.detailNewsModels = detailNewsModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return detailNewsModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final View view = LayoutInflater.from(context).inflate(R.layout.detailed_news_layout, container, false);

        final Dialog fullScreenImage;
        ImageView closeBtn;
        final TextView dialogTitle;

        ImageView topADView;
        ImageView belowADView;

        final ImageView detailImage;
        final ImageView fullScreenDialogImage;
        TextView detailTitle;
        TextView detailDateTime;
        TextView detailReason;
        final ImageView detailBookmark;
        final ImageView detailShareBtn;

        fullScreenImage = new Dialog(context, R.style.AppTheme_Dialog);
        fullScreenImage.setContentView(R.layout.full_screen_image_layout);
        fullScreenImage.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        fullScreenImage.setCancelable(true);
        fullScreenDialogImage = fullScreenImage.findViewById(R.id.detail_image_full_screen);
        closeBtn = fullScreenImage.findViewById(R.id.image_dialog_close_btn);
        dialogTitle = fullScreenImage.findViewById(R.id.dialog_news_title);

        topADView = view.findViewById(R.id.detail_adView_top);
        belowADView = view.findViewById(R.id.detail_adView_below);

        detailImage = view.findViewById(R.id.detail_image_view);
        detailTitle = view.findViewById(R.id.detail_title_text);
        detailDateTime = view.findViewById(R.id.detail_news_date_time_text);
        detailReason = view.findViewById(R.id.detail_reason_text);
        detailBookmark = view.findViewById(R.id.detail_bookmark_btn);
        detailShareBtn = view.findViewById(R.id.share_detail_news_btn);

        detailImage.setImageResource(detailNewsModels.get(position).getDetailNewsImage());
        detailTitle.setText(detailNewsModels.get(position).getDetailNewsTitle());
        detailDateTime.setText(detailNewsModels.get(position).getDetailDateTime());
        detailReason.setText("\t\t\t\t\t\t" + detailNewsModels.get(position).getDetailNewsText());

        /*if (detailNewsModels.get(position).isBookmarked()) {
            detailBookmark.setImageResource(R.drawable.ic_bookmark_filled);
        } else {
            detailBookmark.setImageResource(R.drawable.ic_bookmark_outline);
        }*/

        /*fullScreenDialogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreenImage.dismiss();
            }
        });*/

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreenImage.dismiss();
            }
        });

        detailImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullScreenImage.show();
                fullScreenDialogImage.setImageResource(detailNewsModels.get(position)
                        .getDetailNewsImage());
                dialogTitle.setText(detailNewsModels.get(position).getDetailNewsTitle());
            }
        });

        detailBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailNewsModels.get(position).isBookmarked()) {
                    detailBookmark.setImageResource(R.drawable.ic_bookmark_outline);
                    detailNewsModels.get(position).setBookmarked(false);
                    Toast.makeText(context, "Bookmark Removed", Toast.LENGTH_SHORT).show();
                } else {
                    detailBookmark.setImageResource(R.drawable.ic_bookmark_filled);
                    detailNewsModels.get(position).setBookmarked(true);
                    Toast.makeText(context, "Bookmarked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        detailShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                String text = "ZYBER NEWS \n\n\t" + detailNewsModels.get(position)
                        .getDetailNewsTitle() + "\n\n Download Now";

                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, view.getResources().getString(R.string.share_text));
                share.putExtra(Intent.EXTRA_TEXT, text);

                view.getContext().startActivity(Intent.createChooser(share, view.getResources().getString(R.string.share_text)));
            }
        });

        topADView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(i);
            }
        });

        belowADView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(i);
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}