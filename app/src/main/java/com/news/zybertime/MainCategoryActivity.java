package com.news.zybertime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.news.zybertime.NavFragment.FeedBackFragment;
import com.news.zybertime.NavFragment.HomeFragment;
import com.news.zybertime.NavFragment.SettingsFragment;

public class MainCategoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FrameLayout frameLayout;
    private ActionBarDrawerToggle toggle;

    private static int CURRENT_FRAGMENT = 0;
    private static int HOME_FRAGMENT = 1;
    private static int SETTINGS_FRAGMENT = 2;
    private static int FEEDBACK_FRAGMENT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        initVar();

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);

        setFragment(new HomeFragment(), HOME_FRAGMENT);
    }

    private void initVar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        frameLayout = findViewById(R.id.main_frame_layout);
        toolbar = findViewById(R.id.main_toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);

        if (id == R.id.nav_home) {
            setFragment(new HomeFragment(), HOME_FRAGMENT);
        } else if (id == R.id.nav_option1) {
            setFragment(new SettingsFragment(), SETTINGS_FRAGMENT);
        } else if (id == R.id.nav_feedback) {
            setFragment(new FeedBackFragment(), FEEDBACK_FRAGMENT);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (CURRENT_FRAGMENT != HOME_FRAGMENT) {
                setFragment(new HomeFragment(), HOME_FRAGMENT);
                navigationView.getMenu().getItem(0).setChecked(true);
            } else {
                super.onBackPressed();
                finish();
            }
        }
    }

    public void setFragment(Fragment fragment, int fragNo) {
        if (CURRENT_FRAGMENT != fragNo) {
            CURRENT_FRAGMENT = fragNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }
    }
}