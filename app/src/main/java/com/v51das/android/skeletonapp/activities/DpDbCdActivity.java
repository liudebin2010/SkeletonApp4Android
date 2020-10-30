package com.v51das.android.skeletonapp.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.db.MyDbHelper;
import com.v51das.android.skeletonapp.model.Book;
import com.v51das.android.skeletonapp.utils.LogUtil;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class DpDbCdActivity extends AppCompatActivity {

    private MyDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp4db2cd);
        //若要使用dbHelper中onUpgrate起作用，版本须比当前版本大
        dbHelper = new MyDbHelper(this, "BookStore.db", null, 1);
        Button sqlite_cd = findViewById(R.id.sqlite_cd);
        sqlite_cd.setOnClickListener(v -> {
            dbHelper.getWritableDatabase();
        });

        Button sqlite_ad = findViewById(R.id.sqlite_ad);
        sqlite_ad.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", "The Da Vinci Code");
            values.put("author", "Dan Brown");
            values.put("pages", "345");
            values.put("price", "16.98");
            db.insert("book", null, values);
            values.clear();
            values.put("name", "The Lost Symbol");
            values.put("author", "Dan Brown");
            values.put("pages", "651");
            values.put("price", "26.98");
            db.insert("book", null, values);
        });
        Button sqlite_ud = findViewById(R.id.sqlite_ud);
        sqlite_ud.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("price", "19.98");
            db.update("book", values, "name=?", new String[]{"The Da Vinci Code"});
        });

        Button sqlite_dd = findViewById(R.id.sqlite_dd);
        sqlite_dd.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.delete("book", "pages>?", new String[]{"500"});
        });

        Button sqlite_sd = findViewById(R.id.sqlite_sd);
        sqlite_sd.setOnClickListener(v -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = db.query("book", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String author = cursor.getString(cursor.getColumnIndex("author"));
                    int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                    double price = cursor.getDouble(cursor.getColumnIndex("price"));
                    LogUtil.d(this.getClass().getName(), "book name is " + name);
                    LogUtil.d(this.getClass().getName(), "book author is " + author);
                    LogUtil.d(this.getClass().getName(), "book pages is " + pages);
                    LogUtil.d(this.getClass().getName(), "book price is " + price);
                } while (cursor.moveToNext());
            }
            cursor.close();
        });

        Button lp_cd = findViewById(R.id.lp_cd);
        lp_cd.setOnClickListener(v -> {
            Connector.getDatabase();
        });

        Button lp_sd = findViewById(R.id.lp_sd);
        lp_sd.setOnClickListener(v -> {
            Book book = new Book();
            book.setName("The Da Vinci Code");
            book.setAuthor("Dan Brown");
            book.setPages(456);
            book.setPrice(145);
            book.setPress("Unknow");
            book.save();
        });

        Button lp_ud = findViewById(R.id.lp_ud);
        lp_ud.setOnClickListener(v -> {
            Book book = new Book();
            book.setPrice(14.5);
            book.setPress("Anchor");
            book.updateAll("name = ? and author = ?", "The Da Vinci Code", "Dan Brown");
        });
        Button lp_qd = findViewById(R.id.lp_qd);
        lp_qd.setOnClickListener(v -> {
            List<Book> books = LitePal.findAll(Book.class);
            for (Book book : books) {
                LogUtil.d(this.getClass().getName(), "book name is " + book.getName());
                LogUtil.d(this.getClass().getName(), "book author is " + book.getAuthor());
                LogUtil.d(this.getClass().getName(), "book pages is " + book.getPages());
                LogUtil.d(this.getClass().getName(), "book price is " + book.getPrice());
                LogUtil.d(this.getClass().getName(), "book press is " + book.getPress());
            }
        });
        Button lp_dd = findViewById(R.id.lp_dd);
        lp_dd.setOnClickListener(v -> {
            LitePal.deleteAll(Book.class, "price<?", "15");
        });
    }
}