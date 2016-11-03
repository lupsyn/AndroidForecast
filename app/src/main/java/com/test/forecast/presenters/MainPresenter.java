package com.test.forecast.presenters;


import android.content.Context;

import com.test.business.MainLogic;
import com.test.business.view.MainView;
import com.test.location.LocationController;
import com.test.logger.LoggerController;
import com.test.network.NetworkController;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 31/07/2016
 */
public class MainPresenter {
    private MainLogic mMainLogic;
    private MainView mView;
    private Context context;


    public MainPresenter(Context context) {
        mMainLogic = MainLogic.getInstance();
        mMainLogic.setControllers(new NetworkController(context), new LoggerController(), new LocationController(context));
        this.context = context;

    }

    public void onCreate(MainView view) {
        mMainLogic.onMainViewCreated(view);

    }

    public void onQuery(String city) {
        mMainLogic.onAskWheatherFor(city);
    }

    public void onLocationAsked() {
        mMainLogic.onWheatherForCurrentLocation();
    }

    public void onRefresh() {
        mMainLogic.onMainViewRefresh();
    }

    public void onPause() {

        mMainLogic.onMainViewPause();
    }

    public void onDestroy() {
        mMainLogic.onMainViewDestroy();
    }
}
