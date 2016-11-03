package com.test.business.entity;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class Response {
    private City city;
    private List<InternalForecast> forecast;

    public Response(City city, List<InternalForecast> forecast) {
        this.city = city;
        this.forecast = forecast;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<InternalForecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<InternalForecast> forecast) {
        this.forecast = forecast;
    }
}
