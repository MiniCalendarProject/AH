package com.example.jh.mycalendar;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public TabLayout tabLayout;
    public ViewPager viewPager;

    Button buttonPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("달력"));
        tabLayout.addTab(tabLayout.newTab().setText("일정"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Initializing ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        // Creating TabPagerAdapter adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set TabSelectedListener
//        tabLayout.setupWithViewPager(viewPager);
        buttonPlus = findViewById(R.id.plus_btn);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        buttonPlus.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        buttonPlus.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        buttonPlus.setVisibility(View.VISIBLE);
                    case 1:
                        buttonPlus.setVisibility(View.GONE);
                    default:
                }
            }
        });

//        viewPager.scrollTo();
//
//        int position = tabLayout.getSelectedTabPosition();
//        if (position == 1){
//
//            Button buttonPlus = getActivity().findViewById(R.id.plus_btn);
//            buttonPlus.setVisibility(View.GONE);
//        }
//        else{
//
//        }
    }
}
