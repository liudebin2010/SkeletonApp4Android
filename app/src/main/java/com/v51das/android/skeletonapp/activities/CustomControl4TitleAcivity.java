package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;

import com.v51das.android.skeletonapp.R;

public class CustomControl4TitleAcivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_control4title);

        //将系统自带的标题栏隐藏掉
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

}