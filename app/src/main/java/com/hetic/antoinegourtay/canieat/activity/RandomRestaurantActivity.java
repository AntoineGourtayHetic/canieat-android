package com.hetic.antoinegourtay.canieat.activity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.hetic.antoinegourtay.canieat.R;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.hetic.antoinegourtay.canieat.network.RestaurantService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRestaurantActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 102;
    private static final String LOCATION_APP = "HappyCow";

    private LocationManager locationManager;
    private LocationListener locationListener;
    private static double latitude;
    private static double longitude;
    private LatLng currentPosition;
    private String restaurantType;
    private String name;
    private String adresseRestaurant;
    private boolean isOpen;
    private float rating;

    private TextView randomName;
    private TextView randomAdress;
    private TextView randomIsOpen;
    private TextView randomRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_restaurant);

        final List<String> categories = new ArrayList<String>();
        categories.add("vegan");
        categories.add("vegetarien");
        categories.add("vegefriendly");

        Random r = new Random();

        restaurantType = categories.get(r.nextInt(0 - 3)) + 3;

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);


        //When user location changes
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(LOCATION_APP, "location : " + location);

                //Getting the position from the LocationListener
                latitude = location.getLatitude();
                longitude = location.getLongitude();

                RestaurantService.getRestaurant(latitude, longitude, restaurantType, new RestaurantService.RestaurantListener() {
                    @Override
                    public void onRestaurantReceived(List<Restaurant> restaurants) {

                        Random r = new Random();
                        int randomRestaurant = r.nextInt(0 - restaurants.size() - 1) + ( restaurants.size() -1 );

                        name = restaurants.get(randomRestaurant).getName();
                        adresseRestaurant = restaurants.get(randomRestaurant).getVincinity();
                        isOpen = restaurants.get(randomRestaurant).getOpenning_hours().isOpen_now();
                        rating = restaurants.get(randomRestaurant).getRating();

                    }

                    @Override
                    public void onFailed() {
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

        randomName = (TextView) findViewById(R.id.random_name);
        randomAdress = (TextView) findViewById(R.id.random_adress);
        randomIsOpen = (TextView) findViewById(R.id.random_is_open);
        randomRating = (TextView) findViewById(R.id.random_rating);

        randomName.setText(name);
        randomAdress.setText(adresseRestaurant);

        if (isOpen) {
            randomIsOpen.setText("Ouvert");
        } else {
            randomIsOpen.setText("Fermé");
        }

        randomRating.setText(Float.toString(rating));
        
    }
}
