package com.v51das.android.coolweather.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.coolweather.util.ActivityMgrUtil;
import com.v51das.android.coolweather.util.LogUtil;

import java.util.Map;

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, getClass().getSimpleName());
        // 将Activity添加到列表中
        ActivityMgrUtil.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 将Activity从列表中移除
        ActivityMgrUtil.removeActivity(this);
    }

    /**
     * 封闭启动Activity的时传递Java原生类型数据的操作
     *
     * @param ctx
     * @param clazz
     * @param dataMap
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void startActivityWithData(Context ctx, Class clazz, Map<String, Object> dataMap) {
        Intent intent = new Intent(ctx, clazz);
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            } else if (value instanceof Byte) {
                intent.putExtra(key, (byte) value);
            } else if (value instanceof Character) {
                intent.putExtra(key, (char) value);
            } else if (value instanceof Short) {
                intent.putExtra(key, (short) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (long) value);
            } else if (value instanceof Float) {
                intent.putExtra(key, (float) value);
            } else if (value instanceof Double) {
                intent.putExtra(key, (double) value);
            }
        }
        ctx.startActivity(intent);
    }

}
