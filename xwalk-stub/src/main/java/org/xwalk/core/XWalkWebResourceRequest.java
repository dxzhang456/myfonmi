package org.xwalk.core;

import java.util.Map;

public interface XWalkWebResourceRequest {
    android.net.Uri getUrl();
    boolean isForMainFrame();
    boolean hasGesture();
    String getMethod();
    Map<String, String> getRequestHeaders();
}