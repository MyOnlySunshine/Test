//package com.yonyou.uap.um.core;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class UMSnapshot {
//
//	private String path = null;
//
//	private JSONObject mData = null;
//
//	public UMSnapshot(String expression) {
//		path = expression;
//	}
//
//	public void pull(JSONObject main) throws JSONException {
//		mData = UMContext.getJSONObject(main, path);
//	}
//
//	public void push(JSONObject main) {
//		//UMContext.setJSONObject(main, path, mData);
//	}
//
//}
