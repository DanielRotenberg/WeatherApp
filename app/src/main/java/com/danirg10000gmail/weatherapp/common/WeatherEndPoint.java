package com.danirg10000gmail.weatherapp.common;

import com.danirg10000gmail.weatherapp.common.data.Area;
import com.danirg10000gmail.weatherapp.common.data.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DanielR on 17/11/2017.
 */

public interface WeatherEndPoint {

  @GET("weather")
  Call<City> getWeatherByCityName(@Query("q") String cityName,@Query ("APPID") String apiKey);

  @GET("weather")
  Call<City> getWeatherByLocation(@Query("lat") double lat, @Query("lon") double lon, @Query ("APPID") String apiKey);

  @GET("group")
  Call<Area> getWeatherForCities(@Query("id")String id , @Query("units")String metric, @Query ("APPID") String apiKey);
}
