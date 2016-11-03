package com.test.network.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.test.network.entity.components.CloudsDTO;
import com.test.network.entity.components.RainDTO;
import com.test.network.entity.components.WeatherDTO;
import com.test.network.entity.components.WindDTO;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class ResponseNowDTO {
    @SerializedName("coord")
    @Expose
    private CoordinatesDTO coordinates;

    @SerializedName("weather")
    @Expose
    private List<WeatherDTO> weather;

    @SerializedName("main")
    @Expose
    private MainSpecsDTO main;

    @SerializedName("wind")
    @Expose
    private WindDTO wind;

    @SerializedName("rain")
    @Expose
    private RainDTO rain;

    @SerializedName("clouds")
    @Expose
    private CloudsDTO clouds;

    @SerializedName("name")
    @Expose
    private String cityName;

    public CoordinatesDTO getCoordinates() {
        return coordinates;
    }

    public List<WeatherDTO> getWeather() {
        return weather;
    }

    public MainSpecsDTO getMain() {
        return main;
    }

    public WindDTO getWind() {
        return wind;
    }

    public RainDTO getRain() {
        return rain;
    }

    public CloudsDTO getClouds() {
        return clouds;
    }

    public String getCityName() {
        return cityName;
    }
}
