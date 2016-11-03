package com.test.business.entity.components;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */

/*list.clouds.all Cloudiness, */
public class Clouds {
    private double cloudiness;

    public Clouds(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }
}
