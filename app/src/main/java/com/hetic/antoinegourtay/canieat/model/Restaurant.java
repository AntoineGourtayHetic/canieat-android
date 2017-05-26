package com.hetic.antoinegourtay.canieat.model;

import java.util.List;

/**
 * Created by antoinegourtay on 26/05/2017.
 */

public class Restaurant {

    private int id;
    private double latitude;
    private double longitude;
    private String icon;
    private String name;
    private boolean isOpen;
    private String adresse;
    private List<String> category;
    private float rating;


    public Restaurant(){}

    public Restaurant(int id, double latitude, double longitude, String icon, String name, boolean isOpen, String adresse, List<String> category, float rating) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.icon = icon;
        this.name = name;
        this.isOpen = isOpen;
        this.adresse = adresse;
        this.category = category;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<String> getCategory() {
        return category;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", isOpen=" + isOpen +
                ", adresse='" + adresse + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                '}';
    }
}
