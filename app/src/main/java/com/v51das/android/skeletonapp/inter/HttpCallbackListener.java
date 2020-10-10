package com.v51das.android.skeletonapp.inter;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
