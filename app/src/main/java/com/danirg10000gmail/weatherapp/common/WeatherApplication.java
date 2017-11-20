package com.danirg10000gmail.weatherapp.common;

import android.app.Application;
import android.util.Log;
import com.danirg10000gmail.weatherapp.common.injection.component.DaggerSingletonComponent;
import com.danirg10000gmail.weatherapp.common.injection.component.SingletonComponent;
import com.danirg10000gmail.weatherapp.common.injection.module.ApplicationModule;
import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;

/**
 * Created by DanielR on 17/11/2017.
 */

public class WeatherApplication extends Application {

  SingletonComponent singletonComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    singletonComponent = DaggerSingletonComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .networkModule(new NetworkModule())
        .weatherDataSourceModel(new WeatherDataSourceModel()).build();
    Log.e("jira", "onCreate: null? "+(singletonComponent==null) );

  }

  public SingletonComponent getSingletonComponent() {
    return singletonComponent;
  }
}
