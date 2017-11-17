package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielR on 17/11/2017.
 */

public class Rain {
@SerializedName("dt")
  private Integer dt;

  public Integer getDt() {
    return dt;
  }

  public void setDt(Integer dt) {
    this.dt = dt;
  }
}
