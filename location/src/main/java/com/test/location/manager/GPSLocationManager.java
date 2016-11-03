package com.test.location.manager;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.test.business.controller.location.LocationCallback;
import com.test.business.entity.Coordinates;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 18/05/16
 */
public class GPSLocationManager {
    private final GoogleApiClient mGoogleApiClient;
    private final Context mContext;
    private LocationCallback mLocationCallback;


    public GPSLocationManager(Context context) {
        mContext = context;

        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(connectionCallbacks)
                .addApi(LocationServices.API)
                .build();
    }


    public void connect(LocationCallback locationCallback) {
        mLocationCallback = locationCallback;
        mGoogleApiClient.connect();
    }

    private GoogleApiClient.ConnectionCallbacks connectionCallbacks = new GoogleApiClient.ConnectionCallbacks() {
        @Override
        public void onConnected(@Nullable Bundle bundle) {
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                mLocationCallback.onPermissionMissing();
            } else {
                LocationRequest locationRequest = new LocationRequest();
                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                locationRequest.setInterval(5000);
                locationRequest.setNumUpdates(1);
                locationRequest.setFastestInterval(2000);

                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, locationRequest, locationListener);
            }
        }

        @Override
        public void onConnectionSuspended(int i) {
            mLocationCallback.onError("Cant connect to Google Play Services API");
        }
    };
    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            mLocationCallback.onDetected(new Coordinates(location.getLatitude(), location.getLongitude()));
            //we notified the listener
            //now lets remove the callback and disconnect from google play services
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    };

    public void onDestroy() {
        mGoogleApiClient.disconnect();
    }
}
