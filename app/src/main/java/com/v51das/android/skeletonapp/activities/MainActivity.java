package com.v51das.android.skeletonapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.model.Person4Parcelable;
import com.v51das.android.skeletonapp.model.Person4Serializable;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            // 取savedInstanceState中保存的数据
        } else {
            // TODO
        }

        Button serializableActivity4Result = findViewById(R.id.serializableActivity4Result);
        serializableActivity4Result.setOnClickListener(this);

        Button parcelableActivity4Result = findViewById(R.id.parcelableActivity4Result);
        parcelableActivity4Result.setOnClickListener(this);

        Button customControl4Title = findViewById(R.id.customControl4Title);
        customControl4Title.setOnClickListener(this);

        Button listview = findViewById(R.id.list_view);
        listview.setOnClickListener(this);
    }

    //**********************************************start-菜单********************************//
    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * 单击菜单项执行的动作
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    //**********************************************end-菜单********************************//

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.serializableActivity4Result: //以Java原生序列化的方法通过Intent传递对象
                Intent serIntent = new Intent(MainActivity.this, SerializableActivity4Result.class);
                //以序列化的方式传送对象
                Person4Serializable ps = new Person4Serializable();
                ps.setName("Tim");
                ps.setAge(20);
                serIntent.putExtra("ser2person_data", ps);
                startActivityForResult(serIntent, 1);
                break;
            case R.id.parcelableActivity4Result: //以Parcel的方式通过Intent传递对象
                Intent parIntent = new Intent(MainActivity.this, ParcelableActivity4Result.class);
                Person4Parcelable pp = new Person4Parcelable();
                pp.setName("Tom");
                pp.setAge(26);
                parIntent.putExtra("par2person_data", pp);
                startActivityForResult(parIntent, 2);
                break;
            case R.id.customControl4Title:
                Intent cusIntent = new Intent(MainActivity.this, CustomControl4Title.class);
                startActivity(cusIntent);
            case R.id.list_view:
                Intent lvIntent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(lvIntent);
        }
    }

    /**
     * 取得另一个Activity返回的值
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
            case 2:
                if (resultCode == RESULT_OK) {
                    String retData = data.getStringExtra("data_return");
                    LogUtil.d(TAG, retData);
                }
                break;
            default:
        }
    }

    /**
     * 当返回是通过Back键返回时的处理
     */
    @Override
    public void onBackPressed() {
        // TODO
    }

    /**
     * 用于活动由于资源不足被系统回收时临时保存数据，活动恢复时可以继续使用数据
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO
    }
}