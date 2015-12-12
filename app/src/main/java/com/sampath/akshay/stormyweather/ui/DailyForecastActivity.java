package com.sampath.akshay.stormyweather.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sampath.akshay.stormyweather.R;
import com.sampath.akshay.stormyweather.adapters.DayAdapter;
import com.sampath.akshay.stormyweather.weather.DailyWeather;

import java.util.Arrays;

public class DailyForecastActivity extends ListActivity {

     private DailyWeather[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, DailyWeather[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String summary = mDays[position].getSummary();
        String maxTemp = mDays[position].getTemperatureMax() + "";
        String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek, maxTemp, summary);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
