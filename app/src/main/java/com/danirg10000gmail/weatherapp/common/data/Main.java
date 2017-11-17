package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielR on 17/11/2017.
 */

public class Main {
  @SerializedName("temp")
  private Double temp;
  @SerializedName("pressure")
  private Double pressure;
  @SerializedName("humidity")
  private Integer humidity;
  @SerializedName("temp_min")
  private Double tempMin;
  @SerializedName("temp_max")
  private Double tempMax;

  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Double getPressure() {
    return pressure;
  }

  public void setPressure(Double pressure) {
    this.pressure = pressure;
  }

  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  public Double getTempMin() {
    return tempMin;
  }

  public void setTempMin(Double tempMin) {
    this.tempMin = tempMin;
  }

  public Double getTempMax() {
    return tempMax;
  }

  public void setTempMax(Double tempMax) {
    this.tempMax = tempMax;
  }
}
