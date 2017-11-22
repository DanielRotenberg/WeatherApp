package com.danirg10000gmail.weatherapp.common.model;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by DanielR on 20/11/2017.
 */
@Module
public class WeatherDataSourceModel {

  @Provides
  @Singleton

  public WeatherRepository provideWeatherRepository(WeatherDataSource weatherDataSource){
    return new WeatherRepository(weatherDataSource);
  }

}
