package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielR on 17/11/2017.
 */

public class Sys {
  @SerializedName("id")
  private Integer id;
  @SerializedName("type")
  private Integer type;
  @SerializedName("message")
  private Double message;
  @SerializedName("country")
  private String country;
  @SerializedName("sunrise")
  private Integer sunrise;
  @SerializedName("sunset")
  private Integer sunset;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getMessage() {
    return message;
  }

  public void setMessage(Double message) {
    this.message = message;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getSunrise() {
    return sunrise;
  }

  public void setSunrise(Integer sunrise) {
    this.sunrise = sunrise;
  }

  public Integer getSunset() {
    return sunset;
  }

  public void setSunset(Integer sunset) {
    this.sunset = sunset;
  }
}
