package com.test.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class CityDTO {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String cityName;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("population")
    @Expose
    private int population;
    @SerializedName("coord")
    @Expose
    private CoordinatesDTO mCoordinates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public CoordinatesDTO getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(CoordinatesDTO coordinates) {
        mCoordinates = coordinates;
    }
}
