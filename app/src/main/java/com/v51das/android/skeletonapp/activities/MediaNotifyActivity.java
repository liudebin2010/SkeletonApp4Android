package com.v51das.android.skeletonapp.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.NotificationCompat;

import com.v51das.android.skeletonapp.R;

import java.io.File;

public class MediaNotifyActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_notify);
        Button basic_use = findViewById(R.id.basic_use);
        basic_use.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic_use:
                //通知点击事件
                Intent intent = new Intent(this, BasicNotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                // 通知
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is content title")
                        .setContentText("ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Cairo.ogg")))//接收到通知时播放声音
                        .setVibrate(new long[]{0, 1000, 1000, 1000})//接收到通知时振动
                        .setLights(Color.GREEN, 1000, 1000)//接收到通知时LED灯闪烁
                        .setContentIntent(pendingIntent)//关联点击事件
                        //.setDefaults(NotificationCompat.DEFAULT_ALL)//接收到通知时默认效果
                        .setAutoCancel(true)//被点击后关闭通知，也可执行manager.cancel(1)达到同样的效果;
                        .setPriority(NotificationCompat.PRIORITY_MAX)//设置通知的重要程度
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj ghfghdfghf fghfhj jghjfghj "))//设置显示长文本
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))//设置通知图片
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}