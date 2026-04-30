package com.owen.tvrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.GridLayoutManager;

/**
 * Compatibility wrapper for V7GridLayoutManager using AndroidX GridLayoutManager
 */
public class V7GridLayoutManager extends GridLayoutManager {

    public V7GridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public V7GridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public V7GridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }
}