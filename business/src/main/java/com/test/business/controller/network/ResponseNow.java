package com.test.business.controller.network;

import com.test.business.entity.Coordinates;
import com.test.business.entity.InternalForecast;
import com.test.business.entity.MainSpecs;
import com.test.business.entity.components.Clouds;
import com.test.business.entity.components.Rain;
import com.test.business.entity.components.Weather;
import com.test.business.entity.components.Wind;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 02/11/2016
 */
public class ResponseNow {
    private Coordinates coordinates;
    private List<Weather> weather;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private MainSpecs mainSpecs;
    private String cityName;


    public ResponseNow(Coordinates coordinates, List<Weather> weather, Wind wind, Rain rain, Clouds clouds, MainSpecs mainSpecs, String cityName) {
        this.coordinates = coordinates;
        this.weather = weather;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.mainSpecs = mainSpecs;
        this.cityName = cityName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public MainSpecs getMainSpecs() {
        return mainSpecs;
    }

    public String getCityName() {
        return cityName;
    }
}
