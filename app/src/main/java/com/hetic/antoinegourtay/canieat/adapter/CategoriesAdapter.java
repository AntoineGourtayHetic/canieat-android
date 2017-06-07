package com.hetic.antoinegourtay.canieat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hetic.antoinegourtay.canieat.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.List;


public class CategoriesAdapter extends FragmentPagerAdapter {

    private List<String> restaurantsTypes;
    private Fragment mCurrentFragement;

    public CategoriesAdapter(FragmentManager fm, List<String> restaurantTypes) {
        super(fm);
        this.restaurantsTypes = new ArrayList<>(restaurantTypes);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(restaurantsTypes.get(position));
    }

    @Override
    public int getCount() {
        return restaurantsTypes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return restaurantsTypes.get(position);
    }

    public Fragment getmCurrentFragement(){
        return mCurrentFragement;
    }
}
