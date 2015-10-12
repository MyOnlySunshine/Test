package com.yonyou.uap.um.binder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BinderHelper {

	public static JSONArray getArrayValue(JSONObject value, BindInfo info) throws JSONException {
		String bindfield = info.getBindField();
		String[] items = bindfield.split(".");
		JSONObject cv = value;
		for(int i=0;i<items.length-1;i++) {
			String fieldname = items[i];
			cv = getJSON(value,fieldname);
		}
		return getArray(cv,items[items.length]);
	}
	
	public static JSONObject getJSONObject(JSONObject value, BindInfo info) throws JSONException {
		String bindfield = info.getBindField();
		String[] items = bindfield.split(".");
		JSONObject cv = value;
		for(int i=0;i<items.length;i++) {
			String fieldname = items[i];
			cv = getJSON(value,fieldname);
		}
		return cv;
	}
	
	private static boolean isArray(String fieldname) {
		return fieldname.endsWith("]");
	}
	
	private static JSONArray getArray(JSONObject value,String fieldname) throws JSONException {
		return value.getJSONArray(fieldname);
	}
	
	private static JSONObject getJSON(JSONObject value,String fieldname) throws JSONException {
		if(isArray(fieldname)) {
			int p = fieldname.indexOf("[");
			int postion = Integer.parseInt(fieldname.substring(p,fieldname.length()-1));
			fieldname= fieldname.substring(0,p);
			return value.getJSONArray(fieldname).getJSONObject(postion);
		}
		return value.getJSONObject(fieldname);
	}
	

}
