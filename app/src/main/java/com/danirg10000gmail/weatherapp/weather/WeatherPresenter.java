package com.danirg10000gmail.weatherapp.weather;


import com.danirg10000gmail.weatherapp.common.WeatherDataSource;
import com.danirg10000gmail.weatherapp.common.WeatherDataSource.GetCurrentLocationWeatherCallback;
import com.danirg10000gmail.weatherapp.common.WeatherDataSource.GetWeatherForCityCallback;
import com.danirg10000gmail.weatherapp.common.WeatherRepository;
import com.danirg10000gmail.weatherapp.common.data.City;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by DanielR on 17/11/2017.
 */
@PerActivity
public class WeatherPresenter implements WeatherContract.Presenter {

  WeatherContract.View weatherView;
  WeatherRepository weatherRepository;

  @Inject
  public WeatherPresenter(WeatherContract.View weatherView, WeatherRepository weatherRepository) {
    this.weatherView = weatherView;
    this.weatherRepository = weatherRepository;
  }

  @Override
  public void start() {
    getListOfCities();
  }

  //currently not used
  @Override
  public void getCity() {

    weatherRepository.getCityByName("london", new GetWeatherForCityCallback() {
      @Override
      public void onSuccess(City city) {

      }

      @Override
      public void onError() {
        weatherView.showError();
      }
    });
  }

  @Override
  public void getWeatherForLocation(double lat, double lot) {
    weatherRepository.getCityByLocation(lat, lot, new GetCurrentLocationWeatherCallback() {
      @Override
      public void onSuccess(String weather) {
        weatherView.showCurrentLocationWeather(weather);
      }

      @Override
      public void onError() {
        weatherView.showError();
      }
    });
  }

  @Override
  public void getListOfCities() {
    String citiesIdList = "524901,703448,2643743";
    weatherRepository
        .getCitesListById(citiesIdList, new WeatherDataSource.getWeatherForCitiesListCallback() {
          @Override
          public void onSuccess(List<City> cities) {
            weatherView.showCitiesList(cities);
          }

          @Override
          public void onError() {
            weatherView.showError();
          }
        });
  }
}
