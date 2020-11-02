package com.v51das.android.skeletonapp.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.utils.LogUtil;

public class Cp4CustActivity extends AppCompatActivity {

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp4cust);

        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(v -> {
            //添加数据
            Uri uri = Uri.parse("content://com.example.db.provider/book");
            ContentValues values = new ContentValues();
            values.put("name", "A Clash of Kings");
            values.put("author", "George Martin");
            values.put("pages", 1040);
            values.put("price", 22.85);
            Uri newUri = getContentResolver().insert(uri, values);
            newId = newUri.getPathSegments().get(1);
        });

        Button queryData = findViewById(R.id.add_data);
        queryData.setOnClickListener(v -> {
            //查询数据
            Uri uri = Uri.parse("content://com.example.db.provider/book");
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    LogUtil.d(this.getClass().getName(), "book name is " + name);
                    LogUtil.d(this.getClass().getName(), "book author is " + author);
                    LogUtil.d(this.getClass().getName(), "book pages is " + pages);
                    LogUtil.d(this.getClass().getName(), "book price is " + price);
                }
            }
        });

        Button updateData = findViewById(R.id.add_data);
        updateData.setOnClickListener(v -> {
            //更新数据
            Uri uri = Uri.parse("content://com.example.db.provider/book/" + newId);
            ContentValues values = new ContentValues();
            values.put("name", "A Storm of Swords");
            values.put("pages", 1241);
            values.put("price", 24.6);
            getContentResolver().update(uri, values, null, null);
        });

        Button deleteData = findViewById(R.id.add_data);
        deleteData.setOnClickListener(v -> {
            //删除数据
            Uri uri = Uri.parse("content://com.example.db.provider/book/" + newId);
            getContentResolver().delete(uri, null, null);
        });
    }
}