package com.hetic.antoinegourtay.canieat.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hetic.antoinegourtay.canieat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    private static final String ARGUMENT_CATEGORY = "category";

    public static CategoryFragment newInstance(String category) {

        Bundle args = new Bundle();
        args.putString(ARGUMENT_CATEGORY, category);

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        String category  = getArguments().getString(ARGUMENT_CATEGORY);

        if(category!=null) {

        }

    }
}
