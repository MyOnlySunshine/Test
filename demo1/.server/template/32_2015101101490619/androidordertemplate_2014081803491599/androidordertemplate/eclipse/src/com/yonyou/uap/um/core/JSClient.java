package com.yonyou.uap.um.core;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class JSClient extends WebChromeClient {
	
	public Context ctx;
	
	public JSClient(Context context) {
		this.ctx=context;
	}
	
	 @Override  
     public boolean onJsAlert(WebView view, String url,  
             String message, final JsResult result) {  
         //��Android����滻  
         new AlertDialog.Builder(ctx)  
             .setTitle("Alert")  
             .setMessage(message)  
             .setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {  
                 public void onClick(DialogInterface dialog, int which) {  
                     result.confirm();  
                 }  
             })  
             .setCancelable(false)  
             .create().show();  
         return true;  
     }  
}
