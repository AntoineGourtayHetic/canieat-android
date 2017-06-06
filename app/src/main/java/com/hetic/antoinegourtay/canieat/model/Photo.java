package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by lunkl on 04/06/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    private String photo_reference;

    public Photo() {
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }
}
