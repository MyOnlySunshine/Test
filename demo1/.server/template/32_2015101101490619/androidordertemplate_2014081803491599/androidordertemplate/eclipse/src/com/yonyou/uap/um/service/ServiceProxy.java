package com.yonyou.uap.um.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yonyou.uap.um.service.HttpHelper.HttpMethod;
import com.yonyou.uap.um.widget.UmpListValue;

public class ServiceProxy {

	private Context context;

	// private static HashMap<String,JSONObject> cache = new
	// HashMap<String,JSONObject>();

	public ServiceProxy(Context ctx) {
		this.context = ctx;
	}

	public String start(String url, ServiceCallback callback) {
		url = url.replace(">", "%3E");
		new Thread(new HttpRunner(url, new HttpReceiver(callback))).start();
		return "success";

	}
	
	public String start(String url, HashMap<String,String> parameter, ServiceCallback callback) {
		url = url.replace(">", "%3E");
		new Thread(new HttpRunner(url, parameter, new HttpReceiver(callback))).start();
		return "success";

	}

	public class HttpReceiver extends Handler {

		private ServiceCallback mCallback;

		public HttpReceiver(ServiceCallback callback) {
			mCallback = callback;
		}

		@Override
		public void handleMessage(Message msg) {
			if (!Thread.currentThread().isInterrupted()) {
				try {
					if (msg.obj == null)
						return;
					mCallback.execute(new JSONObject(msg.obj.toString()));
				} catch (JSONException e) {
					Log.e("service", msg.obj.toString());
					e.printStackTrace();
				}
			}
			super.handleMessage(msg);
		}

	}

	public class HttpRunner implements Runnable, HttpCallback {
		private HttpReceiver mReceiver = null;
		private String mUrl = "";
		private HashMap<String, String> params = null;
		private HttpMethod method = null;

		public HttpRunner(String url, HttpReceiver rec) {
			mReceiver = rec;
			mUrl = url;
			method = HttpMethod.GET;
		}
		
		public HttpRunner(String url, HashMap<String,String> parameter, HttpReceiver rec) {
			mReceiver = rec;
			mUrl = url;
			method = HttpMethod.POST;
			params = parameter;
		}

		@Override
		public void execute(String response) {
			if(response==null) {
				return;
			}
			Message msg = new Message();
			msg.obj = response;
			mReceiver.sendMessage(msg);
		}

		@Override
		public void run() {
			HttpHelper helper = new HttpHelper();
			if (method == HttpMethod.GET) {
				helper.syncConnect(mUrl, method, this);
			} else {
				helper.syncConnect(mUrl, params, method, this);
			}
		}

	}
}
