package com.v51das.android.skeletonapp.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.v51das.android.skeletonapp.R;

public class BcLclActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bc_lcl);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button send_lclbc = findViewById(R.id.send_lclbc);
        send_lclbc.setOnClickListener(v -> {
            Intent intent = new Intent("com.v51das.android.skeletonapp.LOCAL_BROADCAST");
            localBroadcastManager.sendBroadcast(intent);
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.v51das.android.skeletonapp.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    private class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "receiver local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}