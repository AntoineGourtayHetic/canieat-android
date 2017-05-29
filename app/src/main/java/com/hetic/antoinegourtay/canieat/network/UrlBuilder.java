package com.hetic.antoinegourtay.canieat.network;

/**
 * Created by antoinegourtay on 29/05/2017.
 */

public class UrlBuilder {

    private static final String baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=48.8445548%2C2.4222176&radius=15000&type=restaurant&keyword=";

    public static String getRestaurantUrl(String restaurantType){
        return baseUrl + restaurantType + "&key=AIzaSyA8Jf9E6m_Rr_v_fd-rA7dQOtn1VnTR4zs";
    }
}
