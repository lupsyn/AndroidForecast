package com.test.network.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.network.entity.components.CloudsDTO;
import com.test.network.entity.components.RainDTO;
import com.test.network.entity.components.SnowDTO;
import com.test.network.entity.components.WeatherDTO;
import com.test.network.entity.components.WindDTO;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class InternalForecastDTO {

    @SerializedName("dt")
    @Expose
    String date;

    @SerializedName("main")
    @Expose
    MainSpecsDTO mainforecast;

    @SerializedName("weather")
    @Expose
    List<WeatherDTO> forecast;

    @SerializedName("clouds")
    @Expose
    CloudsDTO clouds;

    @SerializedName("wind")
    @Expose
    WindDTO wind;

    @SerializedName("rain")
    @Expose
    RainDTO rain;

    @SerializedName("snow")
    @Expose
    SnowDTO snow;

    @SerializedName("dt_txt")
    @Expose
    String dateTxt;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MainSpecsDTO getMainforecast() {
        return mainforecast;
    }

    public void setMainforecast(MainSpecsDTO mainforecast) {
        this.mainforecast = mainforecast;
    }

    public List<WeatherDTO> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherDTO> forecast) {
        this.forecast = forecast;
    }

    public CloudsDTO getClouds() {
        return clouds;
    }

    public void setClouds(CloudsDTO clouds) {
        this.clouds = clouds;
    }

    public WindDTO getWind() {
        return wind;
    }

    public void setWind(WindDTO wind) {
        this.wind = wind;
    }

    public RainDTO getRain() {
        return rain;
    }

    public void setRain(RainDTO rain) {
        this.rain = rain;
    }

    public SnowDTO getSnow() {
        return snow;
    }

    public void setSnow(SnowDTO snow) {
        this.snow = snow;
    }

    public String getDateTxt() {
        return dateTxt;
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt = dateTxt;
    }
}
