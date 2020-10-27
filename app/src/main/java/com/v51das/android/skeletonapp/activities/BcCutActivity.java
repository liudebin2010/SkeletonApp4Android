package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.v51das.android.skeletonapp.R;

public class BcCutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bc_cut);
        Button send_bc = findViewById(R.id.send_bc);
        send_bc.setOnClickListener(v -> {
            Intent intent = new Intent("com.v51das.android.skeletonapp.MY_BROADCAST");
            sendBroadcast(intent);
        });
    }
}