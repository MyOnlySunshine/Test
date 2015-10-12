package com.yonyou.uap.um.core;

import org.json.JSONException;
import org.json.JSONObject;
import android.os.Handler;
import android.os.Message;
//import android.webkit.JavascriptInterface;
import android.widget.EditText;
import android.widget.Toast;

public class ReceivedReturn {

	private IReturn ret = null;
	private Handler mHandler = null;

	public ReceivedReturn(IReturn r) {
		ret = r;
		mHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {

				if (!Thread.currentThread().isInterrupted()) {
					ReturnObject rr = (ReturnObject) msg.obj;
					ReceivedReturn.this.ret.onReturn(rr.method, rr.value);
				}
				super.handleMessage(msg);
			}
		};
	}

	public void get(String name, String value) {
		if (value.equalsIgnoreCase("undefined")) {
			return; // no return value or return a null.
		}

		Message msg = new Message();
		msg.obj = new ReturnObject(name, value);
		mHandler.sendMessage(msg);
	}
}
