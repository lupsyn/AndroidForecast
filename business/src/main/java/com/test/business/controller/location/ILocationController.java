package com.test.business.controller.location;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 02/11/2016
 */
public interface ILocationController {
    /**
     * Host client reqeust location
     * @param locationCallback
     */
    void requestLatestLocation(LocationCallback locationCallback);
    void onActivityDestroy();

}
