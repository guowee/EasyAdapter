package com.muse.easy.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muse.easy.adapter.listener.OnItemClickListener;
import com.muse.easy.adapter.listener.OnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    protected List<T> mData;
    protected int mLayoutResId;

    protected abstract void convert(BaseRecyclerViewHolder holder, T t);


    public BaseRecyclerViewAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        this.mData = (data == null ? new ArrayList<T>() : data);
        if (layoutResId != 0) {
            this.mLayoutResId = layoutResId;
        }
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder baseViewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);

        baseViewHolder = createBaseViewHolder(parent, mLayoutResId);
        baseViewHolder.setAdapter(this);
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        convert(holder, getItem(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private BaseRecyclerViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return createBaseViewHolder(getItemView(layoutResId, parent));
    }

    private View getItemView(@LayoutRes int layoutResId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutResId, parent, false);
    }

    private BaseRecyclerViewHolder createBaseViewHolder(View view) {
        return new BaseRecyclerViewHolder(view);
    }


    public T getItem(@IntRange(from = 0) int position) {
        if (position >= 0 && position < mData.size())
            return mData.get(position);
        else
            return null;
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
