package com.hetic.antoinegourtay.canieat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hetic.antoinegourtay.canieat.fragment.CategoryFragment;

/**
 * Created by luca on 01/06/2017.
 */

public class CategoriesAdapter extends FragmentPagerAdapter {

    public CategoriesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CategoryFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "tab "+ position;
    }
}
