package com.uowee.easy.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.muse.easy.adapter.listener.OnItemClickListener;
import com.uowee.easy.demo.adapter.MyListAdapter;
import com.uowee.easy.demo.entity.HomeItem;

import java.util.ArrayList;
import java.util.List;


public class ListTestActivity extends AppCompatActivity {

    private List<HomeItem> homeItems;
    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        mListView = findViewById(R.id.list_view);
        getHomeItems();
        MyListAdapter adapter = new MyListAdapter(R.layout.item_home, homeItems);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ListTestActivity.this, "Click " + position, Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setAdapter(adapter);
    }

    private void getHomeItems() {
        homeItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            homeItems.add(new HomeItem(R.mipmap.ic_launcher, "ListView Item-----" + i));
        }
    }
}
