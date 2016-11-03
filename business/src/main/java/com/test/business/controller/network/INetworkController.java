package com.test.business.controller.network;


import com.test.business.controller.network.WeatherCallback;
import com.test.business.controller.network.WeatherNowCallback;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 27/07/2016
 */
public interface INetworkController {

    void getWeatherByCoordinates(double latitude, double longitude, WeatherCallback callback);

    void getWeatherByCityName(String cityName, WeatherCallback callback);

    void getWeatherNowByCoordinates(double latitude, double longitude, WeatherNowCallback callback);

    void getWeatherNowByCityName(String cityName, WeatherNowCallback callback);

}
