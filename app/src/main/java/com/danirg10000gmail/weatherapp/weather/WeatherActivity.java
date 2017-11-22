package com.danirg10000gmail.weatherapp.weather;

import android.Manifest;
import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import com.danirg10000gmail.weatherapp.R;
import com.danirg10000gmail.weatherapp.common.WeatherApplication;
import com.danirg10000gmail.weatherapp.common.base.BaseActivity;
import com.danirg10000gmail.weatherapp.common.data.City;
import com.danirg10000gmail.weatherapp.weather.WeatherContract.Presenter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.List;

import javax.inject.Inject;

public class WeatherActivity extends BaseActivity implements WeatherContract.View {

  private static final int LOCATION_PERMISSIONS_REQUEST = 1;

  @Inject
  WeatherContract.Presenter presenter;

  @Inject
  FusedLocationProviderClient locationProvider;

  private Button currentLocationWeatherButton;

  private RecyclerView weatherRecycler;

  @TargetApi(VERSION_CODES.M)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    initWidgets();
    initDaggerInjection();
    presenter.start();
    currentLocationWeatherButton.setOnClickListener(view -> getUserLocation() );
  }

  private void initWidgets(){
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    weatherRecycler = findViewById(R.id.weather_activity_recyclerView);
    currentLocationWeatherButton = findViewById(R.id.weather_activity_location_weather_button);

  }
  private void initDaggerInjection(){
    DaggerWeatherComponent.builder()
        .weatherModule(new WeatherModule(this))
        .singletonComponent(((WeatherApplication) getApplication()).getSingletonComponent())
        .build()
        .inject(this);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_weather, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void showCitiesList(List<City> citiesList) {
   weatherRecycler.setAdapter(new WeatherAdapter(citiesList));
   weatherRecycler.setLayoutManager(new LinearLayoutManager(this));
  }

  @Override
  public void showError() {
    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showCurrentLocationWeather(String weather) {
    showDialog("Weather for current location",weather);
  }

  private boolean locationPermissionGranted(){
  return ContextCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION)
      == PackageManager.PERMISSION_GRANTED;
}

@SuppressLint("MissingPermission")
@RequiresApi(api = VERSION_CODES.M)
private void getUserLocation(){
  if (locationPermissionGranted()) {
    locationProvider.getLastLocation()
        .addOnSuccessListener(this, location -> {
          // Got last known location. In some rare situations this can be null.
          if (location != null) {
            // Logic to handle location object
            Log.d("jira", "getUserLocation: "+location.getLatitude() +" and "+location.getLongitude());
            presenter.getWeatherForLocation(location.getLatitude(),location.getLongitude());
          }
        });
  } else{
    requestLocationPermission();
  }
}
  
  @RequiresApi(api = VERSION_CODES.M)
  private void requestLocationPermission() {
    requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
        LOCATION_PERMISSIONS_REQUEST);

  }

  @RequiresApi(api = VERSION_CODES.M)
  @Override
  public void onRequestPermissionsResult(int requestCode,
      @NonNull String permissions[],
      @NonNull int[] grantResults) {
    // Make sure it's our original READ_CONTACTS request
    if (requestCode == LOCATION_PERMISSIONS_REQUEST) {
      if (grantResults.length == 1 &&
          grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        getUserLocation();
      } else {
        // showRationale = false if user clicks Never Ask Again, otherwise true
        boolean showRationale = shouldShowRequestPermissionRationale(permission.ACCESS_COARSE_LOCATION);

        if (showRationale) {
          // do something here to handle degraded mode
        } else {
          Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
        }
      }
    } else {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
  }
  private void showDialog(String title, String message){
    AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    alertDialog.setTitle(title);
    alertDialog.setMessage(message);
    // Alert dialog button
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            (dialog, which) -> {
              // Alert dialog action goes here
              // onClick button code here
              dialog.dismiss();// use dismiss to cancel alert dialog
            });
    alertDialog.show();
  }

}
