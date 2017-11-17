package com.danirg10000gmail.weatherapp.weather;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.danirg10000gmail.weatherapp.R;
import com.danirg10000gmail.weatherapp.common.base.BaseActivity;
import com.danirg10000gmail.weatherapp.weather.WeatherContract.Presenter;

public class WeatherActivity extends BaseActivity implements WeatherContract.View {

  WeatherContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather);
    Toolbar toolbar =  findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab =  findViewById(R.id.fab);
    fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show());
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
  public void showCity() {

  }

  @Override
  public void showError() {

  }
}