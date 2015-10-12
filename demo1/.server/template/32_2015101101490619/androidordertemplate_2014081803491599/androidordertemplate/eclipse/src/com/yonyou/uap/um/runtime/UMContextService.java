package com.yonyou.uap.um.runtime;

import org.json.JSONObject;

import com.yonyou.uap.um.core.IUMContextAccessor;
import com.yonyou.uap.um.core.XJSON;
import com.yonyou.uap.um.service.ServiceCallback;

public class UMContextService implements ServiceCallback {
	private IUMContextAccessor accessor = null;
	
	public UMContextService(IUMContextAccessor ac) {
		accessor = ac;
	}

	@Override
	public void execute(JSONObject response) {
		accessor.setUMContext(new XJSON(response));
	}
}
