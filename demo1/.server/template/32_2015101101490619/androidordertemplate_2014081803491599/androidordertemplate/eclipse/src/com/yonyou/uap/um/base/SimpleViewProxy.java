package com.yonyou.uap.um.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;


public class SimpleViewProxy implements IViewProxy {

	private Context context;
	private Class<?> mClass;
	
	public SimpleViewProxy(Context ctx) {
		this.context = ctx;
	}
	
	
	@Override
	public void open(Activity activity) {
		Intent intent = new Intent(context, mClass);
		activity.startActivity(intent);
	}

	
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Class<?> getViewClass() {
		return mClass;
	}


	@Override
	public void setViewClass(Class<?> cls) {
		mClass = cls;
	}
	
	

}
