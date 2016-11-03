package com.test.network.entity.components;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */

/*list.snow
list.snow.3h Snow volume for last 3 hours
*/
public class SnowDTO {
    @SerializedName("3h")
    @Expose
    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
