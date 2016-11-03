package com.test.business.entity.components;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class Weather {
    private String main;
    private String description;
    private String iconUrl;

    public Weather(String main, String description, String iconUrl) {
        this.main = main;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}


