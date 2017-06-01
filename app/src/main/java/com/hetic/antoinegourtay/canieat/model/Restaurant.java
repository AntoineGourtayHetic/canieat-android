package com.hetic.antoinegourtay.canieat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by antoinegourtay on 26/05/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant implements Parcelable{

    private int id;
    private Geometry geometry;

    private String name;
    private OpenningHours openning_hours;
    private float rating;
    private String vincinity;
    private


    public Restaurant() {
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

    }
}
