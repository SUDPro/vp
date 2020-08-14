package com.example.viewpagertest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpagertest.models.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void onDataReceived(List<Item> items) {
        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(items);
        mViewPager.setAdapter(pagerAdapter);
    }

    private void setupViews() {
        mViewPager = findViewById(R.id.viewPager);
        getDataEmulation();
    }

    private void getDataEmulation() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            items.add(new Item("Item" + i, "Description" + i));
        }
        onDataReceived(items);
    }
}
