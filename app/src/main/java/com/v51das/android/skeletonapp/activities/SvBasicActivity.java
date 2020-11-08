package com.v51das.android.skeletonapp.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.sv.MyIntentService;
import com.v51das.android.skeletonapp.sv.MyService;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class SvBasicActivity extends BaseActivity implements View.OnClickListener {

    private MyService.MyDownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.MyDownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_basic);

        Button startService = findViewById(R.id.start_service);
        startService.setOnClickListener(this);

        Button stopService = findViewById(R.id.stop_service);
        stopService.setOnClickListener(this);

        Button bind_service = findViewById(R.id.bind_service);
        bind_service.setOnClickListener(this);

        Button unbind_service = findViewById(R.id.unbind_service);
        unbind_service.setOnClickListener(this);

        Button start_intent_service = findViewById(R.id.start_intent_service);
        start_intent_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);//启动服务
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);//停止服务
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            case R.id.start_intent_service:
                LogUtil.d("SvBasicActivity", "Thread id is " + Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}