package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;

public class XWalkView extends FrameLayout {

    public XWalkView(Context context) {
        super(context);
    }

    public XWalkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XWalkView(Context context, Activity activity) {
        super(context);
    }

    public XWalkSettings getSettings() {
        return new XWalkSettings();
    }

    public void setUIClient(XWalkUIClient client) {}

    public void setResourceClient(XWalkResourceClient client) {}

    @Override
    public void setOverScrollMode(int mode) {}

    public void load(String url, String content) {}

    public void reload(int mode) {}

    public void stopLoading() {}

    public String getUrl() { return ""; }

    public String getTitle() { return ""; }

    public boolean canGoBack() { return false; }

    public boolean canGoForward() { return false; }

    public void goBack() {}

    public void goForward() {}

    public void clearHistory() {}

    public void clearCache(boolean includeDiskFiles) {}

    public void evaluateJavascript(String script, ValueCallback<String> callback) {}

    public void addJavascriptInterface(Object object, String name) {}

    public void removeJavascriptInterface(String name) {}

    public void onShow() {}

    public void onHide() {}

    public void onDestroy() {}

    public void onActivityResult(int requestCode, int resultCode, Intent data) {}

    public void onNewIntent(Intent intent) {}

    public void setNetworkAvailable(boolean networkUp) {}

    public void setInitialScale(int scaleInPercent) {}

    public void setZOrderOnTop(boolean onTop) {}

    public void setZOrderMediaOverlay(boolean isMediaOverlay) {}
}