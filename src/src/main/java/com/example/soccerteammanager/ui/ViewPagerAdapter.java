package com.example.soccerteammanager.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new TeamsFragment();
            case 1: return new PlayersFragment();
            case 2: return new MatchesFragment();
            default: return new TeamsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
