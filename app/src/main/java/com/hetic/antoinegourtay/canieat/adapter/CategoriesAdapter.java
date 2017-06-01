package com.hetic.antoinegourtay.canieat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hetic.antoinegourtay.canieat.fragment.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 01/06/2017.
 */

public class CategoriesAdapter extends FragmentPagerAdapter {

    private List<String> categories;

    public CategoriesAdapter(FragmentManager fm, List<String> categories) {
        super(fm);
        this.categories = new ArrayList<>(categories);
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(categories.get(position));
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position);
    }
}
