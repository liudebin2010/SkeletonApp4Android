package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.utils.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetJsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_json);
        Button json = findViewById(R.id.json);
        json.setOnClickListener(v -> {
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
                    parseJsonWithJSONObject(responseData);
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
    protected void parseJsonWithJSONObject(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                LogUtil.d("NetJsonActivity", "id is " + id);
                LogUtil.d("NetJsonActivity", "name is " + name);
                LogUtil.d("NetJsonActivity", "version is " + version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}