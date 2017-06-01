package com.hetic.antoinegourtay.canieat.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.adapter.CategoriesAdapter;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.hetic.antoinegourtay.canieat.model.RestaurantLocation;
import com.hetic.antoinegourtay.canieat.network.RestaurantService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 102;
    private static final String LOCATION_APP = "HappyCow";

    private LocationManager locationManager;
    private LocationListener locationListener;
    public double latitude;
    public double longitude;
    private LatLng currentPosition;


    @BindView(R.id.tab_layout_categories)
    protected TabLayout categoriesTabLayout;

    @BindView(R.id.view_pager_categories)
    protected ViewPager categoriesViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ButterKnife.bind(this);


        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getSupportFragmentManager());

        categoriesViewPager.setAdapter(categoriesAdapter);


        categoriesTabLayout.setupWithViewPager(categoriesViewPager);





        // Plus d'infos
        // https://developer.android.com/guide/topics/location/strategies.html

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
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, 17));

                //We get the restaurants by the API
                //TODO: Change the restaurant type parametter by the chosen tab
                RestaurantService.getRestaurant(latitude, longitude, "vegan", new RestaurantService.RestaurantListener() {
                    @Override
                    public void onRestaurantReceived(List<Restaurant> restaurants) {

                        mMap.clear();

                        for (Restaurant restaurant : restaurants) {
                            Log.d(LOCATION_APP, restaurant.toString());

                            RestaurantLocation restaurantLocation = restaurant.getGeometry().getLocation();

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


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    && ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

            }
        } else {
            long minTime = 10;
            float minDistance = 10.0f;

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, locationListener);

        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted!
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }

                    long minTime = 1;
                    float minDistance = 10;

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, locationListener);

                } else {

                    // permission denied!
                }
                return;
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        locationManager.removeUpdates(locationListener);
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

}


