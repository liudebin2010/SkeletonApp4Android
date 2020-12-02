package com.v51das.android.skeletonapp.layout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.v51das.android.skeletonapp.R;

public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.control4title, this);

        Button titleBack = findViewById(R.id.title_back);
        Button titleEdit = findViewById(R.id.title_edit);

        titleBack.setOnClickListener(v -> {
            ((Activity) getContext()).finish();
        });

        titleEdit.setOnClickListener(v -> {
            Toast.makeText(getContext(), "You clicked Edit button", Toast.LENGTH_SHORT).show();
        });
    }

}
