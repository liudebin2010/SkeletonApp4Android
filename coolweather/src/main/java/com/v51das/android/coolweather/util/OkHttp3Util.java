package com.v51das.android.coolweather.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 网络工具类
 */
public class OkHttp3Util {

    public static final String TAG = "OkHttp3Util";

    public static void sendOkHttpGetRequest(String address, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendOkHttpPostRequest() {

    }
}
