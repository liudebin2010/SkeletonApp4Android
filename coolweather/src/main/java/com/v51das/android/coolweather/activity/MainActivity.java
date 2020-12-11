package com.v51das.android.coolweather.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.v51das.android.coolweather.R;
import com.v51das.android.coolweather.util.LogUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // 取savedInstanceState中保存的数据
        } else {
            // TODO
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * 取得另一个Activity返回的值
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
            case 2:
                if (resultCode == RESULT_OK) {
                    String retData = data.getStringExtra("data_return");
                    LogUtil.d(TAG, retData);
                }
                break;
            default:
        }
    }

    /**
     * 当返回是通过Back键返回时的处理
     */
    @Override
    public void onBackPressed() {
        // TODO
    }

    /**
     * 用于活动由于资源不足被系统回收时临时保存数据，活动恢复时可以继续使用数据
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO
    }
}