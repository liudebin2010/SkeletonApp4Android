package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.adapter.Fruit4RvWaterfallAdapter;
import com.v51das.android.skeletonapp.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RvWaterfallActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_waterfall);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.rv_waterfall);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);
        Fruit4RvWaterfallAdapter adapter = new Fruit4RvWaterfallAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orangle = new Fruit(getRandomLengthName("Orangle"), R.drawable.orange_pic);
            fruitList.add(orangle);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.apple_pic);
            fruitList.add(pear);
            Fruit watemelon = new Fruit(getRandomLengthName("Watemelon"), R.drawable.watermelon_pic);
            fruitList.add(watemelon);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}