package com.danirg10000gmail.weatherapp.common;

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
/*
   @Singleton
    @Provides
    WeatherRepository provideWeatherRepository(@Local WeatherDataSource localDataSource,
                                               @Remote WeatherDataSource remoteDataSource) {
        return new WeatherRepository(localDataSource, remoteDataSource);
    }


 */