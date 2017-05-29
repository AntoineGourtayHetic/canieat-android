package com.hetic.antoinegourtay.canieat.network;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.hetic.antoinegourtay.canieat.activity.MapsActivity;
import com.hetic.antoinegourtay.canieat.model.Restaurant;

import java.util.List;

/**
 * Created by antoinegourtay on 29/05/2017.
 */

public class RestaurantService {

    private static LocationManager locationManager;
    private LocationListener locationListener;
    private double latitude;
    private double longitude;
    private LatLng currentPosition;

    public interface RestaurantListener {
        void onRestaurantReceived(List<Restaurant>);
        void onFailed();
    }

    public static void getRestaurant(String restaurantType, final RestaurantListener restaurantListener){

    }
}
