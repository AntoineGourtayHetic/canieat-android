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
    private Types types;

    public Restaurant() {
    }

    public Restaurant(int id, Geometry geometry, String name, OpenningHours openning_hours, float rating, String vincinity, Types types) {
        this.id = id;
        this.geometry = geometry;
        this.name = name;
        this.openning_hours = openning_hours;
        this.rating = rating;
        this.vincinity = vincinity;
        this.types = types;
    }

    public Restaurant(Parcel in){
        
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
