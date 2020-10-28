package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.utils.FileOperUtil;

public class DpFileActivity extends AppCompatActivity {

    private EditText dp_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp_file);
        dp_edit = findViewById(R.id.dp_edit);
        String dp_text = FileOperUtil.load(this, "file_oper_test");
        if (!TextUtils.isEmpty(dp_text)) {
            dp_edit.setText(dp_text);
            dp_edit.setSelection(dp_text.length());
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String dp_text = dp_edit.getText().toString();
        FileOperUtil.save(this, dp_text, "file_oper_test");
    }


}