package com.yonyou.uap.um.base;

import java.util.HashMap;

public class ViewPool {

	private static HashMap<String, IViewProxy> proxys = new HashMap<String, IViewProxy>();

	public void registerViewProxy(IViewProxy proxy) {
		proxys.put(proxy.getId(), proxy);
	}
	
	public IViewProxy getViewProxy(String id) {
		return proxys.get(id);
	}
}
