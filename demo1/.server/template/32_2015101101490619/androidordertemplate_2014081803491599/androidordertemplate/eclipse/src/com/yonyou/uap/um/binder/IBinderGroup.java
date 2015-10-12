package com.yonyou.uap.um.binder;

import java.util.Collection;

public interface IBinderGroup {

	void addBinderToGroup(int id, IBinder binder);
	IBinder getBinderFromGroup(int id);
	
	void bindingAll();
	Collection<Integer> keySet();
//	void dataBinding(String id);
}
