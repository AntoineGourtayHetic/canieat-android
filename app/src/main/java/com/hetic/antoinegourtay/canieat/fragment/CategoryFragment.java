package com.hetic.antoinegourtay.canieat.fragment;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hetic.antoinegourtay.canieat.CanIEatApp;
import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.activity.MapsActivity;
import com.hetic.antoinegourtay.canieat.model.OpenningHours;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.hetic.antoinegourtay.canieat.model.RestaurantLocation;
import com.hetic.antoinegourtay.canieat.network.RestaurantService;

import java.util.List;
import java.util.Map;

import static android.content.Context.LOCATION_SERVICE;
import static android.content.Context.TEXT_SERVICES_MANAGER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    private static final String ARGUMENT_CATEGORY = "category";
    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 102;
    private static final String LOCATION_APP = "HappyCow";

    private LocationManager locationManager;
    private LocationListener locationListener;
    public double latitude;
    public double longitude;
    private LatLng currentPosition;

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

        String category = getArguments().getString(ARGUMENT_CATEGORY);

        LatLng currentPosition = new LatLng(MapsActivity.getLatitude(), MapsActivity.getLongitude());
        Log.e("CURRENTFRAGMENT", currentPosition.toString());

        if (category != null) {

            RestaurantService.getRestaurant(MapsActivity.getLatitude(), MapsActivity.getLongitude(), category, new RestaurantService.RestaurantListener() {
                @Override
                public void onRestaurantReceived(List<Restaurant> restaurants) {
                    //For each restaurant we receive in the API, we create a marker
                    for (Restaurant restaurant : restaurants) {
                        Log.d(LOCATION_APP, restaurant.toString());

                        RestaurantLocation restaurantLocation = restaurant.getGeometry().getLocation();
                        String name = restaurant.getName();
                        OpenningHours openningHours = restaurant.getOpenning_hours();
                        float rating = restaurant.getRating();
                        String adresse = restaurant.getVincinity();

                        System.out.println(restaurantLocation);

                    }
                }

                @Override
                public void onFailed() {

                }
            });
        }
    }

}


