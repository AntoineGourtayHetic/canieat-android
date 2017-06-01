package com.hetic.antoinegourtay.canieat.network;

/**
 * Created by antoinegourtay on 29/05/2017.
 */

public class UrlBuilder {

    private static final String baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=";

    public static String getRestaurantUrl(double latitude, double longitude, String restaurantType){
        return baseUrl + latitude + "," + longitude + "&radius=10000&type=restaurant&keyword=" + restaurantType + "&key=AIzaSyA8Jf9E6m_Rr_v_fd-rA7dQOtn1VnTR4zs";
    }
}
