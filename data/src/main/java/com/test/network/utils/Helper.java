package com.test.network.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class Helper {

    public static String getCountryFromLocaleContext(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        String countryCodeValue = tm.getNetworkCountryIso();
        return countryCodeValue;
    }
}
