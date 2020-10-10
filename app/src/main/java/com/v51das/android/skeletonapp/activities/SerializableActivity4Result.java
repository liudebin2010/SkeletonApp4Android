package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.model.Person4Serializable;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class SerializableActivity4Result extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "SerializableActivity4Result";

    private Person4Serializable person4Serializable = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serialiable_activity4result);

        //若Activity被系统回收时保存有数据，则直接取保存的数据
        if (savedInstanceState != null) {
            person4Serializable = savedInstanceState.getParcelable("ser2resaved_data");
            LogUtil.d(TAG + "_ser2resaved_data", person4Serializable.toString());
        } else { //若savedInstanceState为空，则取传递来的数据
            Intent intent = getIntent();
            person4Serializable = (Person4Serializable) intent.getSerializableExtra("ser2person_data");
            LogUtil.d(TAG + "_ser2person_data", person4Serializable.toString());
        }

        Button retVal2Activity = findViewById(R.id.retSerVal2Activity);
        retVal2Activity.setOnClickListener(this);

        Intent intent = getIntent();
        person4Serializable = (Person4Serializable) intent.getSerializableExtra("ser2person_data");
        LogUtil.d(TAG, person4Serializable.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.retSerVal2Activity:
                Intent intent = new Intent();
                intent.putExtra("data_return", "data from SerializableActivity4Result");
                setResult(RESULT_OK, intent);
                finish();
        }
    }

    /**
     * 当返回是通过Back键返回时的处理
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "data from SerializableActivity4Result");
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * 用于活动由于资源不足被系统回收时临时保存数据，活动恢复时可以继续使用数据
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("ser2resaved_data", person4Serializable);

    }
}
