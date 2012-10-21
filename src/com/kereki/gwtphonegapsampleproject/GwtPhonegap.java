package com.kereki.gwtphonegapsampleproject;

import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.DroidGap;
import android.os.Bundle;
import android.webkit.WebView;

public class GwtPhonegap extends DroidGap {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    super.loadUrl("file:///android_asset/www/index.html");
  }

  @Override
  public void init() {
    super.init(new CordovaWebView(this), new CordovaWebViewClient(this) {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return url.startsWith("file://")? false: super
          .shouldOverrideUrlLoading(view, url);
      }
    }, new CordovaChromeClient(this));
  }
}
