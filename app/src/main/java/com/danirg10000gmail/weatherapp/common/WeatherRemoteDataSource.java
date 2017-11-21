package com.danirg10000gmail.weatherapp.common;

import com.danirg10000gmail.weatherapp.common.data.City;
import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
  public void getCityByName(String name, GetWeatherForCityCallback callback) {
    Call<City> call = weatherEndPoint.getWeatherByCityName(name, NetworkModule.API_KEY);
    call.enqueue(new Callback<City>() {
      @Override
      public void onResponse(Call<City> call, Response<City> response) {
        City city = response.body();
        callback.onSuccess(city);
      }

      @Override
      public void onFailure(Call<City> call, Throwable t) {
        callback.onError();
      }
    });


  }


  @Override
  public void getCityByLocation(double lat, double lot,
      GetCurrentLocationWeatherCallback callback) {
    Call<City> call = weatherEndPoint.getWeatherByLocation(lat, lot, NetworkModule.API_KEY);

    call.enqueue(new Callback<City>() {
      @Override
      public void onResponse(Call<City> call, Response<City> response) {
        City city = response.body();
        String description = city.getWeather().get(0).getDescription();
        callback.onSuccess(description);
      }

      @Override
      public void onFailure(Call<City> call, Throwable t) {
        callback.onError();
      }
    });

  }

}
