package com.v51das.android.skeletonapp.bc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*ConnectivityManager connectionManager=getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectionManager.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isAvailable()){
            Toast.makeText(context,"network is available",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"network is unavailable",Toast.LENGTH_SHORT).show();
        }*/
    }
}
