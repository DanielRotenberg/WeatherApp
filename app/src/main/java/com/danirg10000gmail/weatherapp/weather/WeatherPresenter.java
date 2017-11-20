package com.danirg10000gmail.weatherapp.weather;


import com.danirg10000gmail.weatherapp.common.WeatherRepository;
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
  }

  @Override
  public void getCity() {

  }
}
