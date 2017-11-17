package com.danirg10000gmail.weatherapp.common.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DanielR on 17/11/2017.
 */

public class Clouds {
@SerializedName("all")
  private Integer all;

  public Integer getAll() {
    return all;
  }

  public void setAll(Integer all) {
    this.all = all;
  }
}
