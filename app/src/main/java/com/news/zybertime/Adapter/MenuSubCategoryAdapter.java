package com.news.zybertime.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.zybertime.Model.MenuSubCategoryModel;
import com.news.zybertime.R;

import java.util.List;

public class MenuSubCategoryAdapter extends RecyclerView.Adapter<MenuSubCategoryAdapter.ViewHolder> {

    private List<MenuSubCategoryModel> menuSubCategoryModels;
    private MenuItemClickListener menuItemClickListener;

    public MenuSubCategoryAdapter(List<MenuSubCategoryModel> menuSubCategoryModels, MenuItemClickListener menuItemClickListener) {
        this.menuSubCategoryModels = menuSubCategoryModels;
        this.menuItemClickListener = menuItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_text_view_layout,
                parent, false);
        return new ViewHolder(view, menuItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subCatText.setText(menuSubCategoryModels.get(position).getSubCatText());
    }

    @Override
    public int getItemCount() {
        return menuSubCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView subCatText;
        private MenuItemClickListener menuItemClickListener;

        public ViewHolder(@NonNull View itemView, MenuItemClickListener menuItemClickListener) {
            super(itemView);

            subCatText = itemView.findViewById(R.id.spinner_item_text);
            this.menuItemClickListener = menuItemClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            menuItemClickListener.MenuItemClickListener(getAdapterPosition());
        }
    }

    public interface MenuItemClickListener {
        void MenuItemClickListener(int position);
    }

}
