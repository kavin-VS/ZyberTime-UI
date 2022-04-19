package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.MainCategoryModel;
import com.news.zybertime.R;

import java.util.List;

public class MainCategoryAdapter extends RecyclerView.Adapter<MainCategoryAdapter.ViewHolder> {

    List<MainCategoryModel> mainCategoryModels;
    MainCategoryClickListener mainCategoryClickListener;

    public MainCategoryAdapter(List<MainCategoryModel> mainCategoryModels, MainCategoryClickListener mainCategoryClickListener) {
        this.mainCategoryModels = mainCategoryModels;
        this.mainCategoryClickListener = mainCategoryClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_item_layout,
                parent, false);
        return new ViewHolder(view, mainCategoryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.catImage.setImageResource(mainCategoryModels.get(position).getCatImage());
        holder.catText.setText(mainCategoryModels.get(position).getCatTitle());

    }

    @Override
    public int getItemCount() {
        return mainCategoryModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView catImage;
        private TextView catText;

        MainCategoryClickListener mainCategoryClickListener;

        public ViewHolder(@NonNull View itemView, MainCategoryClickListener mainCategoryClickListener) {
            super(itemView);

            catImage = itemView.findViewById(R.id.category_card_image_view);
            catText = itemView.findViewById(R.id.category_title_text);

            this.mainCategoryClickListener = mainCategoryClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mainCategoryClickListener.MainCategoryClick(getAdapterPosition());
        }
    }

    public interface MainCategoryClickListener {
        void MainCategoryClick(int position);
    }
}
