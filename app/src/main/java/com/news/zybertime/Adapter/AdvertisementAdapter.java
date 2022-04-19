package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.AdvertisementModel;
import com.news.zybertime.R;

import java.util.List;

public class AdvertisementAdapter extends RecyclerView.Adapter<AdvertisementAdapter.ViewHolder> {

    private List<AdvertisementModel> advertisementModels;

    public AdvertisementAdapter(List<AdvertisementModel> advertisementModels) {
        this.advertisementModels = advertisementModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medium_ad_view_layout,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.adImageView.setImageResource(advertisementModels.get(position).getAdImageView());
        holder.adTextView.setText(advertisementModels.get(position).getAdTextView());
    }

    @Override
    public int getItemCount() {
        return advertisementModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView adImageView;
        private TextView adTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            adImageView = itemView.findViewById(R.id.med_ad_image_view);
            adTextView = itemView.findViewById(R.id.med_ad_text_view);

        }
    }
}
