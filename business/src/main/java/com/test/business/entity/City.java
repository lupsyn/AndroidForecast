package com.test.business.entity;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */


public class City {

    private String id;
    private String cityName;
    private String country;
    private int population;
    private Coordinates mCoordinates;

    public City(String id, String cityName, String country, int population, Coordinates coordinates) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.population = population;
        mCoordinates = coordinates;
    }

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

    public Coordinates getCoordinates() {
        return mCoordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        mCoordinates = coordinates;
    }
}
