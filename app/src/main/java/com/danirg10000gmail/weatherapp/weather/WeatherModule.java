package com.danirg10000gmail.weatherapp.weather;

import com.danirg10000gmail.weatherapp.weather.WeatherContract.View;
import dagger.Module;
import dagger.Provides;

/**
 * Created by DanielR on 17/11/2017.
 */
@Module
public class WeatherModule {

    private WeatherContract.View view;

  public WeatherModule(View view) {
    this.view = view;
  }

  @Provides
  WeatherContract.View provideWeatherView(){
    return view;
  }
}
