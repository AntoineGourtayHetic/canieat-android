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

    private String id;
    private Geometry geometry;

    private String name;
    private OpenningHours openning_hours;
    private Photo photos;
    private float rating;
    private String vincinity;
    private String[] types;

    public Restaurant() {
    }

    public Restaurant(String id, Geometry geometry, String name, OpenningHours openning_hours, Photo photos, float rating, String vincinity, String[] types) {
        this.id = id;
        this.geometry = geometry;
        this.name = name;
        this.openning_hours = openning_hours;
        this.photos = photos;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpenningHours getOpenning_hours() {
        return openning_hours;
    }

    public void setOpenning_hours(OpenningHours openning_hours) {
        this.openning_hours = openning_hours;
    }

    public Photo getPhoto() {
        return photos;
    }

    public void setPhoto(Photo photos) {
        this.photos = photos;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getVincinity() {
        return vincinity;
    }

    public void setVincinity(String vincinity) {
        this.vincinity = vincinity;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }
}
