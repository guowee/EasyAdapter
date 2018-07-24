package com.uowee.easy.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.muse.easy.adapter.listener.OnItemClickListener;
import com.uowee.easy.demo.adapter.MyRecyclerViewAdapter;
import com.uowee.easy.demo.entity.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewTestActivity extends AppCompatActivity {

    private List<HomeItem> homeItems;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);
        mRecyclerView = findViewById(R.id.recycler_view);
        getHomeItems();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(R.layout.item_home, homeItems);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewTestActivity.this, "Click " + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    private void getHomeItems() {
        homeItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            homeItems.add(new HomeItem(R.mipmap.ic_launcher, "RecyclerView Item-----" + i));
        }
    }

}
