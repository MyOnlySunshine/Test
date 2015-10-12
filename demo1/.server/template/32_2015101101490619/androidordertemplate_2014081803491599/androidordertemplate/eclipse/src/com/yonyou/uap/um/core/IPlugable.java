package com.yonyou.uap.um.core;

import java.util.Map;

public interface IPlugable {

	Map<String,String> getPlugin(String id);
	Map<String,String> getPlugout(String id);
}
