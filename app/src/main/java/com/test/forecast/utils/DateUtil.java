package com.test.forecast.utils;

import android.content.Context;

import com.test.weather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Copyright (c) 2015.
 *
 * @author enricodelzotto
 * @since 31/03/2016
 */
public class DateUtil {
    /**
     * Quick and dirty day formatter helper class.
     */
    private final static long MILLISECONDS_IN_SECONDS = 1000;

    public static String format(Context context, final long unixTimestamp) {
        final long milliseconds = unixTimestamp * MILLISECONDS_IN_SECONDS;
        String day;

        if (isToday(milliseconds)) {
            day = context.getResources().getString(R.string.today) + " at " + getHour(milliseconds);
        } else if (isTomorrow(milliseconds)) {
            day = context.getResources().getString(R.string.tomorrow) + " at " + getHour(milliseconds);
        } else {
            day = getDayOfWeek(milliseconds) + " at " + getHour(milliseconds);
        }
        return day;
    }

    private static String getDayOfWeek(final long milliseconds) {
        String dayOfWeek = new SimpleDateFormat("EEEE").format(new Date(milliseconds));
        String dayUpperCase = dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1);
        return dayUpperCase;
    }

    private static String getHour(final long milliseconds) {
        return new SimpleDateFormat("hh:mm a").format(new Date(milliseconds));
    }

    private static boolean isToday(final long milliseconds) {
        final SimpleDateFormat dayInYearFormat = new SimpleDateFormat("yyyyD");
        final String nowHash = dayInYearFormat.format(new Date());
        final String comparisonHash = dayInYearFormat.format(new Date(milliseconds));
        return nowHash.equals(comparisonHash);
    }

    private static boolean isTomorrow(final long milliseconds) {
        final SimpleDateFormat dayInYearFormat = new SimpleDateFormat("yyyyD");
        final int tomorrowHash = Integer.parseInt(dayInYearFormat.format(new Date())) + 1;
        final int comparisonHash = Integer.parseInt(dayInYearFormat.format(new Date(milliseconds)));
        return comparisonHash == tomorrowHash;
    }
}

