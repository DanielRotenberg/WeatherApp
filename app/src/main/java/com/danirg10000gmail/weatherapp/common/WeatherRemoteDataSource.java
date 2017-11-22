package com.danirg10000gmail.weatherapp.common;

import android.util.Log;

import com.danirg10000gmail.weatherapp.common.data.Area;
import com.danirg10000gmail.weatherapp.common.data.City;
import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule.*;

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
  public void getCitesListById(String id, getWeatherForCitiesListCallback callback) {
    Call<Area> call = weatherEndPoint.getWeatherForCities(id,UNITS,API_KEY);
    call.enqueue(new Callback<Area>() {
      @Override
      public void onResponse(Call<Area> call, Response<Area> response) {
        List<City> listResult = response.body().getCitiesList();
        callback.onSuccess(listResult);
      }

      @Override
      public void onFailure(Call<Area> call, Throwable t) {
        callback.onError();
      }
    });

  }

  @Override
  public void getCityByName(String name, GetWeatherForCityCallback callback) {
    Call<City> call = weatherEndPoint.getWeatherByCityName(name, API_KEY);
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
    Call<City> call = weatherEndPoint.getWeatherByLocation(lat, lot, API_KEY);

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
