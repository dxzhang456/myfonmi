package org.xwalk.core;

import android.webkit.WebSettings;

public class XWalkSettings {
    public void setJavaScriptEnabled(boolean enabled) {}
    public void setDomStorageEnabled(boolean enabled) {}
    public void setAllowUniversalAccessFromFileURLs(boolean enabled) {}
    public void setAllowFileAccessFromFileURLs(boolean enabled) {}
    public void setAllowContentAccess(boolean enabled) {}
    public void setAllowFileAccess(boolean enabled) {}
    public void setBlockNetworkImage(boolean enabled) {}
    public void setSupportMultipleWindows(boolean enabled) {}
    public void setUserAgentString(String ua) {}
    public String getUserAgentString() { return ""; }
    public void setMixedContentMode(int mode) {}
    public void setMediaPlaybackRequiresUserGesture(boolean enabled) {}
    public void setBuiltInZoomControls(boolean enabled) {}
    public void setDisplayZoomControls(boolean enabled) {}
    public void setLoadWithOverviewMode(boolean enabled) {}
    public void setUseWideViewPort(boolean enabled) {}
    public void setSupportZoom(boolean enabled) {}
    public void setTextZoom(int textZoom) {}
    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm algorithm) {}
    public void setCacheMode(int mode) {}
    public void setAppCacheEnabled(boolean enabled) {}
    public void setDatabaseEnabled(boolean enabled) {}
    public void setGeolocationEnabled(boolean enabled) {}
    public void setJavaScriptCanOpenWindowsAutomatically(boolean enabled) {}
    public void setSavePassword(boolean enabled) {}
    public void setSaveFormData(boolean enabled) {}
    public boolean getJavaScriptEnabled() { return false; }
}
