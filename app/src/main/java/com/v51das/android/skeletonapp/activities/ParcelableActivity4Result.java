package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.model.Person4Serializable;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class SerializableActivity4Result extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG="OtherActivity4Result";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serialiable_activity4result);
        Button retVal2Activity=findViewById(R.id.retSerVal2Activity);
        retVal2Activity.setOnClickListener(this);

        Intent intent=getIntent();
        Person4Serializable person4Serializable= (Person4Serializable) intent.getSerializableExtra("person_data");
        LogUtil.d("TAG",person4Serializable.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.retSerVal2Activity:
                Intent intent=new Intent();
                intent.putExtra("data_return","hello mainactivity");
                setResult(RESULT_OK,intent);
                finish();
        }
    }

    /**
     * 当返回是通过Back键返回时的处理
     */
    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","hello mainactivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
