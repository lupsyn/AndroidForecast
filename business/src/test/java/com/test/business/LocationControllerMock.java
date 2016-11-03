package com.test.business;


import com.test.business.controller.location.ILocationController;
import com.test.business.controller.location.LocationCallback;
import com.test.business.entity.Coordinates;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 21/06/2016
 */
public class LocationControllerMock implements ILocationController {
    @Override
    public void requestLatestLocation(LocationCallback locationCallback) {
        locationCallback.onDetected(new Coordinates(1,1));
    }

    @Override
    public void onActivityDestroy() {

    }
}
