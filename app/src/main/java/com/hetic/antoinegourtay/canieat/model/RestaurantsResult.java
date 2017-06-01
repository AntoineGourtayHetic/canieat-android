package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by antoinegourtay on 01/06/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantsResult {
    private Restaurant[] results;

    public RestaurantsResult() {

    }

    public Restaurant[] getResults() {
        return results;
    }

    public void setResults(Restaurant[] results) {
        this.results = results;
    }
}
