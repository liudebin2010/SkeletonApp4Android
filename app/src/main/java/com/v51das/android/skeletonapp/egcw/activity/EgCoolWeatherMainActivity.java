package com.v51das.android.skeletonapp.egcw.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.activities.BaseActivity;

public class EgCoolWeatherMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egcw_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, EgCoolWeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
}