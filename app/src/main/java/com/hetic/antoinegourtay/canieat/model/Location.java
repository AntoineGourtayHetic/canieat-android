package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by antoinegourtay on 01/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private double lat;
    private double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
