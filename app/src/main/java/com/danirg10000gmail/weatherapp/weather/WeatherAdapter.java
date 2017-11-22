package com.danirg10000gmail.weatherapp.weather;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.danirg10000gmail.weatherapp.R;
import com.danirg10000gmail.weatherapp.common.data.City;
import com.danirg10000gmail.weatherapp.utils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dr9874 on 22/11/2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherVH> {

    private List<City> citiesList = new ArrayList<>();


    public WeatherAdapter(List<City> citiesList) {
        this.citiesList = citiesList;
    }

    @Override
    public WeatherAdapter.WeatherVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_weather_vh, parent, false);

        return new WeatherVH(itemView);

    }


    @Override
    public void onBindViewHolder(WeatherAdapter.WeatherVH holder, int position) {
        City city = citiesList.get(position);
        String weatherDescrption = city.getWeather().get(0).getDescription();
        holder.cityButton.setText(city.getName());
        holder.cityButton.setOnClickListener(view -> {
            DialogUtils
                .showAlertDialog(holder.itemView.getContext(),city.getName(),weatherDescrption);
        });
    }

    @Override
    public int getItemCount() {
        return citiesList.size();
    }

    static class WeatherVH extends RecyclerView.ViewHolder{

        private Button cityButton;

        public WeatherVH(View itemView) {
            super(itemView);
            cityButton = (Button) itemView;
        }
    }

}
