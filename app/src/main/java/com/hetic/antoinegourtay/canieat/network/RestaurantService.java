package com.hetic.antoinegourtay.canieat.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.hetic.antoinegourtay.canieat.CanIEatApp;
import com.hetic.antoinegourtay.canieat.model.Restaurant;
import com.hetic.antoinegourtay.canieat.model.RestaurantsResult;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by antoinegourtay on 29/05/2017.
 */

public class RestaurantService {

    public interface RestaurantListener {
        void onRestaurantReceived(List<Restaurant> restaurant);
        void onFailed();
    }

    public static void getRestaurant(double latitude, double longitude, String restaurantType, final RestaurantListener restaurantListener){

        String url = UrlBuilder.getRestaurantUrl(latitude, longitude,restaurantType);

        JacksonRequest<RestaurantsResult> request;
        request = new JacksonRequest<>(Request.Method.GET, url, new JacksonRequestListener<RestaurantsResult>() {

            @Override
            public void onResponse(RestaurantsResult response, int statusCode, VolleyError error) {
                if (restaurantListener == null) {
                    return;
                }

                //
                if (response != null) {
                    // transformation d'un tableau ([Ø]) en List<> avec Arrays.asList
                    restaurantListener.onRestaurantReceived(Arrays.asList(response.getResults()));

                }

                if (error != null) {
                    restaurantListener.onFailed();
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(RestaurantsResult.class);
            }
        });

        CanIEatApp
                .getSharedInstance()
                .getRequestQueue()
                .add(request);

    }
}
