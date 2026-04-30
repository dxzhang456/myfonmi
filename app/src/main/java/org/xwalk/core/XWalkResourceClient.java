package org.xwalk.core;

import java.io.InputStream;

public class XWalkResourceClient {

    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;

    public XWalkResourceClient(XWalkView view) {}

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, String url) { return null; }
    public void onReceivedLoadError(XWalkView view, int errorCode, String description, String failingUrl) {}
    public void onLoadStarted(XWalkView view, String url) {}
    public void onLoadFinished(XWalkView view, String url) {}
    public void onProgressChanged(XWalkView view, int progressInPercent) {}
    public boolean shouldOverrideUrlLoading(XWalkView view, String url) { return false; }
    public void onReceivedSslError(XWalkView view, android.webkit.SslErrorHandler handler, android.net.http.SslError error) {}
    public void onReceivedSslError(XWalkView view, android.webkit.ValueCallback<Boolean> callback, android.net.http.SslError error) {}
    public void onReceivedClientCertRequest(XWalkView view, android.webkit.ClientCertRequest handler) {}
    public void onDocumentLoadedInFrame(XWalkView view, long frameId) {}
    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) { return null; }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {
        return new XWalkWebResourceResponse(mimeType, encoding, data);
    }
}
