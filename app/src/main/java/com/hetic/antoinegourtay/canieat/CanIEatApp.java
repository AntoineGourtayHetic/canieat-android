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

        //We get current user position
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        //When user location changes
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                mMap.clear();
                Log.d(LOCATION_APP, "location : " + location);

                //Getting the position from the LocationListener
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                Log.d(LOCATION_APP, "latitude : " + latitude + " - longitude : " + longitude);

                currentPosition = new LatLng(latitude, longitude);

                //Creating a marker for user's position
                MarkerOptions marker = new MarkerOptions();
                marker.title("Current position");
                marker.position(currentPosition);

                //To show the blue dot on current location
                mMap.setMyLocationEnabled(true);

                //Animating the camera to the current position
                if (onLaunch) {
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, 17));
                    onLaunch = false;
                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                provider.toString();
            }

            @Override
            public void onProviderEnabled(String provider) {
                provider.toString();
            }

            @Override
            public void onProviderDisabled(String provider) {
                provider.toString();
            }
        };


        //We get the restaurants by the API
        //TODO: Change the restaurant type parametter by the chosen tab
        RestaurantService.getRestaurant(latitude, longitude, "vegan", new RestaurantService.RestaurantListener() {
            @Override
            public void onRestaurantReceived(List<Restaurant> restaurants) {

                //Clear the markers on the map
                mMap.clear();

                //For each restaurant we receive in the API, we create a marker
                for (Restaurant restaurant : restaurants) {
                    Log.d(LOCATION_APP, restaurant.toString());

                    RestaurantLocation restaurantLocation = restaurant.getGeometry().getLocation();
                    String name = restaurant.getName();
                    OpenningHours openningHours = restaurant.getOpenning_hours();
                    float rating = restaurant.getRating();
                    String adresse = restaurant.getVincinity();

                    MarkerOptions markerOptions = new MarkerOptions()
                            .position(new LatLng(restaurantLocation.getLat(), restaurantLocation.getLng()));


                    mMap.addMarker(markerOptions);
                }
            }

            @Override
            public void onFailed() {
                int a = 10;
            }
        });

        long minTime = 10;
        float minDistance = 10.0f;

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);

    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static CanIEatApp getSharedInstance() {
        return sharedInstance;
    }


}
