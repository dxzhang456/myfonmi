package com.owen.tvrecyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Compatibility wrapper for TvRecyclerView using AndroidX RecyclerView
 * This maintains the original API while using modern AndroidX components
 */
public class TvRecyclerView extends RecyclerView {
    
    private OnItemListener mOnItemListener;
    private OnInBorderKeyEventListener mOnInBorderKeyEventListener;
    private int mSelectedPosition = 0;
    private int mOldSelectedPosition = 0;

    public TvRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public TvRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TvRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setHasFixedSize(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setChildrenDrawingOrderEnabled(true);
        
        // Add scroll listener to handle item selection
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == SCROLL_STATE_IDLE) {
                    View focusedChild = getFocusedChild();
                    if (focusedChild != null) {
                        int position = getChildAdapterPosition(focusedChild);
                        if (position != NO_POSITION) {
                            setSelectedPosition(position);
                        }
                    }
                }
            }
        });
    }

    public void setOnItemListener(OnItemListener listener) {
        this.mOnItemListener = listener;
    }

    public void setOnInBorderKeyEventListener(OnInBorderKeyEventListener listener) {
        this.mOnInBorderKeyEventListener = listener;
    }

    public void setSelectedPosition(int position) {
        if (position < 0 || getAdapter() == null || position >= getAdapter().getItemCount()) {
            return;
        }
        
        mOldSelectedPosition = mSelectedPosition;
        mSelectedPosition = position;
        
        // Notify listeners
        if (mOnItemListener != null) {
            View oldView = getLayoutManager() != null ? 
                getLayoutManager().findViewByPosition(mOldSelectedPosition) : null;
            View newView = getLayoutManager() != null ? 
                getLayoutManager().findViewByPosition(mSelectedPosition) : null;
            
            if (oldView != null) {
                mOnItemListener.onItemPreSelected(this, oldView, mOldSelectedPosition);
            }
            if (newView != null) {
                mOnItemListener.onItemSelected(this, newView, mSelectedPosition);
            }
        }
        
        // Scroll to position
        if (getLayoutManager() != null) {
            getLayoutManager().scrollToPosition(position);
        }
    }

    public int getSelectedPosition() {
        return mSelectedPosition;
    }
    
    public void setSelection(int position) {
        setSelectedPosition(position);
    }
    
    public void setSelectionWithSmooth(int position) {
        if (position < 0 || getAdapter() == null || position >= getAdapter().getItemCount()) {
            return;
        }
        smoothScrollToPosition(position);
        setSelectedPosition(position);
    }
    
    public void onFocusChange(View view, boolean hasFocus) {
        // Compatibility method for manual focus handling
        if (hasFocus) {
            int position = getChildAdapterPosition(view);
            if (position != NO_POSITION) {
                setSelectedPosition(position);
            }
        }
    }
    
    public void onClick(View view) {
        // Compatibility method for manual click handling
        int position = getChildAdapterPosition(view);
        if (position != NO_POSITION && mOnItemListener != null) {
            mOnItemListener.onItemClick(this, view, position);
        }
    }

    public void setSpacingWithMargins(int spacing) {
        // Add item decoration for spacing
        if (getItemDecorationCount() > 0) {
            removeItemDecorationAt(0);
        }
        addItemDecoration(new SpacingItemDecoration(spacing));
    }
    
    public void setSpacingWithMargins(int horizontalSpacing, int verticalSpacing) {
        // Add item decoration for spacing with different horizontal and vertical values
        if (getItemDecorationCount() > 0) {
            removeItemDecorationAt(0);
        }
        addItemDecoration(new SpacingItemDecoration(horizontalSpacing, verticalSpacing));
    }

    public boolean isScrolling() {
        return getScrollState() != SCROLL_STATE_IDLE;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            View focusedChild = getFocusedChild();
            if (focusedChild != null && mOnInBorderKeyEventListener != null) {
                int direction = -1;
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_DPAD_UP:
                        direction = View.FOCUS_UP;
                        break;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        direction = View.FOCUS_DOWN;
                        break;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        direction = View.FOCUS_LEFT;
                        break;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        direction = View.FOCUS_RIGHT;
                        break;
                }
                
                if (direction != -1) {
                    View nextFocus = focusedChild.focusSearch(direction);
                    if (nextFocus == null || nextFocus == focusedChild) {
                        // At border
                        if (mOnInBorderKeyEventListener.onInBorderKeyEvent(direction, focusedChild)) {
                            return true;
                        }
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void onChildAttachedToWindow(@NonNull View child) {
        super.onChildAttachedToWindow(child);
        
        child.setOnClickListener(v -> {
            int position = getChildAdapterPosition(v);
            if (position != NO_POSITION && mOnItemListener != null) {
                mOnItemListener.onItemClick(this, v, position);
            }
        });
        
        child.setOnFocusChangeListener((v, hasFocus) -> {
            int position = getChildAdapterPosition(v);
            if (position != NO_POSITION && mOnItemListener != null) {
                if (hasFocus) {
                    if (mSelectedPosition != position) {
                        View oldView = getLayoutManager() != null ? 
                            getLayoutManager().findViewByPosition(mSelectedPosition) : null;
                        if (oldView != null) {
                            mOnItemListener.onItemPreSelected(this, oldView, mSelectedPosition);
                        }
                        mSelectedPosition = position;
                    }
                    mOnItemListener.onItemSelected(this, v, position);
                } else {
                    mOnItemListener.onItemPreSelected(this, v, position);
                }
            }
        });
    }

    /**
     * Listener for item events
     */
    public interface OnItemListener {
        void onItemPreSelected(TvRecyclerView parent, View itemView, int position);
        void onItemSelected(TvRecyclerView parent, View itemView, int position);
        void onItemClick(TvRecyclerView parent, View itemView, int position);
    }

    /**
     * Listener for border key events
     */
    public interface OnInBorderKeyEventListener {
        boolean onInBorderKeyEvent(int direction, View focused);
    }

    /**
     * Item decoration for spacing
     */
    private static class SpacingItemDecoration extends RecyclerView.ItemDecoration {
        private final int horizontalSpacing;
        private final int verticalSpacing;

        SpacingItemDecoration(int spacing) {
            this.horizontalSpacing = spacing;
            this.verticalSpacing = spacing;
        }
        
        SpacingItemDecoration(int horizontalSpacing, int verticalSpacing) {
            this.horizontalSpacing = horizontalSpacing;
            this.verticalSpacing = verticalSpacing;
        }

        @Override
        public void getItemOffsets(@NonNull android.graphics.Rect outRect, @NonNull View view,
                                    @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.left = horizontalSpacing;
            outRect.right = horizontalSpacing;
            outRect.top = verticalSpacing;
            outRect.bottom = verticalSpacing;
        }
    }
}