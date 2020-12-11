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

        Button dp_db_cd = findViewById(R.id.dp_db_cd);
        dp_db_cd.setOnClickListener(this);

        Button rt_perm = findViewById(R.id.rt_perm);
        rt_perm.setOnClickListener(this);

        Button read_contect = findViewById(R.id.read_contect);
        read_contect.setOnClickListener(this);

        Button cust_cp = findViewById(R.id.cust_cp);
        cust_cp.setOnClickListener(this);

        Button media_notify = findViewById(R.id.media_notify);
        media_notify.setOnClickListener(this);

        Button media_camera = findViewById(R.id.media_camera);
        media_camera.setOnClickListener(this);

        Button media_audio = findViewById(R.id.media_audio);
        media_audio.setOnClickListener(this);

        Button media_video = findViewById(R.id.media_video);
        media_video.setOnClickListener(this);

        Button net_webview = findViewById(R.id.net_webview);
        net_webview.setOnClickListener(this);

        Button net_httpg = findViewById(R.id.net_httpg);
        net_httpg.setOnClickListener(this);

        Button net_httpp = findViewById(R.id.net_httpp);
        net_httpp.setOnClickListener(this);

        Button net_xmlp = findViewById(R.id.net_xmlp);
        net_xmlp.setOnClickListener(this);

        Button net_xmls = findViewById(R.id.net_xmls);
        net_xmls.setOnClickListener(this);

        Button net_json = findViewById(R.id.net_json);
        net_json.setOnClickListener(this);

        Button net_gson = findViewById(R.id.net_gson);
        net_gson.setOnClickListener(this);

        Button sv_basic = findViewById(R.id.sv_basic);
        sv_basic.setOnClickListener(this);

        Button lbs_basic = findViewById(R.id.lbs_basic);
        lbs_basic.setOnClickListener(this);
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
            case R.id.dp_db_cd:
                Intent dpDbCdIntent = new Intent(MainActivity.this, DpDbCdActivity.class);
                startActivity(dpDbCdIntent);
                break;
            case R.id.rt_perm:
                Intent rtPermIntent = new Intent(MainActivity.this, Cp4RtPermActivity.class);
                startActivity(rtPermIntent);
                break;
            case R.id.read_contect:
                Intent rcPermIntent = new Intent(MainActivity.this, Cp4ReadContentActivity.class);
                startActivity(rcPermIntent);
                break;
            case R.id.cust_cp:
                Intent ccpPermIntent = new Intent(MainActivity.this, Cp4CustActivity.class);
                startActivity(ccpPermIntent);
                break;
            case R.id.media_notify:
                Intent mnIntent = new Intent(MainActivity.this, MediaNotifyActivity.class);
                startActivity(mnIntent);
                break;
            case R.id.media_camera:
                Intent mcIntent = new Intent(MainActivity.this, MediaCameraActivity.class);
                startActivity(mcIntent);
                break;
            case R.id.media_audio:
                Intent maIntent = new Intent(MainActivity.this, MediaAudioActivity.class);
                startActivity(maIntent);
                break;
            case R.id.media_video:
                Intent mvIntent = new Intent(MainActivity.this, MediaVideoActivity.class);
                startActivity(mvIntent);
                break;
            case R.id.net_webview:
                Intent nwvIntent = new Intent(MainActivity.this, NetWebviewActivity.class);
                startActivity(nwvIntent);
                break;
            case R.id.net_httpg:
                Intent nhttpgIntent = new Intent(MainActivity.this, NetHttpGetActivity.class);
                startActivity(nhttpgIntent);
                break;
            case R.id.net_httpp:
                Intent nhttppIntent = new Intent(MainActivity.this, NetHttpPostActivity.class);
                startActivity(nhttppIntent);
                break;
            case R.id.net_xmlp:
                Intent nxmlpIntent = new Intent(MainActivity.this, NetXmlPullActivity.class);
                startActivity(nxmlpIntent);
                break;
            case R.id.net_xmls:
                Intent nxmlsIntent = new Intent(MainActivity.this, NetXmlSaxActivity.class);
                startActivity(nxmlsIntent);
                break;
            case R.id.net_json:
                Intent njsonIntent = new Intent(MainActivity.this, NetJsonActivity.class);
                startActivity(njsonIntent);
                break;
            case R.id.net_gson:
                Intent ngsonIntent = new Intent(MainActivity.this, NetGsonActivity.class);
                startActivity(ngsonIntent);
                break;
            case R.id.sv_basic:
                Intent svbIntent = new Intent(MainActivity.this, SvBasicActivity.class);
                startActivity(svbIntent);
                break;
            case R.id.lbs_basic:
                Intent lbsbIntent = new Intent(MainActivity.this, LbsBasicActivity.class);
                startActivity(lbsbIntent);
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