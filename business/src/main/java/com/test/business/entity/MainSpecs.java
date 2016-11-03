package com.test.business.entity;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class MainSpecs {

//    list.main.temp Temperature. Unit Default: Kelvin,
//    list.main.pressure Atmospheric pressure on the sea level by default, hPa
//    list.main.sea_level Atmospheric pressure on the sea level, hPa
//    list.main.grnd_level Atmospheric pressure on the ground level, hPa
//    list.main.humidity Humidity, %


    private double temp;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double sea_level;
    private double grnd_level;
    private double humidity;
    private double temp_kf;

    public MainSpecs(double temp, double tempMin, double tempMax, double pressure, double sea_level, double grnd_level, double humidity, double temp_kf) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getSea_level() {
        return sea_level;
    }

    public void setSea_level(double sea_level) {
        this.sea_level = sea_level;
    }

    public double getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(double grnd_level) {
        this.grnd_level = grnd_level;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(double temp_kf) {
        this.temp_kf = temp_kf;
    }
}
