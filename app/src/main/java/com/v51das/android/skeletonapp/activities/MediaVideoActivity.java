package com.v51das.android.skeletonapp.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.v51das.android.skeletonapp.R;

import java.io.File;

public class MediaVideoActivity extends BaseActivity implements View.OnClickListener {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_video);

        Button video_play = findViewById(R.id.video_play);
        video_play.setOnClickListener(this);
        Button video_pause = findViewById(R.id.video_pause);
        video_pause.setOnClickListener(this);
        Button video_replay = findViewById(R.id.video_replay);
        video_replay.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(MediaVideoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MediaVideoActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            InitMedioVideoPlayer();//初始化VideoView
        }
    }

    private void InitMedioVideoPlayer() {
        File file = new File(Environment.getExternalStorageDirectory(), "movie.mp4");
        videoView.setVideoPath(file.getPath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    InitMedioVideoPlayer();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_play:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.video_pause:
                if (!videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.video_replay:
                if (!videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }
}