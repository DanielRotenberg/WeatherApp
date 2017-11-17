package com.danirg10000gmail.weatherapp.weather;

import com.danirg10000gmail.weatherapp.common.base.BasePresenter;
import com.danirg10000gmail.weatherapp.common.base.BaseView;

/**
 * Created by DanielR on 17/11/2017.
 */

public interface WeatherContract {

  interface View extends BaseView<Presenter> {

    void showCity();

    void showError();

  }

  interface Presenter extends BasePresenter {

    void getCity();
  }
}
