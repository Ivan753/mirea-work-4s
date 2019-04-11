package com.example.lab2;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.lab2.Adapter.ViewPagerAdapter;
import com.example.cource_project.R;

import org.json.JSONArray;

public class ViewPagerFragment extends FragmentActivity {

    ViewPager pager;
    PagerAdapter pagerAdapter;
    private JSONArray data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_fragment);

        DataHolder dataHolder = DataHolder.getInstance();
        JSONArray data = dataHolder.getData();

        this.data = data;

        pager = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this.data);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem((int) getIntent().getSerializableExtra("position"));
    }



}
