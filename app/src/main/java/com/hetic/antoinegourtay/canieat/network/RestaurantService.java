package com.hetic.antoinegourtay.canieat.network;

import android.location.LocationListener;
import android.location.LocationManager;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.google.android.gms.maps.model.LatLng;
import com.hetic.antoinegourtay.canieat.CanIEatApp;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.Arrays;
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
        void onRestaurantReceived(List<Restaurant> restaurant);
        void onFailed();
    }

    public static void getRestaurant(String restaurantType, final RestaurantListener restaurantListener){

        String url = UrlBuilder.getRestaurantUrl(restaurantType);

        JacksonRequest<Restaurant[]> request =
                new JacksonRequest<Restaurant[]>(Request.Method.GET, url, new JacksonRequestListener<Restaurant[]>() {

            @Override
            public void onResponse(Restaurant[] response, int statusCode, VolleyError error) {
                if( restaurantListener==null ) {
                    return;
                }

                //
                if(response !=null ) {
                    // transformation d'un tableau ([Ø]) en List<> avec Arrays.asList
                    restaurantListener.onRestaurantReceived(Arrays.asList(response));
                }

                if(error != null) {
                    restaurantListener.onFailed();
                }
            }

            @Override
            public JavaType getReturnType() {
                return ArrayType.construct(SimpleType.constructUnsafe(Restaurant.class), null);
            }
        });

        CanIEatApp.getSharedInstance()
                .getRequestQueue()
                .add(request);

    }
}
