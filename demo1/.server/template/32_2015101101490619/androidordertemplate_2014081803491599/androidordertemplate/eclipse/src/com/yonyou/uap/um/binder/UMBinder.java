package com.yonyou.uap.um.binder;

import android.view.View;

import com.yonyou.uap.um.core.IUMContextAccessor;

public abstract class UMBinder implements IBinder {

	private BindInfo mInfo = null;
	private IUMContextAccessor mDs = null;
	private View mView = null;
	
	public UMBinder(IUMContextAccessor ac) {
		mDs = ac;
	}
	
	
	@Override
	public void setBindInfo(BindInfo info) {
		mInfo = info;
	}

	@Override
	public void setDataSource(IUMContextAccessor value) {
		mDs = value;
	}

	@Override
	public void setControl(View v) {
		mView = v;
	}

	@Override
	public abstract void dataBinding();

	@Override
	public abstract void dataCollect(String value);


	@Override
	public BindInfo getBindInfo() {
		return mInfo;
	}


	@Override
	public IUMContextAccessor getDataSource() {
		return mDs;
	}


	@Override
	public View getControl() {
		return mView;
	}

}
