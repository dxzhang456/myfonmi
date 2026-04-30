package org.xwalk.core;

public class XWalkUIClient {

    public enum LoadStatus {
        FINISHED, FAILED, CANCELLED
    }

    public enum ConsoleMessageType {
        DEBUG, ERROR, LOG, INFO, WARNING
    }

    public XWalkUIClient(XWalkView view) {}

    public boolean onConsoleMessage(XWalkView view, String message, int lineNumber, String sourceId, ConsoleMessageType messageType) { return false; }
    public boolean onJsAlert(XWalkView view, String url, String message, XWalkJavascriptResult result) { return false; }
    public boolean onJsConfirm(XWalkView view, String url, String message, XWalkJavascriptResult result) { return false; }
    public boolean onJsPrompt(XWalkView view, String url, String message, String defaultValue, XWalkJavascriptResult result) { return false; }
    public void onPageLoadStarted(XWalkView view, String url) {}
    public void onPageLoadStopped(XWalkView view, String url, LoadStatus status) {}
    public void onReceivedTitle(XWalkView view, String title) {}
    public void onFullscreenToggled(XWalkView view, boolean enterFullscreen) {}
    public boolean onCreateWindowRequested(XWalkView view, InitiateBy initiator, XWalkView newXWalkView) { return false; }
    public void onIconAvailable(XWalkView view, String url, android.graphics.Bitmap icon) {}
    public void onReceivedIcon(XWalkView view, android.graphics.Bitmap icon) {}
    public void openFileChooser(XWalkView view, android.webkit.ValueCallback<android.net.Uri> uploadFile, String acceptType, String capture) {}
    public void onScaleChanged(XWalkView view, float oldScale, float newScale) {}
    public void onDocumentLoadedInFrame(XWalkView view, long frameId) {}
    public void onLoadStarted(XWalkView view, String url) {}
    public void onLoadFinished(XWalkView view, String url) {}
    public void onProgressChanged(XWalkView view, int newProgress) {}

    public enum InitiateBy {
        USER_GESTURE, JAVASCRIPT
    }
}
