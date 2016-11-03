package com.test.network.entity;

import com.test.business.controller.network.ResponseNow;
import com.test.business.entity.City;
import com.test.business.entity.Coordinates;
import com.test.business.entity.InternalForecast;
import com.test.business.entity.MainSpecs;
import com.test.business.entity.Response;
import com.test.business.entity.components.Clouds;
import com.test.business.entity.components.Rain;
import com.test.business.entity.components.Snow;
import com.test.business.entity.components.Weather;
import com.test.business.entity.components.Wind;
import com.test.network.SKConfig;
import com.test.network.entity.components.CloudsDTO;
import com.test.network.entity.components.RainDTO;
import com.test.network.entity.components.SnowDTO;
import com.test.network.entity.components.WeatherDTO;
import com.test.network.entity.components.WindDTO;
import com.test.network.utils.UnitConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class Adapter {

    public static ResponseNow convertResponseNowDTO(ResponseNowDTO dto) {
        ResponseNow toRet = new ResponseNow(
                convertCoordinatesDTO(dto.getCoordinates()),
                convertListWeatherDTO(dto.getWeather()),
                convertWindDTO(dto.getWind()),
                convertRainDTO(dto.getRain()),
                convertCloudsDTO(dto.getClouds()),
                convertMainSpecsDTO(dto.getMain()),
                dto.getCityName()
        );
        return toRet;
    }

    public static Response convertResponseDTO(ResponseDTO dto) {
        Response toRet = new Response(
                convertCityDTO(dto.getCity()),
                convertListInternalForecastDTO(dto.getWeatherList()));

        return toRet;
    }

    public static City convertCityDTO(CityDTO dto) {
        City toRet = new City(dto.getId(),
                dto.getCityName(),
                dto.getCountry(),
                dto.getPopulation(),
                convertCoordinatesDTO(dto.getCoordinates()));
        return toRet;
    }

    public static List<InternalForecast> convertListInternalForecastDTO(List<InternalForecastDTO> dtoList) {
        List<InternalForecast> toRet = new ArrayList<>();
        for (InternalForecastDTO dto : dtoList) {
            toRet.add(convertInternalForecastDTO(dto));
        }
        return toRet;
    }

    public static InternalForecast convertInternalForecastDTO(InternalForecastDTO dto) {

        InternalForecast toRet = new InternalForecast(
                dto.getDate(),
                dto.getDateTxt(),
                convertListWeatherDTO(dto.getForecast()),
                convertMainSpecsDTO(dto.getMainforecast()),
                convertCloudsDTO(dto.getClouds()),
                convertWindDTO(dto.getWind()),
                convertRainDTO(dto.getRain()),
                convertSnowDTO(dto.getSnow()));

        return toRet;
    }


    public static MainSpecs convertMainSpecsDTO(MainSpecsDTO dto) {

        MainSpecs toRet = new MainSpecs(
                UnitConvertor.convertTemperature(dto.getTemp()),
                UnitConvertor.convertTemperature(dto.getTempMin()),
                UnitConvertor.convertTemperature(dto.getTempMax()),
                dto.getPressure(),
                dto.getSea_level(),
                dto.getGrnd_level(),
                dto.getHumidity(),
                dto.getTemp_kf()
        );

        return toRet;
    }

    public static List<Weather> convertListWeatherDTO(List<WeatherDTO> dtoList) {
        List<Weather> toRet = new ArrayList<>();
        for (WeatherDTO dto : dtoList) {
            toRet.add(convertWeatherDTO(dto));
        }
        return toRet;
    }

    public static Weather convertWeatherDTO(WeatherDTO dto) {

        String desc = dto.getDescription().substring(0, 1).toUpperCase() + dto.getDescription().substring(1);
        Weather toRet = new Weather(
                dto.getMain(),
                desc,
                SKConfig.SK_ENDPOINT_FOR_ICONS + dto.getIcon() + ".png"
        );

        return toRet;
    }


    public static Coordinates convertCoordinatesDTO(CoordinatesDTO dto) {

        Coordinates toRet = new Coordinates(
                dto.getLat(),
                dto.getLon()
        );

        return toRet;
    }


    public static Clouds convertCloudsDTO(CloudsDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Clouds toRet = new Clouds(
                    dto.getCloudiness()
            );
            return toRet;
        }

    }

    public static Rain convertRainDTO(RainDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Rain toRet = new Rain(
                    dto.getVolume()
            );

            return toRet;
        }
    }

    public static Snow convertSnowDTO(SnowDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Snow toRet = new Snow(
                    dto.getVolume()
            );

            return toRet;
        }
    }

    public static Wind convertWindDTO(WindDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Wind toRet = new Wind(
                    dto.getSpeed(),
                    dto.getDegree(),
                    UnitConvertor.getHeading(dto.getDegree()),
                    UnitConvertor.getBeaufortName(UnitConvertor.getWindPower(dto.getSpeed()))
            );


            return toRet;
        }
    }

}
