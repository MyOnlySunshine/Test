package com.yonyou.uap.um.core;

import android.content.Context;
import android.webkit.WebView;


public final class JSCore  {

	private UMActivity context = null;
	
	private WebView js = null;
	
	public JSCore(UMActivity ctx) {
		this.context=ctx;
		js = new WebView(ctx);
		js.getSettings().setJavaScriptEnabled(true);
		//js.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
		transfer(new ReceivedReturn(ctx),"ret");
		js.setWebViewClient(new JSClient2(ctx));
		js.loadUrl("file:///android_asset/Html/customer.html");
		js.setWebChromeClient(new JSClient(this.context) );
		js.setWebViewClient(new JSClient2(this.context));
	}
	
	public String exec(String method) {
		js.loadUrl("javascript:" + method);
		return "";
	}

	public void loadLibrary(String file) {
		;
	}

	public void transfer(Object value, String name) {
		js.addJavascriptInterface(value, name);
	}

	public void query(String method) {
		exec("getReturn('" + method + "')");
	}

}
