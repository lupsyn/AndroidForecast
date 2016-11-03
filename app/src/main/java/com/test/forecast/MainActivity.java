package com.test.forecast;

import android.app.SearchManager;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.business.controller.network.ResponseNow;
import com.test.business.entity.InternalForecast;
import com.test.business.view.MainView;
import com.test.forecast.adapters.ForecastRecyclerAdapter;
import com.test.forecast.presenters.MainPresenter;
import com.test.forecast.utils.PermissionsManager;
import com.test.forecast.utils.RecyclerViewEmptySupport;
import com.test.weather.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mainPresenter;

    private CoordinatorLayout mCoordinatorLayout;
    private RecyclerViewEmptySupport recyclerView;
    private ForecastRecyclerAdapter weatherRecyclerAdapter;
    private ProgressBar progressBar;
    private TextView emptyView;
    private TextView itemCityName;
    private TextView itemHeaderDescription;
    private TextView itemHeaderWind;
    private TextView itemHeaderPressure;
    private TextView itemHeaderHumidity;
    private TextView itemHeaderTemperature;
    private ImageView itemHeaderIcon;
    private PermissionsManager mPermissionManager;
    private FloatingActionButton floatingButton;
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setEmptyView(emptyView);
        weatherRecyclerAdapter = new ForecastRecyclerAdapter(this, new ArrayList<InternalForecast>());
        recyclerView.setAdapter(weatherRecyclerAdapter);
        mPermissionManager = new PermissionsManager(this);
        mainPresenter = new MainPresenter(this);

        if (mPermissionManager.canIRun()) {
            mainPresenter.onCreate(this);
        } else {
            showMessage("Some permissions are missing!");
        }
    }


    private void initViews() {
        recyclerView = (RecyclerViewEmptySupport) findViewById(R.id.recycleview);
        progressBar = (ProgressBar) findViewById(R.id.process_progressBar);
        emptyView = (TextView) findViewById(R.id.emptylist);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        itemCityName = (TextView) findViewById(R.id.itemCityName);
        itemHeaderDescription = (TextView) findViewById(R.id.itemHeaderDescription);
        itemHeaderWind = (TextView) findViewById(R.id.itemHeaderWind);
        itemHeaderPressure = (TextView) findViewById(R.id.itemHeaderPressure);
        itemHeaderHumidity = (TextView) findViewById(R.id.itemHeaderHumidity);
        itemHeaderIcon = (ImageView) findViewById(R.id.itemHeaderIcon);
        itemHeaderTemperature = (TextView) findViewById(R.id.itemHeaderTemperature);
        floatingButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPermissionManager.canIRun()) {
                    weatherRecyclerAdapter.clear();
                    mainPresenter.onLocationAsked();
                } else {
                    showMessage("Some permissions are missing!");
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        mSearchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String text) {
                weatherRecyclerAdapter.clear();
                mainPresenter.onQuery(text);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;


    }

    @Override
    public void showMessage(final String msg) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Snackbar snackbar = Snackbar
                        .make(mCoordinatorLayout, msg, Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

    @Override
    public void showProgressBar(final boolean value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                emptyView.setVisibility(value ? View.INVISIBLE : View.VISIBLE);
                progressBar.setVisibility(value ? View.VISIBLE : View.GONE);
            }
        });

    }

    @Override
    public void refresh(List<InternalForecast> forecast) {
        mSearchView.setQuery("", false);
        mSearchView.onActionViewCollapsed();

        weatherRecyclerAdapter.addAll(forecast);
        weatherRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshNowPlace(final ResponseNow responseNow) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                itemCityName.setText(responseNow.getCityName() + " right now");
                itemHeaderDescription.setText("Weather : " + responseNow.getWeather().get(0).getDescription());
                itemHeaderWind.setText(responseNow.getWind().getDescription());
                itemHeaderPressure.setText("Pressure : " + responseNow.getMainSpecs().getPressure() + " hPa");
                itemHeaderHumidity.setText("Humidity : " + responseNow.getMainSpecs().getHumidity() + " %");
                itemHeaderTemperature.setText("" + responseNow.getMainSpecs().getTemp() + "°C");
                Picasso.with(MainActivity.this).load(responseNow.getWeather().get(0).getIconUrl()).into(itemHeaderIcon);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (mPermissionManager.hasAllPermissions()) {
            weatherRecyclerAdapter.clear();
            mainPresenter.onCreate(this);
        }
    }
}
