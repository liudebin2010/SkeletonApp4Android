package com.v51das.android.skeletonapp.sv;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.activities.SvBasicActivity;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class MyService extends Service {
    public static final String TAG = MyService.class.getSimpleName();

    private MyDownloadBinder mBinder = new MyDownloadBinder();

    public class MyDownloadBinder extends Binder {
        public void startDownload() {
            LogUtil.d(TAG, "startDownload");
        }

        public int getProgress() {
            LogUtil.d(TAG, "getProgress");
            return 0;
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "onCreate executed");
        //使用前台服务
        Intent intent = new Intent(this, SvBasicActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is Content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.d(TAG, "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "onDestroy executed");
    }
}