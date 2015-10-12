//package com.yonyou.uap.um.core;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
//public class UMContext implements IUMContextAccessor {
//	
//	private XJSON main = null;
//	
//	public UMContext(JSONObject json) {
//		main = new XJSON(json);
//	}
//	
//	public UMContext(String json) throws JSONException {
//		main = new XJSON(json);
//	}
//
//
//	@Override
//	public void setUMContext(String value) throws JSONException {
//		main = new XJSON(value);
//	}
//
//	@Override
//	public String getValue(String fieldexpression) throws JSONException {
//		return main.getValue(fieldexpression).toString();
//	}
//
//	@Override
//	public void setValue(String fieldexpression, String value) {
//		throw new RuntimeException("not implement");
//	}
//
//	@Override
//	public XJSON getUMContext() {
//		return main;
//	}
//
//	@Override
//	public void setUMContext(XJSON value) {
//		main = value;
//	}
//
//	
//
//}
