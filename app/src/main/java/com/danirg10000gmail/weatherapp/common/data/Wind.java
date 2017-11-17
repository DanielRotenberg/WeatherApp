package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielR on 17/11/2017.
 */

public class Wind {
@SerializedName("speed")
  private Double speed;

@SerializedName("deg")
  private Integer deg;

  public Double getSpeed() {
    return speed;
  }

  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Integer getDeg() {
    return deg;
  }

  public void setDeg(Integer deg) {
    this.deg = deg;
  }
}
