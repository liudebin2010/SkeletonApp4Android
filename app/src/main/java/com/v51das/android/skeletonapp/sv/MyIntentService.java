package com.v51das.android.skeletonapp.sv;

import android.app.IntentService;
import android.content.Intent;

import com.v51das.android.skeletonapp.utils.LogUtil;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            LogUtil.d("MyIntentService", "Thread id is " + Thread.currentThread().getId());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("MyIntentService", "onDestroy executed");
    }
}