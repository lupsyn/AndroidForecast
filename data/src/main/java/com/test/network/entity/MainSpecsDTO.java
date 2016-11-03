package com.test.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */

public class MainSpecsDTO {

    @SerializedName("temp")
    @Expose
    private double temp;

    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SerializedName("pressure")
    @Expose
    private double pressure;

    @SerializedName("sea_level")
    @Expose
    private double sea_level;

    @SerializedName("grnd_level")
    @Expose
    private double grnd_level;

    @SerializedName("humidity")
    @Expose
    private double humidity;

    @SerializedName("temp_kf")
    @Expose
    private double temp_kf;


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
