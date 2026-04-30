package org.xwalk.core;

import java.util.Map;

/**
 * Compatibility class for XWalkWebResourceRequest
 */
public class XWalkWebResourceRequest {
    private String url;
    private Map<String, String> requestHeaders;
    private String method;

    public XWalkWebResourceRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}