package org.xwalk.core;

import java.io.InputStream;

public class XWalkResourceClient {

    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = -1;

    public XWalkResourceClient(XWalkView view) {}

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, String url) {
        return null;
    }

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view,
            XWalkWebResourceRequest request) {
        return null;
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String mimeType,
            String encoding, InputStream data) {
        return new XWalkWebResourceResponse(mimeType, encoding, data);
    }

    public void onReceivedResponseHeaders(XWalkView view, XWalkWebResourceRequest request,
            XWalkWebResourceResponse response) {}

    public void onLoadStarted(XWalkView view, String url) {}

    public void onLoadFinished(XWalkView view, String url) {}

    public void onProgressChanged(XWalkView view, int progressInPercent) {}

    public void onReceivedLoadError(XWalkView view, int errorCode, String description,
            String failingUrl) {}
}