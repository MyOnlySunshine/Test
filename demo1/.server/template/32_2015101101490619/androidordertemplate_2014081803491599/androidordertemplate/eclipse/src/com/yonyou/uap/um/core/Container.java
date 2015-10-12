package com.yonyou.uap.um.core;

import org.json.JSONObject;

import android.content.Context;

public class Container {
	private UMActivity context = null;
	private JSCore js = null;
	
	public Container(UMActivity ctx) {
		this.context=ctx;
		js= new JSCore(ctx);
	}

	public void loadLibrary(String file) {
		js.loadLibrary(file);
	}

	public void exec(String method) {
		js.exec(method);
	}

	public void transfer(Object value, String name) {
		js.transfer(value,name);
	}

	public void query(String method) {
		js.query(method);
	}
	
	
}
