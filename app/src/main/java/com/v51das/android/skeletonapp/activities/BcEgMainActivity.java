package com.v51das.android.skeletonapp.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.utils.ActivityMgrUtil;

public class BcEgMainActivity extends AppCompatActivity {

    private ForceOfflineReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bc4eg2main);
        Button force_offline = findViewById(R.id.force_offline);
        force_offline.setOnClickListener(v -> {
            Intent intent = new Intent("com.v51das.android.skeletonapp.FORCE_OFFLINE");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onResume() {//当activity处理栈顶时注册接收器
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.v51das.android.skeletonapp.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {//当activity不可见注销接收器
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    private class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline,Please try to login again.");
            builder.setCancelable(false);//使警告框不可取消，以达到强下线的效果
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityMgrUtil.finishAll();//销毁所有活动
                    Intent intent = new Intent(context, BcEgActivity.class);
                    context.startActivity(intent);//重新启动BcEgActivity
                }
            });
            builder.show();
        }
    }
}