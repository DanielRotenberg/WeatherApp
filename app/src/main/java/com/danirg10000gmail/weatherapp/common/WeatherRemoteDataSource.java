package com.danirg10000gmail.weatherapp.common;

import com.danirg10000gmail.weatherapp.common.data.City;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 20/11/2017.
 */
@Singleton
public class WeatherRemoteDataSource implements WeatherDataSource {

  WeatherEndPoint weatherEndPoint;

  @Inject
  public WeatherRemoteDataSource(WeatherEndPoint weatherEndPoint) {
    this.weatherEndPoint = weatherEndPoint;
  }

  @Override
  public List<City> getCities() {
    return null;
  }

  @Override
  public void getCityById(int id) {

  }
}
