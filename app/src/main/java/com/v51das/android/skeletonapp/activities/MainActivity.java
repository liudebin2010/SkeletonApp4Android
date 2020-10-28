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

        Button recycleview = findViewById(R.id.recycler_view);
        recycleview.setOnClickListener(this);

        Button rvVertview = findViewById(R.id.rv_vertview);
        rvVertview.setOnClickListener(this);

        Button rvWaterfallview = findViewById(R.id.rv_waterfallview);
        rvWaterfallview.setOnClickListener(this);

        Button uipractice = findViewById(R.id.ui_practice);
        uipractice.setOnClickListener(this);

        Button fragBtn = findViewById(R.id.frag_btn);
        fragBtn.setOnClickListener(this);

        Button bc_std = findViewById(R.id.bc_std);
        bc_std.setOnClickListener(this);

        Button bc_ord = findViewById(R.id.bc_ord);
        bc_ord.setOnClickListener(this);

        Button bc_cut = findViewById(R.id.bc_cut);
        bc_cut.setOnClickListener(this);

        Button bc_lcl = findViewById(R.id.bc_lcl);
        bc_lcl.setOnClickListener(this);

        Button bc_eg = findViewById(R.id.bc_eg);
        bc_eg.setOnClickListener(this);

        Button dp_file = findViewById(R.id.dp_file);
        dp_file.setOnClickListener(this);

        Button dp_sp = findViewById(R.id.dp_sp);
        dp_sp.setOnClickListener(this);

        Button dp_sp_rmb = findViewById(R.id.dp_sp_rmb);
        dp_sp_rmb.setOnClickListener(this);
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
                Intent serIntent = new Intent(MainActivity.this, SerializableActivity4ResultActivity.class);
                //以序列化的方式传送对象
                Person4Serializable ps = new Person4Serializable();
                ps.setName("Tim");
                ps.setAge(20);
                serIntent.putExtra("ser2person_data", ps);
                startActivityForResult(serIntent, 1);
                break;
            case R.id.parcelableActivity4Result: //以Parcel的方式通过Intent传递对象
                Intent parIntent = new Intent(MainActivity.this, ParcelableActivity4ResultActivity.class);
                Person4Parcelable pp = new Person4Parcelable();
                pp.setName("Tom");
                pp.setAge(26);
                parIntent.putExtra("par2person_data", pp);
                startActivityForResult(parIntent, 2);
                break;
            case R.id.customControl4Title:
                Intent cusIntent = new Intent(MainActivity.this, CustomControl4TitleAcivity.class);
                startActivity(cusIntent);
                break;
            case R.id.list_view:
                Intent lvIntent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(lvIntent);
                break;
            case R.id.recycler_view:
                Intent rvIntent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(rvIntent);
                break;
            case R.id.rv_vertview:
                Intent rvvIntent = new Intent(MainActivity.this, RvVerticalActivity.class);
                startActivity(rvvIntent);
                break;
            case R.id.rv_waterfallview:
                Intent wvIntent = new Intent(MainActivity.this, RvWaterfallActivity.class);
                startActivity(wvIntent);
                break;
            case R.id.ui_practice:
                Intent uiIntent = new Intent(MainActivity.this, UIBestPracticeActivity.class);
                startActivity(uiIntent);
                break;
            case R.id.frag_btn:
                Intent fragIntent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(fragIntent);
                break;
            case R.id.bc_std:
                Intent bcStdIntent = new Intent(MainActivity.this, BcStdActivity.class);
                startActivity(bcStdIntent);
                break;
            case R.id.bc_ord:
                Intent bcordIntent = new Intent(MainActivity.this, BcOrdActivity.class);
                startActivity(bcordIntent);
                break;
            case R.id.bc_cut:
                Intent bccutIntent = new Intent(MainActivity.this, BcCutActivity.class);
                startActivity(bccutIntent);
                break;
            case R.id.bc_lcl:
                Intent bclclIntent = new Intent(MainActivity.this, BcLclActivity.class);
                startActivity(bclclIntent);
                break;
            case R.id.bc_eg:
                Intent bcegIntent = new Intent(MainActivity.this, BcEgActivity.class);
                startActivity(bcegIntent);
                break;
            case R.id.dp_file:
                Intent dpfIntent = new Intent(MainActivity.this, DpFileActivity.class);
                startActivity(dpfIntent);
                break;
            case R.id.dp_sp:
                Intent dpSpfIntent = new Intent(MainActivity.this, DpSpFileActivity.class);
                startActivity(dpSpfIntent);
                break;
            case R.id.dp_sp_rmb:
                Intent dpSpRmbfIntent = new Intent(MainActivity.this, BcEgActivity.class);
                startActivity(dpSpRmbfIntent);
                break;
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