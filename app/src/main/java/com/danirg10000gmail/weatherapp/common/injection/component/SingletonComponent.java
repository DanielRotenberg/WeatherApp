package com.danirg10000gmail.weatherapp.common.injection.component;

import com.danirg10000gmail.weatherapp.common.WeatherEndPoint;
import com.danirg10000gmail.weatherapp.common.injection.module.ApplicationModule;
import com.danirg10000gmail.weatherapp.common.injection.module.NetworkModule;
import com.danirg10000gmail.weatherapp.weather.WeatherActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by DanielR on 17/11/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface SingletonComponent {

void inject(WeatherActivity weatherActivity);

WeatherEndPoint getWeatherEndPoint();

}
