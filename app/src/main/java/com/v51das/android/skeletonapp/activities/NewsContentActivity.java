package com.v51das.android.skeletonapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.v51das.android.skeletonapp.R;

public class NewsContentActivity extends BaseActivity {

    public static void actionStart(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        FragNewsContent fragNewsContent = (FragNewsContent) getSupportFragmentManager().findFragmentById(R.id.frag_news_content);
        fragNewsContent.refresh(newsTitle, newsContent);
    }
}
