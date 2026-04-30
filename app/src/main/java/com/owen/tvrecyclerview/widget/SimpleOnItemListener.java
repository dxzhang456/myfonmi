package com.owen.tvrecyclerview.widget;

import android.view.View;

/**
 * Compatibility class for SimpleOnItemListener
 * Empty implementation for compatibility with original tv-recyclerview
 */
public class SimpleOnItemListener implements TvRecyclerView.OnItemListener {
    
    @Override
    public void onItemPreSelected(TvRecyclerView parent, View itemView, int position) {
        // Empty implementation
    }

    @Override
    public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
        // Empty implementation
    }

    @Override
    public void onItemClick(TvRecyclerView parent, View itemView, int position) {
        // Empty implementation
    }
}
