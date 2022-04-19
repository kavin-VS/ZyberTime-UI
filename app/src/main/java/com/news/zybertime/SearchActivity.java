package com.news.zybertime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;

    ArrayList<String> searchList;

    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchList = new ArrayList<String>();

        String[] a = getResources().getStringArray(R.array.india_states);

        searchList.addAll(Arrays.asList(a));

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, searchList);

        searchView = findViewById(R.id.search_view);
        linearLayout = findViewById(R.id.not_founded_frame);
        recyclerView = findViewById(R.id.search_recycle_view);

        recyclerView.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}