package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.MainLargeCategoryModel;
import com.news.zybertime.R;

import java.util.List;

public class MainLargeCategoryAdapter extends RecyclerView.Adapter<MainLargeCategoryAdapter.ViewHolder> {

    private List<MainLargeCategoryModel> mainLargeCategoryModels;
    private MainLargeCategoryClickListener mainLargeCategoryClickListener;

    public MainLargeCategoryAdapter(List<MainLargeCategoryModel> mainLargeCategoryModels,
                                    MainLargeCategoryClickListener mainLargeCategoryClickListener) {
        this.mainLargeCategoryModels = mainLargeCategoryModels;
        this.mainLargeCategoryClickListener = mainLargeCategoryClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_news_category_list_layout,
                parent, false);
        return new ViewHolder(view, mainLargeCategoryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.largeImageView.setImageResource(mainLargeCategoryModels.get(position).getLargeImageView());
        holder.largeTitle.setText(mainLargeCategoryModels.get(position).getLargeTitle());

    }

    @Override
    public int getItemCount() {
        return mainLargeCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView largeImageView;
        private TextView largeTitle;

        MainLargeCategoryClickListener mainLargeCategoryClickListener;

        public ViewHolder(@NonNull View itemView, MainLargeCategoryClickListener mainLargeCategoryClickListener) {
            super(itemView);

            largeImageView = itemView.findViewById(R.id.large_cat_image_view);
            largeTitle = itemView.findViewById(R.id.news_cat_large_title);

            this.mainLargeCategoryClickListener = mainLargeCategoryClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mainLargeCategoryClickListener.MainLargeCategoryClick(getAdapterPosition());
        }
    }

    public interface MainLargeCategoryClickListener {
        void MainLargeCategoryClick(int position);
    }

}
