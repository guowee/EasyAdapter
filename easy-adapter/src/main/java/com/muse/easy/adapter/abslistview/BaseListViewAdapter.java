package com.muse.easy.adapter.abslistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.muse.easy.adapter.listener.OnItemClickListener;
import com.muse.easy.adapter.listener.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseListViewAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected int mLayoutResId;
    protected LayoutInflater mLayoutInflater;

    protected List<T> mData;

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public abstract void convert(BaseListViewHolder holder, int position, T t);

    public BaseListViewAdapter(int layoutResId, List<T> data) {
        this.mData = (data == null ? new ArrayList<T>() : data);
        if (layoutResId != 0) {
            this.mLayoutResId = layoutResId;
        }
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData == null ? null : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseListViewHolder viewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        convertView = getItemView(mLayoutResId, parent);
        viewHolder = createBaseViewHolder(convertView, position);
        viewHolder.setAdapter(this);

        convert(viewHolder, position, mData.get(position));
        return convertView;
    }

    private View getItemView(int layoutResId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutResId, parent, false);
    }

    private BaseListViewHolder createBaseViewHolder(View convertView, int position) {
        return new BaseListViewHolder(convertView, position);
    }


    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return mOnItemLongClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }


}
