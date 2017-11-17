package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanielR on 17/11/2017.
 */

public class City {
  @SerializedName("id")
  private Integer id;
  @SerializedName("weather")
  private List<Weather> weather = new ArrayList<>();
  @SerializedName("main")
  private Main main;
  @SerializedName("dt")
  private Integer dt;
  @SerializedName("sys")
  private Sys sys;
  @SerializedName("name")
  private String name;

  private boolean currentLocationCity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Weather> getWeather() {
    return weather;
  }

  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public Main getMain() {
    return main;
  }

  public void setMain(Main main) {
    this.main = main;
  }

  public Integer getDt() {
    return dt;
  }

  public void setDt(Integer dt) {
    this.dt = dt;
  }

  public Sys getSys() {
    return sys;
  }

  public void setSys(Sys sys) {
    this.sys = sys;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isCurrentLocationCity() {
    return currentLocationCity;
  }

  public void setCurrentLocationCity(boolean currentLocationCity) {
    this.currentLocationCity = currentLocationCity;
  }

  @Override
  public String toString() {
    return "WeatherInCity{" +
        "id=" + id +
        ", weather=" + weather +
        ", main=" + main +
        ", dt=" + dt +
        ", sys=" + sys +
        ", name='" + name + '\'' +
        ", currentLocationCity=" + currentLocationCity +
        '}';
  }
}
