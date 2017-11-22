package com.danirg10000gmail.weatherapp.weather.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by DanielR on 17/11/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
