package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.adapter.Fruit4RvVerticalAdapter;
import com.v51das.android.skeletonapp.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RvVerticalActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_vertical);
        initFruits();

        RecyclerView recyclerView = findViewById(R.id.rv_vert);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        Fruit4RvVerticalAdapter adapter = new Fruit4RvVerticalAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orangle = new Fruit("Orangle", R.drawable.orange_pic);
            fruitList.add(orangle);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pear = new Fruit("Pear", R.drawable.apple_pic);
            fruitList.add(pear);
            Fruit watemelon = new Fruit("Watemelon", R.drawable.watermelon_pic);
            fruitList.add(watemelon);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}