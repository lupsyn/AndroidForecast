package com.test.forecast.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.business.entity.InternalForecast;
import com.test.forecast.utils.DateUtil;
import com.test.weather.R;


import java.util.List;


/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 * @since 01/11/2016
 */
public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastRecyclerAdapter.ViewHolder> {
    private List<InternalForecast> itemList;
    private Context mContext;

    public ForecastRecyclerAdapter(Context context, List<InternalForecast> itemList) {
        this.itemList = itemList;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InternalForecast forecast = itemList.get(position);

        holder.itemDate.setText(DateUtil.format(mContext, Long.valueOf(forecast.getDate())));
        holder.itemTemperature.setText("" + forecast.getMainforecast().getTemp() + "°C");
        holder.itemDescription.setText("Forecast : " + forecast.getWeather().get(0).getDescription());
        holder.itemyWind.setText("Wind : " + forecast.getWind().getDescription());
        holder.itemPressure.setText("Pressure : " + forecast.getMainforecast().getPressure() + " hPa");
        holder.itemHumidity.setText("Humidity : " + forecast.getMainforecast().getHumidity() + " %");

        Picasso.with(mContext).load(forecast.getWeather().get(0).getIconUrl()).into(holder.itemIcon);

    }


    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }

    public void addAll(List<InternalForecast> forecast) {
        itemList.addAll(forecast);
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemDate;
        public TextView itemTemperature;
        public TextView itemDescription;
        public TextView itemyWind;
        public TextView itemPressure;
        public TextView itemHumidity;
        public ImageView itemIcon;
        public View lineView;

        public ViewHolder(View view) {
            super(view);
            this.itemDate = (TextView) view.findViewById(R.id.itemDate);
            this.itemTemperature = (TextView) view.findViewById(R.id.itemTemperature);
            this.itemDescription = (TextView) view.findViewById(R.id.itemDescription);
            this.itemyWind = (TextView) view.findViewById(R.id.itemWind);
            this.itemPressure = (TextView) view.findViewById(R.id.itemPressure);
            this.itemHumidity = (TextView) view.findViewById(R.id.itemHumidity);
            this.itemIcon = (ImageView) view.findViewById(R.id.itemIcon);
            this.lineView = view.findViewById(R.id.lineView);
        }
    }

    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }


}
