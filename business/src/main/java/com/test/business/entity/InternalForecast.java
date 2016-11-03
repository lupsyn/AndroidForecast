package com.test.business.entity;

import com.test.business.entity.components.Clouds;
import com.test.business.entity.components.Rain;
import com.test.business.entity.components.Snow;
import com.test.business.entity.components.Weather;
import com.test.business.entity.components.Wind;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */

public class InternalForecast {


    String date;
    String date_txt;
    List<Weather> weather;
    MainSpecs mainforecast;
    Clouds clouds;
    Wind wind;
    Rain rain;
    Snow snow;

    public InternalForecast(String date, String date_txt, List<Weather> weather, MainSpecs mainforecast, Clouds clouds, Wind wind, Rain rain, Snow snow) {
        this.date = date;
        this.date_txt = date_txt;
        this.weather = weather;
        this.mainforecast = mainforecast;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.snow = snow;
    }



    public String getDate() {
        return date;
    }

    public String getDate_txt() {
        return date_txt;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public MainSpecs getMainforecast() {
        return mainforecast;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }
}
