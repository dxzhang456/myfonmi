package com.github.tvbox.osc.widget;

import android.view.View;

import com.owen.tvrecyclerview.widget.TvRecyclerView;

// Simplified interface - directly use TvRecyclerView.OnItemListener methods
public interface OnItemSelectedListener {
    void onItemSelected(TvRecyclerView tvRecyclerView, View view, int i);
}
