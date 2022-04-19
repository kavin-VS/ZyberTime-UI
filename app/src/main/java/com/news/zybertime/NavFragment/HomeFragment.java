package com.news.zybertime.NavFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.news.zybertime.Adapter.MainCategoryAdapter;
import com.news.zybertime.Adapter.MainLargeCategoryAdapter;
import com.news.zybertime.DashBoardActivity;
import com.news.zybertime.DetailNewsActivity;
import com.news.zybertime.MainCategoryActivity;
import com.news.zybertime.Model.MainCategoryModel;
import com.news.zybertime.Model.MainLargeCategoryModel;
import com.news.zybertime.R;

import java.util.ArrayList;
import java.util.List;

import static com.news.zybertime.DashBoardActivity.bannerViewPager;
import static com.news.zybertime.DashBoardActivity.dashNewsVP;
import static com.news.zybertime.DashBoardActivity.dashViewFlipper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment
        implements MainLargeCategoryAdapter.MainLargeCategoryClickListener,
        MainCategoryAdapter.MainCategoryClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //TODO: Models And Adapters ##############

    private RecyclerView mainCatRV;
    private List<MainCategoryModel> categoryModels = new ArrayList<>();
    private MainCategoryAdapter mainCategoryAdapter;

    private RecyclerView largeCatRV;
    private List<MainLargeCategoryModel> mainLargeCategoryModels = new ArrayList<>();
    private MainLargeCategoryAdapter mainLargeCategoryAdapter;

    //TODO: Models And Adapters ##############

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainCatRV = view.findViewById(R.id.home_small_cat_recycle_view);
        largeCatRV = view.findViewById(R.id.home_large_cat_recycle_view);

        //TODO: Model Assign########################################################################

        categoryModels.add(new MainCategoryModel(R.drawable.ic_feeds, "Daily Feeds"));
        categoryModels.add(new MainCategoryModel(R.drawable.ic_popular, "Trending"));
        categoryModels.add(new MainCategoryModel(R.drawable.ic_bookmark_blacked, "Bookmark"));
        categoryModels.add(new MainCategoryModel(R.drawable.ic_pending, "Unread"));

        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_virus,
                "Covid-19"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_mumbai,
                "India - News Updates"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_chip,
                "Technology"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_tools,
                "Automobile"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_trophy,
                "Sports"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_statistics,
                "Business"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_cinema,
                "Entertainment"));
        mainLargeCategoryModels.add(new MainLargeCategoryModel(R.drawable.ic_diploma,
                "Education"));

        //TODO: Model Assign #######################################################################

        //TODO: Adapter Assign #####################################################################

        setCategoryView(categoryModels);

        setMainLargeCategoryView(mainLargeCategoryModels);

        //TODO: Adapter Assign######################################################################

        return view;
    }

    @Override
    public void MainLargeCategoryClick(int position) {
        mainLargeCategoryModels.get(position);
        Intent i = new Intent(getContext(), DashBoardActivity.class);
        i.putExtra("Detail_Menu_Title", mainLargeCategoryModels.get(position).getLargeTitle());
        startActivity(i);
    }

    @Override
    public void MainCategoryClick(int position) {
        categoryModels.get(position);

        Intent i;
        if (position == 0) {
            i = new Intent(getContext(), DashBoardActivity.class);
            i.putExtra("Detail_Menu_Title", categoryModels.get(position).getCatTitle());
        } else {
            i = new Intent(getContext(), DetailNewsActivity.class);
        }
        startActivity(i);
    }

    private void setMainLargeCategoryView(List<MainLargeCategoryModel> mainLargeCategoryModels) {

        mainLargeCategoryAdapter = new MainLargeCategoryAdapter(mainLargeCategoryModels,
                this);
        GridLayoutManager largeManager = new GridLayoutManager(getContext(), 2,
                RecyclerView.VERTICAL, false);
        largeCatRV.setNestedScrollingEnabled(false);
        largeCatRV.setLayoutManager(largeManager);
        largeCatRV.setAdapter(mainLargeCategoryAdapter);
    }

    private void setCategoryView(List<MainCategoryModel> categoryModels) {

        mainCategoryAdapter = new MainCategoryAdapter(categoryModels, this);
        GridLayoutManager categoryManager = new GridLayoutManager(getContext(), 4,
                RecyclerView.VERTICAL, false);
        mainCatRV.setLayoutManager(categoryManager);
        mainCatRV.setAdapter(mainCategoryAdapter);

    }
}