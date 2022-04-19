package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.MainNewsBannerModel;
import com.news.zybertime.R;

import java.util.List;

public class MainNewsBannerAdapter extends RecyclerView.Adapter<MainNewsBannerAdapter.ViewHolder> {

    private List<MainNewsBannerModel> mainNewsBannerModels;
    private BannerClickListener bannerClickListener;

    public MainNewsBannerAdapter(List<MainNewsBannerModel> mainNewsBannerModels,
                                 BannerClickListener bannerClickListener) {
        this.mainNewsBannerModels = mainNewsBannerModels;
        this.bannerClickListener = bannerClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_banner_news_layout
                , parent, false);
        return new ViewHolder(view, bannerClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bannerImage.setImageResource(mainNewsBannerModels.get(position).getBannerImage());
        holder.bannerTitle.setText(mainNewsBannerModels.get(position).getBannerTitle());
        holder.bannerReason.setText(mainNewsBannerModels.get(position).getBannerReason());
    }

    @Override
    public int getItemCount() {
        return mainNewsBannerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView bannerImage;
        private TextView bannerTitle;
        private TextView bannerReason;

        BannerClickListener bannerClickListener;

        public ViewHolder(@NonNull View itemView, BannerClickListener bannerClickListener) {
            super(itemView);

            bannerImage = itemView.findViewById(R.id.banner_image_view);
            bannerTitle = itemView.findViewById(R.id.banner_title);
            bannerReason = itemView.findViewById(R.id.banner_reason);

            this.bannerClickListener = bannerClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            bannerClickListener.BannerClickListener(getAdapterPosition());
        }
    }

    public interface BannerClickListener {
        void BannerClickListener(int position);
    }
}
