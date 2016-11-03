package com.test.business;


import com.test.business.controller.network.INetworkController;
import com.test.business.controller.network.WeatherCallback;
import com.test.business.controller.network.WeatherNowCallback;
import com.test.business.entity.Coordinates;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 10/04/16
 */
public class NetworkControllerMock implements INetworkController {
    private Coordinates mockCoordinates;

    @Override
    public void getWeatherByCoordinates(double latitude, double longitude, WeatherCallback callback) {

    }

    @Override
    public void getWeatherByCityName(String cityName, WeatherCallback callback) {

    }

    @Override
    public void getWeatherNowByCoordinates(double latitude, double longitude, WeatherNowCallback callback) {
        mockCoordinates = new Coordinates(latitude, longitude);
    }

    @Override
    public void getWeatherNowByCityName(String cityName, WeatherNowCallback callback) {

    }

    public Coordinates getMockCoordinates() {
        return mockCoordinates;
    }
}