package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.v51das.android.skeletonapp.R;

public class BcEgActivity extends BaseActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private EditText usernameEdt;
    private EditText passwordEdt;
    private Button login;

    private CheckBox rmbPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bc_eg);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);
        rmbPass = findViewById(R.id.rmb_pass);
        login = findViewById(R.id.bc_login);
        boolean isRmb = pref.getBoolean("rmb_pass", false);
        if (isRmb) {
            String username = pref.getString("username", "");
            String password = pref.getString("password", "");
            usernameEdt.setText(username);
            passwordEdt.setText(password);
            rmbPass.setChecked(true);
        }
        login.setOnClickListener(v -> {
            String username = usernameEdt.getText().toString();
            String password = passwordEdt.getText().toString();
            if (username.equals("admin") && password.equals("123456")) {
                editor = pref.edit();
                if (rmbPass.isChecked()) {// 检查复选框是否选中
                    editor.putBoolean("rmb_pass", true);
                    editor.putString("password", password);
                    editor.putString("username", username);
                } else {
                    editor.clear();
                }
                editor.apply();
                Intent intent = new Intent(BcEgActivity.this, BcEgMainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(BcEgActivity.this, "username or password is invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}