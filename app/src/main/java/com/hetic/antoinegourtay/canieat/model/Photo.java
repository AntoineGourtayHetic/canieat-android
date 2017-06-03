package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by lunkl on 04/06/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    private boolean photo_reference;

    public boolean mainPhoto() {
        return photo_reference;
    }

    public void setPhoto(boolean photo_reference) {
        this.photo_reference = photo_reference;
    }
}
