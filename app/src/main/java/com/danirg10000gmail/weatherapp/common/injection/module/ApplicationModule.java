package com.danirg10000gmail.weatherapp.common.injection.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by DanielR on 17/11/2017.
 */
@Module
public class ApplicationModule {

  Context weatherApplicationContext;

  public ApplicationModule(Context weatherApplicationContext) {
    this.weatherApplicationContext = weatherApplicationContext;
  }

  @Provides
  @Singleton
  Context provideApplication(){
    return weatherApplicationContext;
  }
}
