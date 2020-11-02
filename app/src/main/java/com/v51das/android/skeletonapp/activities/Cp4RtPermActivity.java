package com.v51das.android.skeletonapp.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.v51das.android.skeletonapp.R;

public class Cp4RtPermActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_rtperm);
        Button make_call = findViewById(R.id.make_call);
        make_call.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(Cp4RtPermActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Cp4RtPermActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                call();
            }
        });
    }

    private void call() {
        try {
            Intent mcIntent = new Intent(Intent.ACTION_CALL);
            mcIntent.setData(Uri.parse("tel:10086"));
            startActivity(mcIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}