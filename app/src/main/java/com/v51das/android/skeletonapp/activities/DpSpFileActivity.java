package com.v51das.android.skeletonapp.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class DpSpFileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp_sp_file);

        Button sp_save = findViewById(R.id.sp_save);
        sp_save.setOnClickListener(v -> {
            SharedPreferences.Editor editor = getSharedPreferences("sp_test", MODE_PRIVATE).edit();
            editor.putString("name", "dobin");
            editor.putInt("age", 28);
            editor.putBoolean("married", false);
            editor.apply();
        });
        Button sp_restore = findViewById(R.id.sp_restore);
        sp_restore.setOnClickListener(v -> {
            SharedPreferences pref = getSharedPreferences("sp_test", MODE_PRIVATE);
            String name = pref.getString("name", "");
            int age = pref.getInt("age", 0);
            boolean married = pref.getBoolean("married", false);
            LogUtil.d("DpSpFileActivity", "name is " + name);
            LogUtil.d("DpSpFileActivity", "age is " + age);
            LogUtil.d("DpSpFileActivity", "married is " + married);
        });
    }
}