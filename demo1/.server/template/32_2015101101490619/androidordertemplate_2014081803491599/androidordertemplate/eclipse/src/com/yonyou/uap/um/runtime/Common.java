package com.yonyou.uap.um.runtime;

public class Common {


	public static int getDp(double value) {
		return (int) (value*1.5);
	}

	public static boolean isEmpty(String title) {
		return title==null || title.equals("");
	}

}
