package com.test.network.utils;

import android.content.SharedPreferences;

import java.util.Locale;

public class UnitConvertor {

    static final String _directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    public static String getHeading(double hea) {
        return _directions[(int) Math.floor((hea % 360) / 45)];
    }

    public static double convertTemperature(double temperature) {
        return Math.round(UnitConvertor.kelvinToCelsius(temperature));
    }

    public static double kelvinToCelsius(double kelvinTemp) {
        return kelvinTemp - 273.15d;
    }

    public static double kelvinToFahrenheit(float kelvinTemp) {
        return (((9 * kelvinToCelsius(kelvinTemp)) / 5) + 32);
    }


    public static int getWindPower(double wind) {
        if (wind < 0.3) {
            return 0; // Calm
        } else if (wind < 1.5) {
            return 1; // Light air
        } else if (wind < 3.3) {
            return 2; // Light breeze
        } else if (wind < 5.5) {
            return 3; // Gentle breeze
        } else if (wind < 7.9) {
            return 4; // Moderate breeze
        } else if (wind < 10.7) {
            return 5; // Fresh breeze
        } else if (wind < 13.8) {
            return 6; // Strong breeze
        } else if (wind < 17.1) {
            return 7; // High wind
        } else if (wind < 20.7) {
            return 8; // Gale
        } else if (wind < 24.4) {
            return 9; // Strong gale
        } else if (wind < 28.4) {
            return 10; // Storm
        } else if (wind < 32.6) {
            return 11; // Violent storm
        } else {
            return 12; // Hurricane
        }
    }

    public static String getBeaufortName(double wind) {
        if (wind == 0) {
            return "Calm";
        } else if (wind == 1) {
            return "Light air";
        } else if (wind == 2) {
            return "Light breeze";
        } else if (wind == 3) {
            return "Gentle breeze";
        } else if (wind == 4) {
            return "Moderate breeze";
        } else if (wind == 5) {
            return "Fresh breeze";
        } else if (wind == 6) {
            return "Strong breeze";
        } else if (wind == 7) {
            return "High wind";
        } else if (wind == 8) {
            return "Gale";
        } else if (wind == 9) {
            return "Strong gale";
        } else if (wind == 10) {
            return "Storm";
        } else if (wind == 11) {
            return "Violent storm";
        } else {
            return "Hurricane";
        }
    }
}
