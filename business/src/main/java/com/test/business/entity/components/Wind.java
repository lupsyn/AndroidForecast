package com.test.business.entity.components;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */

/*list.wind.speed Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
list.wind.deg Wind direction, degrees (meteorological)*/

public class Wind {
    private double speed;
    private double direction;
    private String directionString;
    private String description;

    public Wind(double speed, double direction, String directionString, String description) {
        this.speed = speed;
        this.direction = direction;
        this.directionString = directionString;
        this.description = description;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public String getDirectionString() {
        return directionString;
    }

    public void setDirectionString(String directionString) {
        this.directionString = directionString;
    }

    public String getDescription() {
        return description;
    }
}
