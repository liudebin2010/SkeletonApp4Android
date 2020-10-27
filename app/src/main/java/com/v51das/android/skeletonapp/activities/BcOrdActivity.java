package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.v51das.android.skeletonapp.R;

public class BcOrdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bc_ord);
        Button send_abc = findViewById(R.id.send_abc);
        send_abc.setOnClickListener(v -> {
            Intent intent = new Intent("com.v51das.android.skeletonapp.MY_BROADCAST");
            sendOrderedBroadcast(intent, null);
        });
    }
}