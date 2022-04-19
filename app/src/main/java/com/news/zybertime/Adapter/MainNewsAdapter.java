package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.MainNewsModel;
import com.news.zybertime.R;

import java.util.List;

public class MainNewsAdapter extends RecyclerView.Adapter<MainNewsAdapter.ViewHolder> {

    private List<MainNewsModel> mainNewsModels;
    private MainNewsClickListener mainNewsClickListener;

    public MainNewsAdapter(List<MainNewsModel> mainNewsModels, MainNewsClickListener mainNewsClickListener) {
        this.mainNewsModels = mainNewsModels;
        this.mainNewsClickListener = mainNewsClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_news_card_layout,
                parent, false);
        return new ViewHolder(view, mainNewsClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.newsImage.setImageResource(mainNewsModels.get(position).getNewsImage());
        holder.newsHeadlines.setText(mainNewsModels.get(position).getNewsHeadline());
        holder.newsReason.setText(mainNewsModels.get(position).getNewsReason());
        holder.newsUploadedTime.setText(mainNewsModels.get(position).getNewsUploadedTime());

        holder.favIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainNewsModels.get(position).isBookmarked()) {
                    holder.favIcon.setImageResource(R.drawable.ic_bookmark_outline);
                    mainNewsModels.get(position).setBookmarked(false);
                    Toast.makeText(holder.itemView.getContext(), "Bookmark Removed", Toast.LENGTH_SHORT).show();
                } else {
                    holder.favIcon.setImageResource(R.drawable.ic_bookmark_filled);
                    mainNewsModels.get(position).setBookmarked(true);
                    Toast.makeText(holder.itemView.getContext(), "Bookmarked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainNewsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView newsImage;
        private TextView newsHeadlines;
        private TextView newsReason;
        private TextView newsUploadedTime;
        private ImageView favIcon;

        MainNewsClickListener mainNewsClickListener;

        public ViewHolder(@NonNull View itemView, MainNewsClickListener mainNewsClickListener) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.main_news_card_image_view);
            newsHeadlines = itemView.findViewById(R.id.main_news_title_text);
            newsReason = itemView.findViewById(R.id.main_news_reason_text);
            newsUploadedTime = itemView.findViewById(R.id.main_news_uploaded_time);
            favIcon = itemView.findViewById(R.id.news_fav_icon_btn);

            this.mainNewsClickListener = mainNewsClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mainNewsClickListener.MainNewsClickListener(getAdapterPosition());
        }
    }

    public interface MainNewsClickListener {
        void MainNewsClickListener(int position);
    }

}
