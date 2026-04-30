package org.xwalk.core;

import java.io.InputStream;
import java.util.Map;

public class XWalkWebResourceResponse {
    private String mMimeType;
    private String mEncoding;
    private InputStream mData;

    public XWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {
        mMimeType = mimeType;
        mEncoding = encoding;
        mData = data;
    }

    public String getMimeType() { return mMimeType; }
    public String getEncoding() { return mEncoding; }
    public InputStream getData() { return mData; }
    public void setMimeType(String mimeType) { mMimeType = mimeType; }
    public void setEncoding(String encoding) { mEncoding = encoding; }
    public void setData(InputStream data) { mData = data; }
    public int getStatusCode() { return 200; }
    public String getReasonPhrase() { return "OK"; }
    public Map<String, String> getResponseHeaders() { return null; }
}