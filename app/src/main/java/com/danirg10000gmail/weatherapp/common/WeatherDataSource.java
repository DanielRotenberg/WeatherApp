package com.danirg10000gmail.weatherapp.common;

import com.danirg10000gmail.weatherapp.common.data.City;
import java.util.List;

/**
 * Created by DanielR on 20/11/2017.
 */

public interface WeatherDataSource {


  List<City> getCities();

  void getCityByName(String name, GetWeatherForCityCallback callback);

  void getCityByLocation(double lat, double lot,GetCurrentLocationWeatherCallback callback );

  interface GetCurrentLocationWeatherCallback{

    void onSuccess(String weather);

    void onError();

  }

  interface GetWeatherForCityCallback{

    void onSuccess(City city);

    void onError();
  }

}
