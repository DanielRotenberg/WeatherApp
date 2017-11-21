package com.danirg10000gmail.weatherapp.weather;


import android.util.Log;
import com.danirg10000gmail.weatherapp.common.WeatherDataSource.GetCurrentLocationWeatherCallback;
import com.danirg10000gmail.weatherapp.common.WeatherDataSource.GetWeatherForCityCallback;
import com.danirg10000gmail.weatherapp.common.WeatherRepository;
import com.danirg10000gmail.weatherapp.common.data.City;
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

    weatherView.showCity();
    getCity();
  }

  @Override
  public void getCity() {
  weatherRepository.getCityByName("london", new GetWeatherForCityCallback() {
    @Override
    public void onSuccess(City city) {

    }

    @Override
    public void onError() {


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

      }
    });
  }
}
