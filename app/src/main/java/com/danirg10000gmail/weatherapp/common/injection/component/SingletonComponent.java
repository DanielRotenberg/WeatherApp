package com.danirg10000gmail.weatherapp.common.injection.component;

import com.danirg10000gmail.weatherapp.common.WeatherDataSource;
import com.danirg10000gmail.weatherapp.common.WeatherDataSourceModel;
import com.danirg10000gmail.weatherapp.common.WeatherRepository;
import com.danirg10000gmail.weatherapp.common.injection.module.ApplicationModule;
import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by DanielR on 17/11/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, WeatherDataSourceModel.class})
public interface SingletonComponent {

  WeatherRepository getWeatherRepository();

}
