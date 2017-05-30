package com.hetic.antoinegourtay.canieat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antoinegourtay on 26/05/2017.
 */

public class Restaurant implements Parcelable{

    private int id;
    private double latitude;
    private double longitude;
    private String icon;
    private String name;
    private String isOpen;
    private String adresse;
    private List category;
    private float rating;


    public Restaurant() {
    }

    public Restaurant(int id, double latitude, double longitude, String icon, String name, String isOpen, String adresse, List<String> category, float rating) {
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

    public Restaurant(Parcel in){
        name = in.readString();
        isOpen = in.readString();
        adresse = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        //category = in.readl;

    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

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

    /*public boolean isOpen() {
        return isOpen;
    }*/

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(isOpen);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
       // dest.writeArray(category);
    }
}
