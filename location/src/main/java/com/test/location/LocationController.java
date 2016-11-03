package com.test.location;

import android.content.Context;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.test.business.controller.location.ILocationController;
import com.test.business.controller.location.LocationCallback;
import com.test.location.manager.GPSLocationManager;
import com.test.location.manager.PlainLocationManager;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 18/05/16
 */
public class LocationController implements ILocationController {

    private final Context mContext;
    private GPSLocationManager mGPSLocationManager;
    private PlainLocationManager mPlainLocationManager;
    private boolean isPlayServicesAvailable = false;

    public LocationController(Context context) {
        mContext = context;
        isPlayServicesAvailable = checkGooglePlayServicesAvailable(mContext);
        if (isPlayServicesAvailable) {
            mGPSLocationManager = new GPSLocationManager(mContext);
            mPlainLocationManager = new PlainLocationManager(mContext);
        } else {
            //Here for manager
            mPlainLocationManager = new PlainLocationManager(mContext);
        }
    }


    @Override
    public void requestLatestLocation(LocationCallback locationCallback) {
        if (isPlayServicesAvailable) {
            mGPSLocationManager.connect(locationCallback);
            mPlainLocationManager.connect(locationCallback);
        } else {
            // mPlainLocationManager.connect(locationCallback);
        }
    }

    @Override
    public void onActivityDestroy() {
        if (mGPSLocationManager!=null)
            mGPSLocationManager.onDestroy();
    }


    /**
     * Check whether Google Play Services are available.
     * <p/>
     * If not, then display dialog allowing user to update Google Play Services
     *
     * @return true if available, or false if not
     */
    private boolean checkGooglePlayServicesAvailable(Context context) {
        final int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (status == ConnectionResult.SUCCESS) {
            return true;
        }
        return false;
    }

}
