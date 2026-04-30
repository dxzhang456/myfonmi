package org.xwalk.core;

public interface XWalkJavascriptResult {
    void confirmResult();
    void confirmResult(String promptResult);
    void cancelResult();
}