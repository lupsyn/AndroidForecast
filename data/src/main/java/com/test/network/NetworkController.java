package com.test.network;


import android.content.Context;

import com.test.business.controller.network.INetworkController;
import com.test.business.controller.network.WeatherCallback;
import com.test.business.controller.network.WeatherNowCallback;
import com.test.network.entity.ResponseDTO;
import com.test.network.entity.ResponseNowDTO;

import java.util.concurrent.TimeUnit;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.test.network.entity.Adapter.convertResponseDTO;
import static com.test.network.entity.Adapter.convertResponseNowDTO;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 27/07/2016
 */
public class NetworkController implements INetworkController {
    private SKEndPoint mSKEndPointAPI;
    private Context mContext;

    public NetworkController(Context context) {
        mContext = context;
        mSKEndPointAPI = new SKEndPointBuilder(context).buildEndpoint(SKEndPoint.class, SKConfig.SK_ENDPOINT);

    }


    @Override
    public void getWeatherByCoordinates(double latitude, double longitude, final WeatherCallback callback) {
        mSKEndPointAPI.getWeatherByCoordinates("" + latitude, "" + longitude, SKConfig.SK_APPID)
                .retry(SKConfig.SK_RETRY_VALUE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .timeout(SKConfig.SK_RETRY_TIMEOUT, TimeUnit.SECONDS)
                .subscribe(new Subscriber<ResponseDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            if (((HttpException) e).response().code() == 401) {
                                callback.onAuthError();
                            } else if (((HttpException) e).response().code() == 502) {
                                callback.onError("City not found!");
                            } else {
                                callback.onNetworkError();
                            }
                        } else
                            callback.onNetworkError();
                    }

                    @Override
                    public void onNext(ResponseDTO responseDTO) {
                        callback.onSuccess(convertResponseDTO(responseDTO));
                    }
                });
    }

    @Override
    public void getWeatherByCityName(String cityName, final WeatherCallback callback) {
        mSKEndPointAPI.getWeatherByCityName(cityName, SKConfig.SK_APPID)
                .retry(SKConfig.SK_RETRY_VALUE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .timeout(SKConfig.SK_RETRY_TIMEOUT, TimeUnit.SECONDS)
                .subscribe(new Subscriber<ResponseDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            if (((HttpException) e).response().code() == 401) {
                                callback.onAuthError();
                            } else if (((HttpException) e).response().code() == 502) {
                                callback.onError("City not found!");
                            } else {
                                callback.onNetworkError();
                            }
                        } else
                            callback.onNetworkError();
                    }

                    @Override
                    public void onNext(ResponseDTO responseDTO) {
                        callback.onSuccess(convertResponseDTO(responseDTO));
                    }
                });

    }

    @Override
    public void getWeatherNowByCoordinates(double latitude, double longitude, final WeatherNowCallback callback) {
        mSKEndPointAPI.getWeatherNowByCoordinates("" + latitude, "" + longitude, SKConfig.SK_APPID)
                .retry(SKConfig.SK_RETRY_VALUE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .timeout(SKConfig.SK_RETRY_TIMEOUT, TimeUnit.SECONDS)
                .subscribe(new Subscriber<ResponseNowDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            if (((HttpException) e).response().code() == 401) {
                                callback.onAuthError();
                            } else if (((HttpException) e).response().code() == 502) {
                                callback.onError("City not found!");
                            } else {
                                callback.onNetworkError();
                            }
                        } else
                            callback.onNetworkError();
                    }

                    @Override
                    public void onNext(ResponseNowDTO responseDTO) {
                        callback.onSuccess(convertResponseNowDTO(responseDTO));
                    }
                });
    }

    @Override
    public void getWeatherNowByCityName(String cityName, final WeatherNowCallback callback) {
        mSKEndPointAPI.getWeatherNowByCityName(cityName, SKConfig.SK_APPID)
                .retry(SKConfig.SK_RETRY_VALUE)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .timeout(SKConfig.SK_RETRY_TIMEOUT, TimeUnit.SECONDS)
                .subscribe(new Subscriber<ResponseNowDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            if (((HttpException) e).response().code() == 401) {
                                callback.onAuthError();
                            } else if (((HttpException) e).response().code() == 502) {
                                callback.onError("City not found!");
                            } else {
                                callback.onNetworkError();
                            }
                        } else
                            callback.onNetworkError();

                    }

                    @Override
                    public void onNext(ResponseNowDTO responseDTO) {
                        callback.onSuccess(convertResponseNowDTO(responseDTO));
                    }
                });
    }


}
