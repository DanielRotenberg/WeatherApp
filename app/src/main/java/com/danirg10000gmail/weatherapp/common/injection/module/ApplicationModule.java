package com.danirg10000gmail.weatherapp.common.injection.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by DanielR on 17/11/2017.
 */
@Module
public class ApplicationModule {

  Application weatherApplication;

  public ApplicationModule(Application weatherApplication) {
    this.weatherApplication = weatherApplication;
  }

  @Provides
  @Singleton
  Application provideApplication(){
    return weatherApplication;
  }
}
