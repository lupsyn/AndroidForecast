package com.test.business.view;

import com.test.business.controller.network.ResponseNow;
import com.test.business.entity.City;
import com.test.business.entity.InternalForecast;

import java.util.List;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 31/07/2016
 */
public interface MainView {

    void showMessage(final String msg);

    void showProgressBar(boolean value);

    void refresh(List<InternalForecast> forecast);

    void refreshNowPlace(ResponseNow city);

}
