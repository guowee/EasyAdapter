package com.muse.easy.adapter.abslistview;


import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.muse.easy.adapter.helper.BaseViewHelper;

public class BaseListViewHolder implements BaseViewHelper.AbsListView {
    private final SparseArray<View> views;
    private View convertView;
    private int mPosition;

    private BaseListViewAdapter mListViewAdapter;

    public BaseListViewHolder(View itemView, int position) {
        this.views = new SparseArray<>();
        this.convertView = itemView;
        this.mPosition = position;
    }

    @Override
    public BaseListViewHolder setText(int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    @Override
    public BaseListViewHolder setText(int viewId, int strId) {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }

    @Override
    public BaseListViewHolder setImageResource(int viewId, int imageResId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    @Override
    public BaseListViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    @Override
    public BaseListViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    @Override
    public BaseListViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    @Override
    public BaseListViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    @Override
    public BaseListViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    @Override
    public BaseListViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    @Override
    public BaseListViewHolder setGone(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    @Override
    public BaseListViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
        return this;
    }

    @Override
    public BaseListViewHolder linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    @Override
    public BaseListViewHolder setTypeface(int viewId, Typeface typeface) {
        TextView view = getView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    @Override
    public BaseListViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    @Override
    public BaseListViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    @Override
    public BaseListViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    @Override
    public BaseListViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    @Override
    public BaseListViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    @Override
    public BaseListViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    @Override
    public BaseListViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    @Override
    public BaseListViewHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    @Override
    public BaseListViewHolder setChecked(int viewId, boolean checked) {
        View view = getView(viewId);
        // View unable cast to Checkable
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(checked);
        }
        return this;
    }

    @Override
    public BaseListViewHolder setAdapter(BaseListViewAdapter adapter) {
        this.mListViewAdapter = adapter;
        return this;
    }

    @Override
    public BaseListViewHolder addOnClickListener(int viewId) {

        View view = getView(viewId);
        if (view != null) {
            if (!view.isClickable()) {
                view.setClickable(true);
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListViewAdapter.getOnItemClickListener() != null) {
                        mListViewAdapter.getOnItemClickListener().onItemClick(v, mPosition);
                    }
                }
            });
        }
        return this;
    }

    @Override
    public BaseListViewHolder addOnLongClickListener(int viewId) {
        final View view = getView(viewId);
        if (view != null) {
            if (!view.isLongClickable()) {
                view.setLongClickable(true);
            }
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mListViewAdapter.getOnItemLongClickListener() != null &&
                            mListViewAdapter.getOnItemLongClickListener().onItemLongClick(v, mPosition);
                }
            });
        }
        return this;
    }


    private <T extends View> T getView(@IdRes int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
