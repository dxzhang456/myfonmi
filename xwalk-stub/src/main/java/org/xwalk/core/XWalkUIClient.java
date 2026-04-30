package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;

public class XWalkUIClient {

    public enum ConsoleMessageType {
        DEBUG, ERROR, LOG, TIP, WARNING
    }

    public enum LoadStatus {
        FINISHED, FAILED, CANCELLED
    }

    public XWalkUIClient(XWalkView view) {}

    public boolean onConsoleMessage(XWalkView view, String message, int lineNumber,
            String sourceId, ConsoleMessageType messageType) {
        return false;
    }

    public boolean onJsAlert(XWalkView view, String url, String message,
            XWalkJavascriptResult result) {
        return false;
    }

    public boolean onJsConfirm(XWalkView view, String url, String message,
            XWalkJavascriptResult result) {
        return false;
    }

    public boolean onJsPrompt(XWalkView view, String url, String message,
            String defaultValue, XWalkJavascriptResult result) {
        return false;
    }

    public void onPageLoadStarted(XWalkView view, String url) {}

    public void onPageLoadStopped(XWalkView view, String url, LoadStatus status) {}

    public void onReceivedTitle(XWalkView view, String title) {}

    public void onIconAvailable(XWalkView view, String url, Bitmap icon) {}

    public void onReceivedIcon(XWalkView view, String url, Bitmap icon) {}

    public void openFileChooser(XWalkView view, ValueCallback<Uri> uploadFile,
            String acceptType, String capture) {}

    public void onFullscreenToggled(XWalkView view, boolean enterFullscreen) {}

    public void onScaleChanged(XWalkView view, float oldScale, float newScale) {}

    public boolean shouldOverrideUrlLoading(XWalkView view, String url) {
        return false;
    }
}