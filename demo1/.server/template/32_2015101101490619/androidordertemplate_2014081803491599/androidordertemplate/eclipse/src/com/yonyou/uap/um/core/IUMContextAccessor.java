package com.yonyou.uap.um.core;

import org.json.JSONException;
import org.json.JSONObject;

public interface IUMContextAccessor {

	XJSON getUMContext();
	void setUMContext(XJSON value);
	void setUMContext(String value) throws JSONException;
	Object getValue(String fieldexpression) throws JSONException;
	void setValue(String fieldexpression, Object value);
	
}
