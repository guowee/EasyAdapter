package com.muse.easy.adapter.helper;


import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import com.muse.easy.adapter.abslistview.BaseListViewAdapter;
import com.muse.easy.adapter.abslistview.BaseListViewHolder;
import com.muse.easy.adapter.recyclerview.BaseRecyclerViewAdapter;
import com.muse.easy.adapter.recyclerview.BaseRecyclerViewHolder;

public interface BaseViewHelper {

    interface AbsListView<VH extends BaseListViewHolder, P extends BaseListViewAdapter> {
        VH setText(int viewId, CharSequence value);

        VH setText(int viewId, int strId);

        VH setImageResource(int viewId, int imageResId);

        VH setBackgroundColor(int viewId, int color);

        VH setBackgroundRes(int viewId, int backgroundRes);

        VH setTextColor(int viewId, int textColor);

        VH setImageDrawable(int viewId, Drawable drawable);

        VH setImageBitmap(int viewId, Bitmap bitmap);

        VH setAlpha(int viewId, float value);

        VH setGone(int viewId, boolean visible);

        VH setVisible(int viewId, boolean visible);

        VH linkify(int viewId);

        VH setTypeface(int viewId, Typeface typeface);

        VH setTypeface(Typeface typeface, int... viewIds);

        VH setProgress(int viewId, int progress);

        VH setProgress(int viewId, int progress, int max);

        VH setMax(int viewId, int max);

        VH setRating(int viewId, float rating);

        VH setRating(int viewId, float rating, int max);

        VH setTag(int viewId, Object tag);

        VH setTag(int viewId, int key, Object tag);

        VH setChecked(int viewId, boolean checked);

        VH setAdapter(P adapter);

        VH addOnClickListener(final int viewId);

        VH addOnLongClickListener(final int viewId);
    }


    interface RecyclerView<VH extends BaseRecyclerViewHolder, P extends BaseRecyclerViewAdapter> {

        VH setText(int viewId, CharSequence value);

        VH setText(int viewId, int strId);

        VH setImageResource(int viewId, int imageResId);

        VH setBackgroundColor(int viewId, int color);

        VH setBackgroundRes(int viewId, int backgroundRes);

        VH setTextColor(int viewId, int textColor);

        VH setImageDrawable(int viewId, Drawable drawable);

        VH setImageBitmap(int viewId, Bitmap bitmap);

        VH setAlpha(int viewId, float value);

        VH setGone(int viewId, boolean visible);

        VH setVisible(int viewId, boolean visible);

        VH linkify(int viewId);

        VH setTypeface(int viewId, Typeface typeface);

        VH setTypeface(Typeface typeface, int... viewIds);

        VH setProgress(int viewId, int progress);

        VH setProgress(int viewId, int progress, int max);

        VH setMax(int viewId, int max);

        VH setRating(int viewId, float rating);

        VH setRating(int viewId, float rating, int max);

        VH setTag(int viewId, Object tag);

        VH setTag(int viewId, int key, Object tag);

        VH setChecked(int viewId, boolean checked);

        VH setAdapter(P adapter);

        VH addOnClickListener(final int viewId);

        VH addOnLongClickListener(final int viewId);

    }

}
