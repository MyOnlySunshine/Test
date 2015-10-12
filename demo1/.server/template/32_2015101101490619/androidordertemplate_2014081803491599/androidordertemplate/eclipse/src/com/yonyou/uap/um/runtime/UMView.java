package com.yonyou.uap.um.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.core.UMActivity;

public class UMView {

	public static void open(UMEventArgs args) {
		UMActivity ctx = (UMActivity) args.getContext();

		String viewid = args.getString("viewid");
		Intent intent = new Intent(viewid);
		boolean isKeep = args.getBoolean("isKeep",true); //转跳其它Activity后，是否保留本身
		for (String key : args.keySet()) {
			if(key.equalsIgnoreCase("context")) continue;
			if(key.equalsIgnoreCase("isKeep")) continue;
			if(key.equalsIgnoreCase("plugout-value")) {
				intent.putExtra("plugin-value", args.getString(key));
			}
			intent.putExtra(key, args.getString(key));
		}
		ctx.startActivity(intent);
		ctx.overridePendingTransition(android.R.anim.slide_in_left,
				android.R.anim.fade_out);
		if(!isKeep) {
			ctx.finish();
		}
	}

	public static void close(UMEventArgs args) {
		Activity ctx = (Activity) args.getContext();
		ctx.finish();
	}

}
