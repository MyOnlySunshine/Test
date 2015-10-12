package com.yonyou.uap.um.binder;

import org.json.JSONObject;

import android.view.View;

import com.yonyou.uap.um.core.IUMContextAccessor;

public interface IBinder {

	void setBindInfo(BindInfo info);
	BindInfo getBindInfo();
	void setDataSource(IUMContextAccessor value); //用来替换UMContext作为数据源
	IUMContextAccessor getDataSource();
	void setControl(View v);
	View getControl();
	Object getValue();
	void dataBinding();
	void dataCollect(String value);
}
