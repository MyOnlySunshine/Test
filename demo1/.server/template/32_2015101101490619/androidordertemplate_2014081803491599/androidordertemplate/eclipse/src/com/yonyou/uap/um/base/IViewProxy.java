package com.yonyou.uap.um.base;

import android.app.Activity;

public interface IViewProxy {
	void open(Activity activity);
	String getId();
	Class<?> getViewClass();
	void setViewClass(Class<?> cls);
}
