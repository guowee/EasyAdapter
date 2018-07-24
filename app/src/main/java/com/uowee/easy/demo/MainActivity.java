package com.uowee.easy.demo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    private String[] mTitles = new String[]{
            ListTestActivity.class.getSimpleName(),
            RecyclerViewTestActivity.class.getSimpleName()

    };
    private Class[] mActivities = new Class[]{
            ListTestActivity.class,
            RecyclerViewTestActivity.class,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTitles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, mActivities[position]));
    }
}
