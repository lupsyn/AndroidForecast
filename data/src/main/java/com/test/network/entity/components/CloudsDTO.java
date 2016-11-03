package com.test.network.entity.components;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
/*
list.clouds
list.clouds.all Cloudiness, %
 */
public class CloudsDTO {
    @SerializedName("all")
    @Expose
    private double cloudiness;

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }
}
