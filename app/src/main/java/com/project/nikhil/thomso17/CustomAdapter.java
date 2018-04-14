package com.project.nikhil.thomso17;

import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nikhil on 7/10/17.
 */

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