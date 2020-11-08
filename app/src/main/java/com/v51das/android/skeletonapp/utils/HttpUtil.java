package com.v51das.android.skeletonapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.v51das.android.skeletonapp.inter.HttpCallbackListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络工具类
 */
public class HttpUtil {

    public static final String TAG = "HttpUtil";

    public static void sendHttpGetRequest(final String address, final HttpCallbackListener listener) {

        Context ctx = AppCtxUtil.getContext();
        if (!isNetworkAvailable(ctx)) {
            Toast.makeText(ctx, "网络不可用", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {
            HttpURLConnection connection = null;
            try {
                URL url=new URL(address);
                connection= (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                InputStream in=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                StringBuffer response=new StringBuffer();
                String line;
                while ((line=reader.readLine())!=null){
                    response.append(line);
                }
                if (listener!=null){
                    // 回调onFinish()方法
                    listener.onFinish(response.toString());
                }
            } catch (Exception e) {
                if (listener!=null){
                    // 回调onError()方法
                    listener.onError(e);
                }
            }finally {
                if (connection!=null){
                    connection.disconnect();
                }
            }
        }).start();
    }

    private static boolean isNetworkAvailable(Context ctx){
        ConnectivityManager cm= (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm==null){
            return false;
        } else {
            NetworkInfo networkInfo=cm.getActiveNetworkInfo();
            if (networkInfo!=null){
                LogUtil.d(TAG,"isNetworkAvailable-是否网络："+networkInfo.isAvailable());
            } else {
                LogUtil.d(TAG,"isNetworkAvailable-完成没有网络！");
                return false;
            }

            if (networkInfo!=null&networkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
                LogUtil.d(TAG,"isNetworkAvailable-有3G网络！");
                return true;
            } else {
                LogUtil.d(TAG,"isNetworkAvailable-没有3G网络！");
            }

            if (networkInfo!=null&networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
                LogUtil.d(TAG,"isNetworkAvailable-有wifi网络！");
                return true;
            } else {
                LogUtil.d(TAG,"isNetworkAvailable-没有wifi网络！");
            }
        }
        return false;
    }

}
