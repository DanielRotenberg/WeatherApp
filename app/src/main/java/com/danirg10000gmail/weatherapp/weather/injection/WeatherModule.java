package com.danirg10000gmail.weatherapp.weather.injection;

import android.content.Context;

import com.danirg10000gmail.weatherapp.weather.WeatherContract.Presenter;
import com.danirg10000gmail.weatherapp.weather.WeatherContract.View;
import com.danirg10000gmail.weatherapp.weather.WeatherPresenter;
import com.danirg10000gmail.weatherapp.weather.injection.PerActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import dagger.Module;
import dagger.Provides;

/**
 * Created by DanielR on 17/11/2017.
 */

@Module
public class WeatherModule {

  View view;

  public WeatherModule(View view) {
    this.view = view;
  }


  @Provides
  @PerActivity
  View provideWeatherView(){
    return view;
  }

  @Provides
  Presenter provideWeatherPresenter(WeatherPresenter weatherPresenter){
    return weatherPresenter;

  }

  @Provides
  @PerActivity
  FusedLocationProviderClient provideLocationProvider(Context context){
    return LocationServices.getFusedLocationProviderClient(context);
  }

}
