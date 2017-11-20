package com.danirg10000gmail.weatherapp.weather;

import com.danirg10000gmail.weatherapp.common.injection.component.SingletonComponent;
import dagger.Component;

/**
 * Created by DanielR on 17/11/2017.
 */
@PerActivity
@Component(modules = WeatherModule.class, dependencies = SingletonComponent.class)
public interface WeatherComponent {

  void inject(WeatherActivity weatherActivity);

}
