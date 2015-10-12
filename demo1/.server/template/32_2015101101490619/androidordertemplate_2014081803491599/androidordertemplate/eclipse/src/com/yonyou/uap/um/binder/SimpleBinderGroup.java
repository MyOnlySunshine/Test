package com.yonyou.uap.um.binder;

import java.util.Collection;
import java.util.HashMap;

public class SimpleBinderGroup implements IBinderGroup {


	private HashMap<Integer,IBinder> mBinderGroup = new HashMap<Integer,IBinder>();
	

	@Override
	public void addBinderToGroup(int id, IBinder binder) {
		mBinderGroup.put(id, binder);
	}

	@Override
	public IBinder getBinderFromGroup(int id) {
		return mBinderGroup.get(id);
	}

	@Override
	public void bindingAll() {
		for(IBinder binder:mBinderGroup.values()) {
			binder.dataBinding();
		}
	}

	@Override
	public Collection<Integer> keySet() {
		return mBinderGroup.keySet();
	}
	
	

}
