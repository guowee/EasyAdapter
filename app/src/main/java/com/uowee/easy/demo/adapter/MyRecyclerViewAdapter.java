package com.uowee.easy.demo.adapter;

import android.support.annotation.Nullable;

import com.muse.easy.adapter.recyclerview.BaseRecyclerViewAdapter;
import com.muse.easy.adapter.recyclerview.BaseRecyclerViewHolder;
import com.uowee.easy.demo.R;
import com.uowee.easy.demo.entity.HomeItem;

import java.util.List;


public class MyRecyclerViewAdapter extends BaseRecyclerViewAdapter<HomeItem> {


    public MyRecyclerViewAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseRecyclerViewHolder holder, HomeItem homeItem) {
        holder.setText(R.id.content, homeItem.getContent());
        holder.setImageResource(R.id.icon, homeItem.getResId());
        holder.addOnClickListener(R.id.list_item);
    }
}
