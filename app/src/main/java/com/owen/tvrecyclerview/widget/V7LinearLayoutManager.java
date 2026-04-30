package com.owen.tvrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * Compatibility wrapper for V7LinearLayoutManager using AndroidX LinearLayoutManager
 */
public class V7LinearLayoutManager extends LinearLayoutManager {

    public V7LinearLayoutManager(Context context) {
        super(context);
    }

    public V7LinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public V7LinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}