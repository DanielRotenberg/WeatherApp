package com.danirg10000gmail.weatherapp.common.injection.module;

import android.app.Application;
import com.danirg10000gmail.weatherapp.common.WeatherEndPoint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DanielR on 17/11/2017.
 */
@Module
public class NetworkModule {

  private static final String BASE_URL =  "http://api.openweathermap.org/data/2.5/";
  private static final String API_KEY = "03cb2bee2a27a5ff22edead241cbd638";


  @Provides
  @Singleton
  Cache provideOkHttpCashe(Application application) {
    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    Cache cache = new Cache(application.getCacheDir(), cacheSize);
    return cache;
  }

  @Provides
  @Singleton
  Gson provideGson(){
    return new GsonBuilder().create();
  }


  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(Cache cache){
    OkHttpClient.Builder builder = new Builder();
    builder.cache(cache);
    return builder.build();
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit(OkHttpClient client, Gson gson){
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build();

    return retrofit;
  }

  @Provides
  @Singleton
  WeatherEndPoint provideWeatherEndPoint(Retrofit retrofit){
    return retrofit.create(WeatherEndPoint.class);

  }

}


