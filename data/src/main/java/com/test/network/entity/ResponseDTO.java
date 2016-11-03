package com.test.network.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class ResponseDTO {
    @SerializedName("city")
    @Expose
    private CityDTO city;

    @SerializedName("list")
    @Expose
    private List<InternalForecastDTO> weatherList;


    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public List<InternalForecastDTO> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<InternalForecastDTO> weatherList) {
        this.weatherList = weatherList;
    }
}
