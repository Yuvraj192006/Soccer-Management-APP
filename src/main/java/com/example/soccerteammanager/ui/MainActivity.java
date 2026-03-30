package com.example.soccerteammanager.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.soccerteammanager.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0: 
                            tab.setText("Teams");
                            tab.setIcon(android.R.drawable.ic_menu_myplaces);
                            break;
                        case 1: 
                            tab.setText("Players");
                            tab.setIcon(android.R.drawable.ic_menu_gallery);
                            break;
                        case 2: 
                            tab.setText("Matches");
                            tab.setIcon(android.R.drawable.ic_menu_today);
                            break;
                    }
                }).attach();
    }
}