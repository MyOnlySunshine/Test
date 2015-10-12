package com.yonyou.uap.um.base;

import java.util.HashMap;
import java.util.Set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

public class UMEventArgs {

	private HashMap<String, Object> innerData = new HashMap<String, Object>();

	private Context context = null;

	public Context getContext() {
		return context;
	}

	public void put(String name, Object value) {
		if (name.equalsIgnoreCase("context")) {
			context = (Context) value;
		}
		innerData.put(name.toLowerCase(), value);
	}

	public Object get(String name) {
		return innerData.get(name.toLowerCase());
	}

	public Set<String> keySet() {
		return innerData.keySet();
	}

	public String getString(String name) {
		Object value = this.get(name);
		if (value == null)
			return "";
		if (value instanceof String) {
			return (String) value;
		}
		return value.toString();
	}

	public boolean getBoolean(String name, boolean defvalue) {
		Object value = this.get(name);
		if (value == null)
			return defvalue;
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		return Boolean.parseBoolean(value.toString());
	}

	public int getInt(String name, int defvalue) {
		Object value = this.get(name);
		if (value == null)
			return defvalue;
		if (value instanceof Integer) {
			return (Integer) value;
		}
		return Integer.parseInt(value.toString());
	}

	public long getLong(String name, long defvalue) {
		Object value = this.get(name);
		if (value == null)
			return defvalue;
		if (value instanceof Long) {
			return (Long) value;
		}
		return Long.parseLong(value.toString());
	}

	public short getShort(String name, short defvalue) {
		Object value = this.get(name);
		if (value == null)
			return defvalue;
		if (value instanceof Short) {
			return (Short) value;
		}
		return Short.parseShort(value.toString());
	}

	public int getInt(String value) {
		return getInt(value, 0);
	}

	public void put(UMEventArgs args) {
		for (String key : args.keySet()) {
			this.put(key, args.get(key));
		}
	}

}
