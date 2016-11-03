package com.test.business.entity.components;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
/*list.wind.deg Wind direction, degrees (meteorological)
list.rain
list.rain.3h Rain volume for last 3 hours, mm*/
public class Rain {
    private double volume;

    public Rain(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
