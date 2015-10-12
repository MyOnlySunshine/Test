package com.yonyou.uap.um.runtime;

import java.util.HashMap;

import org.json.JSONObject;

import android.content.Context;
import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.core.IUMContextAccessor;
import com.yonyou.uap.um.core.UMActivity;
import com.yonyou.uap.um.service.ServiceProxy;


public class UMService {

	 /*port="1348" 
			    viewid="nc.bs.pubitf.uap.ump.contacts.IContactsController"
			    action="getPersonListByGroupID" parameter="{'groupid':'212121212','usrid':'123123123','psngroupid':'1'}"
	*/
	public static void load(UMEventArgs args) {
		UMActivity context = (UMActivity) args.getContext();
		String host = args.getString("host");
		int port = args.getInt("port");
		
		HashMap<String,String> param = new HashMap<String,String>();
		param.put("viewid", args.getString("viewid"));
		param.put("actionname", args.getString("action"));
		param.put("parames", args.getString("parameter"));
		
		String url = "http://" + host + ":" + port + "/umserver/core/";
		
		new ServiceProxy(context).start(url, param, new UMContextService(
				(IUMContextAccessor) context));
		
	}
	
	public static void loadByURL(UMEventArgs args) {
		UMActivity context = (UMActivity) args.getContext();
		String url = args.getString("host") + args.getString("action");

		String orderno = context.getIntent().getStringExtra("orderno");
		if(orderno==null) orderno="";
		url = url.replace("@X{orderno}", orderno);
		
		new ServiceProxy(context).start(url, new UMContextService(
				(IUMContextAccessor) context));
	}
	
	public static void search(UMEventArgs args) {
		Context context = args.getContext();
		String action = args.getString("action");
		String search = args.getString("search");
		action = action.replace("[search]", search);
		args.put("action", action);
		
		load(args);
	}

}
