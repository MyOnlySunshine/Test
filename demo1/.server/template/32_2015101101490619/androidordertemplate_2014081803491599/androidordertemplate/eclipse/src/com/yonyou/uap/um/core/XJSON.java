package com.yonyou.uap.um.core;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class XJSON {

	private JSONObject mData;
	
	public XJSON() {
		mData = new JSONObject();
	}

	public XJSON(JSONObject json) {
		if (json == null) {
			throw new RuntimeException("json is null");
		}
		mData = json;
	}

	public XJSON(String json) throws JSONException {
		mData = new JSONObject(json);
	}

	public Object getValue(String path) throws JSONException {
		String[] items = path.replace(".", "UMSYS-Breaking").split(
				"UMSYS-Breaking");
		Object cv = mData;
		for (int i = 0; i < items.length; i++) {
			String fieldname = items[i];
			if (cv instanceof JSONObject) {
				if (isArray(fieldname)) {
					int p = fieldname.indexOf("[");
					int postion = Integer.parseInt(fieldname.substring(p + 1,
							fieldname.length() - 1));
					fieldname = fieldname.substring(0, p);
					cv = ((JSONObject) cv).getJSONArray(fieldname)
							.getJSONObject(postion);
					continue;
				} else {
					cv = ((JSONObject) cv).opt(fieldname);
					continue;
				}
			}
			throw new JSONException(path + "is eror");
		}
		return cv;
	}

	public String getString(String path) {
		try {
			Object value = this.getValue(path);
			if (value == null)
				return "";
			return value.toString();
		} catch (JSONException e) {
			Log.w("XJSON", e.getMessage());
			return "";
		}
	}

	private boolean isArray(String fieldname) {
		return fieldname.endsWith("]");
	}

	@Override
	public String toString() {
		return mData.toString();
	}

	public JSONObject toJSONObject() {
		return mData;
	}

	public void setValue(String name, Object value) throws JSONException {
		mData.put(name, value);
	}

}
