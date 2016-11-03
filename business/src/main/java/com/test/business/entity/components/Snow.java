package com.test.business.entity.components;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
/*list.snow
list.snow.3h Snow volume for last 3 hours*/
public class Snow {
    private double volume;

    public Snow(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
