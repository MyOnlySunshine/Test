package com.yonyou.uap.um.core;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JSClient2 extends WebViewClient {
	public UMActivity ctx;
	
	public JSClient2(UMActivity context) {
		this.ctx=context;
	}
	
    public void onPageFinished(WebView view, String url) {
    	ctx.onAfterInit();
    }
}
