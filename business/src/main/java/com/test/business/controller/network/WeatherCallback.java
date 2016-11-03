package com.test.business.controller.network;

import com.test.business.entity.Response;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public interface WeatherCallback extends ErrorCallBack {
    void onSuccess(Response response);
}
