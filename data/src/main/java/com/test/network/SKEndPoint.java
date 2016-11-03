package com.test.network;


import com.test.network.entity.ResponseDTO;
import com.test.network.entity.ResponseNowDTO;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 25/07/2016
 */
public interface SKEndPoint {


    //    Description:
    //    You can seach weather forecast for 5 days with data every 3 hours by geographic coordinates.
    //    All weather data can be obtained in JSON, XML or HTML format.
    //    API call:
    //    api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}
    //    Parameters:
    //    lat, lon coordinates of the location of your interest
    //    Examples of API calls:
    //    api.openweathermap.org/data/2.5/forecast?lat=35&lon=139

    @GET(SKConfig.SK_VERSION + "forecast?")
    Observable<ResponseDTO> getWeatherByCoordinates(@Query("lat") String latitude,
                                                    @Query("lon") String longitude,
                                                    @Query("appid") String appId);


    //    Description:
    //    You can seach weather forecast for 5 days with data every 3 hours by city name.
    //    All weather data can be obtained in JSON, XML or HTML format.
    //    API call:
    //    api.openweathermap.org/data/2.5/forecast?q={city name},{country code}
    //    Parameters:
    //    q city name and country code divided by comma, use ISO 3166 country codes
    //    Examples of API calls:
    //    api.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml

    @GET(SKConfig.SK_VERSION + "/forecast?")
    Observable<ResponseDTO> getWeatherByCityName(@Query("q") String cityName,
                                                 @Query("appid") String appId);




    @GET(SKConfig.SK_VERSION + "/weather?")
    Observable<ResponseNowDTO> getWeatherNowByCoordinates(@Query("lat") String latitude,
                                                          @Query("lon") String longitude,
                                                          @Query("appid") String appId);


    //    Description:
    //    You can seach weather forecast for 5 days with data every 3 hours by city name.
    //    All weather data can be obtained in JSON, XML or HTML format.
    //    API call:
    //    api.openweathermap.org/data/2.5/forecast?q={city name},{country code}
    //    Parameters:
    //    q city name and country code divided by comma, use ISO 3166 country codes
    //    Examples of API calls:
    //    api.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml

    @GET(SKConfig.SK_VERSION + "/weather?")
    Observable<ResponseNowDTO> getWeatherNowByCityName(@Query("q") String cityName,
                                                 @Query("appid") String appId);
}
