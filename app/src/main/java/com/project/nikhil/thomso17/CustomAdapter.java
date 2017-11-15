package com.project.nikhil.thomso17;

import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nikhil on 7/10/17.
 */

public class CustomAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Day 1", "Day 2", "Day 3"};

    public CustomAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position == 0) {
            return new Day1();
        } else if (position == 1){
            return new Day2();
        } else  {
            return new Day3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}