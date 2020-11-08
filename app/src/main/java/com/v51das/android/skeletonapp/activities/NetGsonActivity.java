package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.model.App;
import com.v51das.android.skeletonapp.utils.LogUtil;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetGsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_gson);
        Button gson = findViewById(R.id.gson);
        gson.setOnClickListener(v -> {
            sendRequestWithOkHttp();
        });
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://localhost:80/get_data.json")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().toString();
                    parseJsonWithGSON(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 解析JSON字符串
     *
     * @param jsonData
     */
    protected void parseJsonWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
        }.getType());
        for (App app : appList) {
            LogUtil.d("NetGsonActivity", "id is " + app.getId());
            LogUtil.d("NetGsonActivity", "name is " + app.getName());
            LogUtil.d("NetGsonActivity", "version is " + app.getVersion());
        }
    }
}