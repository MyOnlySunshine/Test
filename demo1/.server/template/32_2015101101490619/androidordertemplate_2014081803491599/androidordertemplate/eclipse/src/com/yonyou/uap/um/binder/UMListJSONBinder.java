package com.yonyou.uap.um.binder;

import org.json.JSONObject;

import com.yonyou.uap.um.base.UMListViewBase;
import com.yonyou.uap.um.core.IUMContextAccessor;

import android.view.View;
import android.widget.BaseAdapter;

public class UMListJSONBinder implements IBinder {
	
	
	private BaseAdapter adapter = null;
	
	private IUMContextAccessor accessor = null;
	
	private UMListViewBase mList = null;
	
	private String[] bindfields = null;
	
	public UMListJSONBinder(UMListViewBase list) {
		mList = list;
	}

	@Override
	public void setBindInfo(BindInfo info) {
		bindfields = info.getBindField().split(",");
	}

	@Override
	public void setDataSource(IUMContextAccessor value) {
		accessor = value;
	}

	@Override
	public void dataBinding() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BindInfo getBindInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IUMContextAccessor getDataSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setControl(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View getControl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dataCollect(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}


	
	 
	 
}
