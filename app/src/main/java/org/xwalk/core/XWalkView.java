package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;

import java.util.Map;

public class XWalkView extends ViewGroup {

    public XWalkView(Context context) {
        super(context);
    }

    public XWalkView(Context context, Activity activity) {
        super(context);
    }

    public XWalkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // Empty implementation for ViewGroup
    }

    public XWalkSettings getSettings() { return new XWalkSettings(); }
    public void setUIClient(XWalkUIClient client) {}
    public void setResourceClient(XWalkResourceClient client) {}
    public void load(String url, String content) {}
    public void loadUrl(String url) {}
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {}
    public void evaluateJavascript(String script, ValueCallback<String> callback) {}
    public void addJavascriptInterface(Object obj, String name) {}
    public void onResume() {}
    public void onPause() {}
    public void onDestroy() {}
    public void onActivityResult(int requestCode, int resultCode, Intent data) {}
    public String getUrl() { return null; }
    public void stopLoading() {}
    public void reload(int mode) {}
    public boolean canGoBack() { return false; }
    public void goBack() {}
    public boolean canGoForward() { return false; }
    public void goForward() {}
    public void clearCache(boolean includeDiskFiles) {}
    public void clearHistory() {}
    public String getTitle() { return null; }
    public void setInitialScale(int scaleInPercent) {}
    public void pauseTimers() {}
    public void resumeTimers() {}
    public void setNetworkAvailable(boolean networkUp) {}
    public void setScrollBarStyle(int style) {}
    public void setHorizontalScrollBarEnabled(boolean enabled) {}
    public void setVerticalScrollBarEnabled(boolean enabled) {}
    public void setBackgroundColor(int color) {}
    public void setLayerType(int layerType, android.graphics.Paint paint) {}
    public void setFocusable(boolean focusable) {}
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {}
    
    @Override
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        return super.requestFocus(direction, previouslyFocusedRect);
    }
    
    public void removeAllViews() {
        super.removeAllViews();
    }
}
