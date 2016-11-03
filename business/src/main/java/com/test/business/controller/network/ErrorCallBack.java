package com.test.business.controller.network;

/**
 * Copyright (c) 2016.  All rights reserved.
 *
 * @author enricodelzotto
 * @since 09/04/16
 */
public interface ErrorCallBack {
    void onNetworkError();

    void onAuthError();

    void onError(String error);
}
