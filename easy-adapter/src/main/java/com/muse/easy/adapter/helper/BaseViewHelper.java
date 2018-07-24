package com.muse.easy.adapter.helper;


import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;

import com.muse.easy.adapter.abslistview.BaseListViewAdapter;
import com.muse.easy.adapter.abslistview.BaseListViewHolder;
import com.muse.easy.adapter.recyclerview.BaseRecyclerViewAdapter;
import com.muse.easy.adapter.recyclerview.BaseRecyclerViewHolder;

public interface BaseViewHelper {

    interface AbsListView<VH extends BaseListViewHolder, P extends BaseListViewAdapter> {
        VH setText(int viewId, CharSequence value);

        VH setText(@IdRes int viewId, @StringRes int strId);

        VH setImageResource(@IdRes int viewId, @DrawableRes int imageResId);

        VH setBackgroundColor(@IdRes int viewId, @ColorInt int color);

        VH setBackgroundRes(@IdRes int viewId, @DrawableRes int backgroundRes);

        VH setTextColor(@IdRes int viewId, @ColorInt int textColor);

        VH setImageDrawable(@IdRes int viewId, Drawable drawable);

        VH setImageBitmap(@IdRes int viewId, Bitmap bitmap);

        VH setAlpha(@IdRes int viewId, float value);

        VH setGone(@IdRes int viewId, boolean visible);

        VH setVisible(@IdRes int viewId, boolean visible);

        VH linkify(@IdRes int viewId);

        VH setTypeface(@IdRes int viewId, Typeface typeface);

        VH setTypeface(Typeface typeface, int... viewIds);

        VH setProgress(@IdRes int viewId, int progress);

        VH setProgress(@IdRes int viewId, int progress, int max);

        VH setMax(@IdRes int viewId, int max);

        VH setRating(@IdRes int viewId, float rating);

        VH setRating(@IdRes int viewId, float rating, int max);

        VH setTag(@IdRes int viewId, Object tag);

        VH setTag(@IdRes int viewId, int key, Object tag);

        VH setChecked(@IdRes int viewId, boolean checked);

        VH setAdapter(P adapter);

        VH addOnClickListener(@IdRes final int viewId);

        VH addOnLongClickListener(@IdRes final int viewId);
    }


    interface RecyclerView<VH extends BaseRecyclerViewHolder, P extends BaseRecyclerViewAdapter> {

        VH setText(int viewId, CharSequence value);

        VH setText(@IdRes int viewId, @StringRes int strId);

        VH setImageResource(@IdRes int viewId, @DrawableRes int imageResId);

        VH setBackgroundColor(@IdRes int viewId, @ColorInt int color);

        VH setBackgroundRes(@IdRes int viewId, @DrawableRes int backgroundRes);

        VH setTextColor(@IdRes int viewId, @ColorInt int textColor);

        VH setImageDrawable(@IdRes int viewId, Drawable drawable);

        VH setImageBitmap(@IdRes int viewId, Bitmap bitmap);

        VH setAlpha(@IdRes int viewId, float value);

        VH setGone(@IdRes int viewId, boolean visible);

        VH setVisible(@IdRes int viewId, boolean visible);

        VH linkify(@IdRes int viewId);

        VH setTypeface(@IdRes int viewId, Typeface typeface);

        VH setTypeface(Typeface typeface, int... viewIds);

        VH setProgress(@IdRes int viewId, int progress);

        VH setProgress(@IdRes int viewId, int progress, int max);

        VH setMax(@IdRes int viewId, int max);

        VH setRating(@IdRes int viewId, float rating);

        VH setRating(@IdRes int viewId, float rating, int max);

        VH setTag(@IdRes int viewId, Object tag);

        VH setTag(@IdRes int viewId, int key, Object tag);

        VH setChecked(@IdRes int viewId, boolean checked);

        VH setAdapter(P adapter);

        VH addOnClickListener(@IdRes final int viewId);

        VH addOnLongClickListener(@IdRes final int viewId);

    }

}
