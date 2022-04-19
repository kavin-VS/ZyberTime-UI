package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.DetailNewsModel;
import com.news.zybertime.R;

import java.util.List;

public class DetailNewsAdapter extends RecyclerView.Adapter<DetailNewsAdapter.ViewHolder> {

    private List<DetailNewsModel> detailNewsModels;

    public DetailNewsAdapter(List<DetailNewsModel> detailNewsModels) {
        this.detailNewsModels = detailNewsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_news_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.detailImageView.setImageResource(detailNewsModels.get(position).getDetailNewsImage());
        holder.detailTitle.setText(detailNewsModels.get(position).getDetailNewsTitle());
        holder.detailReason.setText(detailNewsModels.get(position).getDetailNewsText());

    }

    @Override
    public int getItemCount() {
        return detailNewsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView detailImageView;
        private TextView detailTitle;
        private TextView detailReason;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            detailImageView = itemView.findViewById(R.id.detail_image_view);
            detailTitle = itemView.findViewById(R.id.detail_title_text);
            detailReason = itemView.findViewById(R.id.detail_reason_text);

        }
    }
}
