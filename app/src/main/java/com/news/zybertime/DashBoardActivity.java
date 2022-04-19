package com.news.zybertime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.news.zybertime.Adapter.AdvertisementAdapter;
import com.news.zybertime.Adapter.BannerSliderAdapter;
import com.news.zybertime.Adapter.DetailNewsViewPagerAdapter;
import com.news.zybertime.Adapter.HomePageAdapter;
import com.news.zybertime.Adapter.MainNewsAdapter;
import com.news.zybertime.Adapter.MenuSubCategoryAdapter;
import com.news.zybertime.Model.AdvertisementModel;
import com.news.zybertime.Model.DetailNewsModel;
import com.news.zybertime.Model.HomePageModel;
import com.news.zybertime.Model.MainNewsBannerModel;
import com.news.zybertime.Model.MainNewsModel;
import com.news.zybertime.Model.MenuSubCategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DashBoardActivity extends AppCompatActivity implements MainNewsAdapter.MainNewsClickListener,
        MenuSubCategoryAdapter.MenuItemClickListener {

    public static ViewFlipper dashViewFlipper;
    private ImageView dashMenuBtn, dashBackBtn, dashFrontBtn, dashSearchBtn, mainLogo;

    private SwipeRefreshLayout swipeRefreshLayout;
    private BottomSheetDialog bottomSheetDialog;

    //TODO: ONE MAIN FLIPPER  ##### 1 #####

    //TODO: BANNER SLIDER

    public static ViewPager bannerViewPager;
    private List<MainNewsBannerModel> bannerSliderModels = new ArrayList<>();

    private int currentPage = 0;
    private Timer timer;
    final private long DELAY_TIME = 300;
    final private long PERIOD_TIME = 3000;
    private List<MainNewsBannerModel> arrangedList = new ArrayList<>();

    //TODO: BANNER SLIDER

    private Dialog loadingDialog;
    private ImageView backgroundAdView1;
    private View mainADViewClick;

    //TODO: ONE MAIN FLIPPER  ##### 1 #####


    //TODO: TWO DETAIL FLIPPER  ##### 2 #####

    public static int height, width;
    private ImageView topADView;

    //TODO:TWO DETAIL FLIPPER  ##### 2 #####


    //TODO: THREE MENU FLIPPER  ##### 3 #####
    private TextView menuSubCatResult;
    private TextView menuTitle;

    //TODO: THREE MENU FLIPPER  ##### 3 #####

//    private Spinner subCatSpinner;
//    List<String> spinnerItem = new ArrayList<>(R.array.india_states);
//    private DetailNewsAdapter detailNewsAdapter;
//    private RecyclerView dashDetailNewsRV;

    //TODO: Adapters and Models
    private RecyclerView menuSubCatRV;
    private List<MenuSubCategoryModel> menuSubCategoryModels = new ArrayList<>();
    private MenuSubCategoryAdapter menuSubCategoryAdapter;

    private List<AdvertisementModel> advertisementModels = new ArrayList<>();
    private AdvertisementAdapter advertisementAdapter;

    //    private List<MainNewsBannerModel> mainNewsBannerModels = new ArrayList<>();
//    private MainNewsBannerAdapter mainNewsBannerAdapter;
    private List<HomePageModel> homePageModels = new ArrayList<>();
    private HomePageAdapter homePageAdapter;

    private RecyclerView dashNewsRV1;
    private List<MainNewsModel> mainNewsModels = new ArrayList<>();
    private MainNewsAdapter mainNewsAdapter;

    private RecyclerView dashNewsRV2;
    private List<MainNewsModel> mainNewsModels2 = new ArrayList<>();

    public static ViewPager dashNewsVP;
    private TabLayout dashIndicator;
    private List<DetailNewsModel> detailNewsModels = new ArrayList<>();
    private DetailNewsViewPagerAdapter detailNewsViewPagerAdapter;
    //TODO: Adapters and Models

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        initVar();

        /*MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);*/

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels;
        width = displayMetrics.widthPixels;

        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimary));

        //TODO: LOADING DIALOG #####################################################

        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading_dialog_layout);
        loadingDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);
//        loadingDialog.show();

        bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.loading_dialog_layout, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCanceledOnTouchOutside(false);

        //TODO: LOADING DIALOG ######################################################
//        subCatSpinner = findViewById(R.id.dash_spinner_view);
//        dashDetailNewsRV = findViewById(R.id.dash_detail_news_rv);

        String b = getIntent().getStringExtra("Detail_Menu_Title");
        menuTitle.setText(b);

        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_text_view_layout,
                spinnerItem);
        subCatSpinner.setAdapter(arrayAdapter);
        subCatSpinner.setOnItemSelectedListener(this);
        mainNewsBannerModels.add(new MainNewsBannerModel(R.drawable.sample_img_2, "Breaking News",
                "Video games saved this man from the streets"));*/

        int[] imageArray = {R.drawable.sample_img_2, R.drawable.sample_img_3,
                R.drawable.sample_img_4, R.drawable.sample_img_5, R.drawable.sample_img_6,
                R.drawable.sample_img_7, R.drawable.sample_img_8, R.drawable.sample_img_1};

        String adTitle = "99% OFF in Amazon";
        String title = "Breaking News";
        String head = "\tThe public is helping us see Jupiter like it's never been seen before. " +
                "The public is helping us see Jupiter like it's never been seen before. " +
                "The public is helping us see Jupiter like it's never been seen before";
        String time = " Hours Ago";
        String date = "3 Sep 2020 | 12 : 00 AM";
        String text = "From the outside, the agency may appear a monolith, but in reality, citizen " +
                "scientists can play a substantial role perhaps none more so than in the ongoing " +
                "Juno mission. Since 2016, the Juno spacecraft has circled Jupiter, scanning the " +
                "atmosphere and mapping its magnetic and gravitational fields. It's also carrying " +
                "JunoCam, a camera specifically designed to record images of the poles; areas of " +
                "the gas giant not previously well documented. We do not have a formal imaging " +
                "science team on Juno, so we have turned to the public to help us out, says Candice " +
                "Hansen-Koharcheck, Juno co-investigator responsible for JunoCam The amateur " +
                "astronomy community assists with planning, she explains, determining when JunoCam " +
                "should photograph the planet and where. Once images are sent back to Earth, the " +
                "public has access to raw data, which, with a little photo editing know-how, have " +
                "been processed into some of the most stunning images yet seen of Jupiter.";


        //TODO: Model ##############################################################################

        final String[] spinnerItem = getResources().getStringArray(R.array.india_states);

        for (int value : imageArray) {
            bannerSliderModels.add(new MainNewsBannerModel(value, "Flash News", head));
        }

        for (int d = 0; d < imageArray.length / 2; d++) {
            advertisementModels.add(new AdvertisementModel(R.drawable.sample_ad_3, adTitle));
        }

        for (int n = 0; n < imageArray.length; n++) {
            mainNewsModels.add(new MainNewsModel(imageArray[n], title, head,
                    n + time, true, false));
        }

        for (int n = 0; n < imageArray.length; n++) {
            mainNewsModels2.add(new MainNewsModel(imageArray[n], title, head,
                    n + time, true, false));
        }

        for (int i : imageArray) {
            detailNewsModels.add(new DetailNewsModel(i, head, date, text));
        }

        homePageModels.add(new HomePageModel(0, advertisementModels, "ad"));
        homePageModels.add(new HomePageModel(1, 1, mainNewsModels));


        //TODO: Model ##############################################################################

        //TODO: Assigned ###########################################################################

        for (String a : spinnerItem) {
            menuSubCategoryModels.add(new MenuSubCategoryModel(a));
        }

        setBannerViewPager(bannerSliderModels);

        setDetailNewsView(detailNewsModels);

        setMainNewsView(mainNewsModels);

        setMainNewsView2(mainNewsModels2, true);

//        setCombinedView(homePageModels);

        menuSubCategoryAdapter = new MenuSubCategoryAdapter(menuSubCategoryModels,
                this);
        LinearLayoutManager subLinearManager = new LinearLayoutManager(this);
        subLinearManager.setOrientation(RecyclerView.VERTICAL);
        menuSubCatRV.setLayoutManager(subLinearManager);
        menuSubCatRV.setAdapter(menuSubCategoryAdapter);

        //TODO: Assigned ###########################################################################

//        nestedScrollView.addView(R.array.india_states,R.layout.spinner_text_view_layout);

        //TODO: CLICK LISTENER #####################################################################

        dashSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashBoardActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });

        dashMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousClick();
            }
        });

        dashBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextClick();
            }
        });

        dashFrontBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousClick();
            }
        });

        mainADViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });

        /*mainLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Success");
                Intent intent = new Intent(DashBoardActivity.this,
                        MainCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

        //TODO: CLICK LISTENER #####################################################################
    }

    //TODO: INIT ID ##############
    private void initVar() {
        bannerViewPager = findViewById(R.id.banner_view_slider);

        mainLogo = findViewById(R.id.main_logo);

        swipeRefreshLayout = findViewById(R.id.dashboard_swipe_refresh);

        menuSubCatResult = findViewById(R.id.menu_sub_result_tv);
        dashMenuBtn = findViewById(R.id.dash_menu_btn);
        dashBackBtn = findViewById(R.id.dash_back_btn);
        dashFrontBtn = findViewById(R.id.dash_front_btn);
        dashSearchBtn = findViewById(R.id.dash_search_btn);
        dashViewFlipper = findViewById(R.id.dash_view_flipper);
        dashNewsVP = findViewById(R.id.dash_view_pager);
        dashIndicator = findViewById(R.id.view_pager_indicator);
        dashNewsRV1 = findViewById(R.id.dash_main_news_rv_1);
        dashNewsRV2 = findViewById(R.id.dash_main_news_rv_2);

        backgroundAdView1 = findViewById(R.id.med_ad_image_view);

//        adView = findViewById(R.id.main_adView_top);
        mainADViewClick = findViewById(R.id.ad_click_view);
        topADView = findViewById(R.id.detail_adView_top);

        menuSubCatRV = findViewById(R.id.menu_sub_category_text_rv);
        menuTitle = findViewById(R.id.menu_sub_category_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    //TODO: BANNER SLIDER ##########################################################################

    private void setBannerViewPager(List<MainNewsBannerModel> bannerModels) {

        currentPage = 0;
        if (timer != null) {
            timer.cancel();
        }
        arrangedList = new ArrayList<>();
        for (int x = 0; x < bannerModels.size(); x++) {
            arrangedList.add(x, bannerModels.get(x));
        }

        BannerSliderAdapter bannerSliderAdapter = new BannerSliderAdapter(arrangedList);
        bannerViewPager.setAdapter(bannerSliderAdapter);
        bannerViewPager.setClipToPadding(false);
        bannerViewPager.setPageMargin(20);

        bannerViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageSelected(int position) {
                swipeRefreshLayout.setRefreshing(false);
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    pageLooper(arrangedList);
                }
            }
        };

        bannerViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow(arrangedList);

        bannerViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                stopBannerSlideShow(arrangedList);
                pageLooper(arrangedList);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startBannerSlideShow(arrangedList);
                }
                return false;
            }
        });

        dashIndicator.setupWithViewPager(bannerViewPager, true);

    }

    private void pageLooper(List<MainNewsBannerModel> sliderModelList) {
        if (currentPage == sliderModelList.size()) {
            currentPage = 0;
            bannerViewPager.setCurrentItem(currentPage, false);
        }
    }

    private void startBannerSlideShow(final List<MainNewsBannerModel> sliderModelList) {
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()) {
                    currentPage = 0;
                }
                bannerViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);
    }

    private void stopBannerSlideShow(List<MainNewsBannerModel> mainNewsBannerModels) {
        timer.cancel();
    }


    //TODO: BANNER SLIDER ##########################################################################

    private void setCombinedView(List<HomePageModel> homePageModels) {
        homePageAdapter = new HomePageAdapter(homePageModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        dashNewsRV1.setLayoutManager(linearLayoutManager);
        dashNewsRV1.setAdapter(homePageAdapter);
    }

    private void setMainNewsView(List<MainNewsModel> mainNewsModels) {
        mainNewsAdapter = new MainNewsAdapter(mainNewsModels, this);
        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(this);
        dashNewsRV1.setLayoutManager(newsLayoutManager);
        dashNewsRV1.setAdapter(mainNewsAdapter);
    }

    private void setMainNewsView2(List<MainNewsModel> mainNewsModels, boolean b) {
        mainNewsAdapter = new MainNewsAdapter(mainNewsModels, this);
        LinearLayoutManager newsLayoutManager = new LinearLayoutManager(this);
        dashNewsRV2.setLayoutManager(newsLayoutManager);
        dashNewsRV2.setAdapter(mainNewsAdapter);
    }

    private void setDetailNewsView(List<DetailNewsModel> detailNewsModels) {
        detailNewsViewPagerAdapter = new DetailNewsViewPagerAdapter(detailNewsModels, this);
        dashNewsVP.setAdapter(detailNewsViewPagerAdapter);
    }

    @Override
    public void MainNewsClickListener(int position) {
        mainNewsModels.get(position);
        swipeRefreshLayout.setRefreshing(false);

        detailNewsModels.set(position, new DetailNewsModel(mainNewsModels.get(position).getNewsImage(),
                mainNewsModels.get(position).getNewsReason(),
                detailNewsModels.get(position).getDetailDateTime(),
                detailNewsModels.get(position).getDetailNewsText()));

        setDetailNewsView(detailNewsModels);

        dashNewsVP.setCurrentItem(position);

        nextClick();
    }

    @Override
    public void MenuItemClickListener(int position) {
        menuSubCategoryModels.get(position);
        swipeRefreshLayout.setRefreshing(false);

        menuSubCatResult.setText(menuSubCategoryModels.get(position).getSubCatText());
        nextClick();
    }


    public void nextClick() {
        dashViewFlipper.setInAnimation(this, R.anim.slide_in_right);
        dashViewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        dashViewFlipper.showNext();
    }


    public void previousClick() {
        dashViewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        dashViewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        dashViewFlipper.showPrevious();
    }

    @Override
    public void onBackPressed() {
        int displayChild = dashViewFlipper.getDisplayedChild();
        if (displayChild > 0) {
            dashViewFlipper.setDisplayedChild(0);
        } else {
            super.onBackPressed();
        }
    }
}