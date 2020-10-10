package com.v51das.android.skeletonapp.utils;

import android.app.Application;
import android.content.Context;

/**
 * Android提供的Application类，每当程序啓動時，系統就會自動將這個類進行初始化。
 * 此類爲定制类，故需要在AndroidManifest.xml文件的<application>标签下进行指定，告知系统当程序启动的时候初始化AppCtxUtil类，而不是默认的Application类
 */
public class AppCtxUtil extends Application {

    private static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = getApplicationContext();
        // TODO 此处可以添更多系统启动时需要初始化的类
    }

    public static Context getContext(){
        return ctx;
    }
}
