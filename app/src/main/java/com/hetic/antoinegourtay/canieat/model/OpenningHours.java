package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by antoinegourtay on 01/06/2017.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
class OpenningHours {
    private boolean open_now;

    public boolean isOpen_now() {
        return open_now;
    }

    public void setOpen_now(boolean open_now) {
        this.open_now = open_now;
    }
}
