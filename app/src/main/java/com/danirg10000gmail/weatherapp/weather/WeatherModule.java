package com.danirg10000gmail.weatherapp.weather;

import android.content.Context;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import dagger.Module;
import dagger.Provides;

/**
 * Created by DanielR on 17/11/2017.
 */

@Module
public class WeatherModule {

  WeatherContract.View view;

  public WeatherModule(WeatherContract.View view) {
    this.view = view;
  }


  @Provides
  @PerActivity
  WeatherContract.View provideWeatherView(){
    return view;
  }

  @Provides
  WeatherContract.Presenter provideWeatherPresenter(WeatherPresenter weatherPresenter){
    return weatherPresenter;

  }

  @Provides
  @PerActivity
  FusedLocationProviderClient provideLocationProvider(Context context){
    return LocationServices.getFusedLocationProviderClient(context);
  }

}
