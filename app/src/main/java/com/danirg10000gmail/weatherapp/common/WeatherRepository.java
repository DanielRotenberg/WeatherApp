package com.danirg10000gmail.weatherapp.common;

import com.danirg10000gmail.weatherapp.common.data.City;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 20/11/2017.
 */
@Singleton
public class WeatherRepository implements WeatherDataSource {

  private WeatherDataSource remoteDataSource;

  @Inject
  public WeatherRepository(WeatherDataSource remoteDataSource) {
    this.remoteDataSource = remoteDataSource;
  }

  @Override
  public List<City> getCities() {
    return null;
  }

  @Override
  public void getCityById(int id) {

  }
}
