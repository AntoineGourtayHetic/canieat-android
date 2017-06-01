package com.hetic.antoinegourtay.canieat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by antoinegourtay on 01/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Types {

    private Types types[];

    public Types[] getTypes() {
        return types;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }
}
