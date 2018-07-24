package com.uowee.easy.demo.adapter;


import android.support.annotation.Nullable;

import com.muse.easy.adapter.abslistview.BaseListViewAdapter;
import com.muse.easy.adapter.abslistview.BaseListViewHolder;
import com.uowee.easy.demo.R;
import com.uowee.easy.demo.entity.HomeItem;

import java.util.List;

public class MyListAdapter extends BaseListViewAdapter<HomeItem> {
    public MyListAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    public void convert(BaseListViewHolder holder, int position, HomeItem homeItem) {
        holder.setText(R.id.content, homeItem.getContent());
        holder.setImageResource(R.id.icon, homeItem.getResId());
        holder.addOnClickListener(R.id.list_item);
    }
}
