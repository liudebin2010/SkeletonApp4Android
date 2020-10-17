package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.model.Person4Parcelable;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class ParcelableActivity4ResultActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "ParcelableActivity4Result";

    private Person4Parcelable person4Parcelable = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parcelable_activity4result);

        //若Activity被系统回收时保存有数据，则直接取保存的数据
        if (savedInstanceState != null) {
            person4Parcelable = savedInstanceState.getParcelable("par2resaved_data");
            LogUtil.d(TAG + "_par2resaved_data", person4Parcelable.toString());
        } else { //若savedInstanceState为空，则取传递来的数据
            Intent intent = getIntent();
            person4Parcelable = intent.getParcelableExtra("par2person_data");
            LogUtil.d(TAG + "_par2person_data", person4Parcelable.toString());
        }

        Button retParVal2Activity = findViewById(R.id.retParVal2Activity);
        retParVal2Activity.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.retParVal2Activity:
                Intent intent = new Intent();
                intent.putExtra("data_return", "data from ParcelableActivity4Result");
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
        intent.putExtra("data_return", "data from ParcelableActivity4Result");
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
        outState.putParcelable("par2resaved_data", person4Parcelable);

    }
}
