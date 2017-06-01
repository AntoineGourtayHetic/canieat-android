package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by antoinegourtay on 01/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

    private RestaurantLocation location;

    public Geometry() {
    }

    public RestaurantLocation getLocation() {
        return location;
    }

    public void setLocation(RestaurantLocation location) {
        this.location = location;
    }

}
