package com.danirg10000gmail.weatherapp.weather;


import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;


/**
 * Created by DanielR on 17/11/2017.
 */

public class WeatherPresenter implements WeatherContract.Presenter {

  WeatherContract.View view;
  NetworkModule networkModule;

  public WeatherPresenter(WeatherContract.View view, NetworkModule networkModule) {
    this.view = view;
    this.networkModule = networkModule;
  }

  @Override
  public void start() {

  }

  @Override
  public void getCity() {

  }
}
