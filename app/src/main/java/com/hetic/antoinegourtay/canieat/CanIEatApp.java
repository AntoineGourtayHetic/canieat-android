package com.hetic.antoinegourtay.canieat;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hetic.antoinegourtay.canieat.model.OpenningHours;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.hetic.antoinegourtay.canieat.model.RestaurantLocation;
import com.hetic.antoinegourtay.canieat.network.RestaurantService;

import java.util.List;

/**
 * Created by antoinegourtay on 30/05/2017.
 */

public class CanIEatApp extends Application {

    private RequestQueue requestQueue;

    public GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 102;
    private static final String LOCATION_APP = "HappyCow";

    private LocationManager locationManager;
    LocationListener locationListener;
    public static double latitude;
    public static double longitude;
    public static LatLng currentPosition;

    // Singleton
    private static CanIEatApp sharedInstance;
    private boolean onLaunch = true;

    @Override
    public void onCreate() {
        super.onCreate();

        // On assigne notre singleton au démarrage
        CanIEatApp.sharedInstance = this;

        // 1 queue par application (pour l'exemple ici)
        // mais possibilité d'en avoir plusieurs
        requestQueue = Volley.newRequestQueue(this);

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static CanIEatApp getSharedInstance() {
        return sharedInstance;
    }


}
