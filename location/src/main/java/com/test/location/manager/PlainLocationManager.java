package com.test.location.manager;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import com.test.business.controller.location.LocationCallback;
import com.test.location.manager.aosp.LocationTime;
import com.test.location.manager.aosp.RxLocationManager;

import java.util.concurrent.TimeUnit;

import rx.Subscriber;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 18/05/16
 */
public class PlainLocationManager {
    private final String provider = LocationManager.GPS_PROVIDER;
    private final Context mContext;
    private RxLocationManager mRxLocationManager;
    private LocationCallback mLocationCallback;


    public PlainLocationManager(Context context) {
        mContext = context;
        mRxLocationManager = new RxLocationManager(context);
    }


    public void connect(LocationCallback locationCallback) {

        mLocationCallback = locationCallback;
        // setIsProviderEnabled(provider, true);
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            mLocationCallback.onPermissionMissing();
        } else {
//            mRxLocationManager.getLastLocation(provider).subscribe(new Subscriber<Location>() {
//                @Override
//                public void onCompleted() {
//                    int fd = 1;
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    int fd = 1;
//                }
//
//                @Override
//                public void onNext(Location location) {
//                    int fd = 1;
//                }
//            });
            mRxLocationManager.requestLocation(provider, new LocationTime(5, TimeUnit.SECONDS)).subscribe(new Subscriber<Location>() {
                @Override
                public void onCompleted() {
                    int fd = 1;
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Location location) {
                    //mLocationCallback.onDetected(new com.smartfocus.business.entity.Location(location.getLatitude(), location.getLongitude()));
                }
            });
        }
    }
}
