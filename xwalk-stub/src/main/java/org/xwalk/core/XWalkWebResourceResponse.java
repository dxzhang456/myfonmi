package org.xwalk.core;

import java.io.InputStream;
import java.util.Map;

public class XWalkWebResourceResponse {
    public XWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {}
    public XWalkWebResourceResponse(String mimeType, String encoding, int statusCode,
            String reasonPhrase, Map<String, String> responseHeaders, InputStream data) {}
    public String getMimeType() { return null; }
    public String getEncoding() { return null; }
    public InputStream getData() { return null; }
    public int getStatusCode() { return 200; }
    public String getReasonPhrase() { return null; }
    public Map<String, String> getResponseHeaders() { return null; }
    public void setMimeType(String mimeType) {}
    public void setEncoding(String encoding) {}
    public void setData(InputStream data) {}
    public void setStatusCodeAndReasonPhrase(int statusCode, String reasonPhrase) {}
    public void setResponseHeaders(Map<String, String> headers) {}
}