package com.test.business;

import com.test.business.controller.ILoggerController;
import com.test.business.controller.location.ILocationController;
import com.test.business.controller.location.LocationCallback;
import com.test.business.controller.network.INetworkController;
import com.test.business.controller.network.ResponseNow;
import com.test.business.controller.network.WeatherCallback;
import com.test.business.controller.network.WeatherNowCallback;
import com.test.business.entity.Coordinates;
import com.test.business.entity.Response;
import com.test.business.view.MainView;

import java.security.InvalidParameterException;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 02/11/2016
 */
public class MainLogic {
    private INetworkController mNetworkController;
    private ILoggerController mILoggerController;
    private ILocationController mILocationController;

    private MainView mMainView;

    private static MainLogic ourInstance = new MainLogic();

    public static MainLogic getInstance() {
        return ourInstance;
    }

    private MainLogic() {
    }

    public void setControllers(INetworkController networkController,
                               ILoggerController loggerController,
                               ILocationController locationController) {
        this.mNetworkController = networkController;
        this.mILoggerController = loggerController;
        this.mILocationController = locationController;
        if (mNetworkController == null || mILoggerController == null || mILocationController == null) {
            throw new InvalidParameterException("Controllers cannot be null");
        }
    }


    public void onMainViewCreated(MainView view) {
        mMainView = view;
        mMainView.showProgressBar(true);
        mILocationController.requestLatestLocation(mLocationCallback);
    }


    public void onMainViewRefresh() {
    }

    public void onMainViewPause() {
    }

    public void onMainViewDestroy() {
        mILocationController.onActivityDestroy();
    }


    public void onAskWheatherFor(String city) {
        mMainView.showProgressBar(true);
        getWeatherAndForecastByName(city);
    }

    public void onWheatherForCurrentLocation() {
        mMainView.showProgressBar(true);
        mILocationController.requestLatestLocation(mLocationCallback);
    }


    private void getWeatherAndForecastByName(final String cityName) {
        mNetworkController.getWeatherNowByCityName(cityName, new WeatherNowCallback() {
            @Override
            public void onSuccess(ResponseNow response) {
                mMainView.refreshNowPlace(response);
                mNetworkController.getWeatherByCityName(cityName, new WeatherCallback() {
                    @Override
                    public void onSuccess(Response response) {
                        mMainView.showProgressBar(false);
                        mMainView.refresh(response.getForecast());
                    }

                    @Override
                    public void onNetworkError() {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage("Network error, retry later!");
                    }

                    @Override
                    public void onAuthError() {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage("Auth error on api!");
                    }

                    @Override
                    public void onError(String error) {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage(error);
                    }
                });
            }

            @Override
            public void onNetworkError() {
                mMainView.showProgressBar(false);
                mMainView.showMessage("Network error, retry later!");
            }

            @Override
            public void onAuthError() {
                mMainView.showProgressBar(false);
                mMainView.showMessage("Auth error on api!");
            }

            @Override
            public void onError(String error) {
                mMainView.showProgressBar(false);
                mMainView.showMessage(error);
            }
        });

    }

    private void getWeatherAndForecastBytCoordinates(final double latitude, final double longitude) {
        mNetworkController.getWeatherNowByCoordinates(latitude, longitude, new WeatherNowCallback() {
            @Override
            public void onSuccess(ResponseNow response) {
                mMainView.refreshNowPlace(response);
                mNetworkController.getWeatherByCoordinates(latitude, longitude, new WeatherCallback() {
                    @Override
                    public void onSuccess(Response response) {
                        mMainView.showProgressBar(false);
                        mMainView.refresh(response.getForecast());
                    }

                    @Override
                    public void onNetworkError() {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage("Network error, retry later!");
                    }

                    @Override
                    public void onAuthError() {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage("Auth error on api!");
                    }

                    @Override
                    public void onError(String error) {
                        mMainView.showProgressBar(false);
                        mMainView.showMessage(error);
                    }
                });
            }

            @Override
            public void onNetworkError() {
                mMainView.showProgressBar(false);
                mMainView.showMessage("Network error, retry later!");
            }

            @Override
            public void onAuthError() {
                mMainView.showProgressBar(false);
                mMainView.showMessage("Auth error on api!");
            }

            @Override
            public void onError(String error) {
                mMainView.showProgressBar(false);
                mMainView.showMessage(error);
            }
        });
    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onDetected(Coordinates location) {
            mMainView.showMessage("Coordinates detected : " + location.getLatitude() + "," + location.getLongitude());
            getWeatherAndForecastBytCoordinates(location.getLatitude(), location.getLongitude());
        }

        @Override
        public void onPermissionMissing() {
            mMainView.showProgressBar(false);
            mMainView.showMessage("Permission to localize is missing!");

        }

        @Override
        public void onError(String msg) {
            mMainView.showProgressBar(false);
            mMainView.showMessage("Error :" + msg);
        }
    };
}
