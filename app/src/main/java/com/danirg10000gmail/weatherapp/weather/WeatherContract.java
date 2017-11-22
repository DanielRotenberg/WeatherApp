package com.danirg10000gmail.weatherapp.weather;

import com.danirg10000gmail.weatherapp.common.base.BasePresenter;
import com.danirg10000gmail.weatherapp.common.base.BaseView;
import com.danirg10000gmail.weatherapp.common.data.City;

import java.util.List;

/**
 * Created by DanielR on 17/11/2017.
 */

public interface WeatherContract {

  interface View extends BaseView<Presenter> {

    void showCitiesList(List<City> citiesList);

    void showError();

    void showCurrentLocationWeather(String weather);

  }

  interface Presenter extends BasePresenter {

    void getCity();

    void getWeatherForLocation(double lat, double lot);

    void getListOfCities();
  }
}
