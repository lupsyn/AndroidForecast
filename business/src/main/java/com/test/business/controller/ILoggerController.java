package com.test.business.controller;

public interface ILoggerController {

    void logD(String TAG, String message);

    void logW(String tag, String msg);

    void logI(String tag, String msg);
}
