package com.yonyou.uap.um.core;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.binder.IBinder;
import com.yonyou.uap.um.binder.IBinderGroup;
import com.yonyou.uap.um.binder.SimpleBinderGroup;
import com.yonyou.uap.um.runtime.Common;

import android.app.Activity;

public abstract class UMActivity extends Activity implements IReturn,
		IUMContextAccessor, IUMDataBinding, IBinderGroup, IPlugable {

	private Container container = null;
	private UMActivity activity = null;
	private XJSON mModel = null;
	private SimpleBinderGroup mGroup = new SimpleBinderGroup();

	public interface OnBeforeActionListener {
		void onBeforeAction(String actionId, String method, UMEventArgs args);
	}

	private OnBeforeActionListener onBeforeActionListener = null;

	public OnBeforeActionListener getOnBeforeActionListener() {
		return onBeforeActionListener;
	}

	public void setOnBeforeActionListener(
			OnBeforeActionListener onBeforeActionListener) {
		this.onBeforeActionListener = onBeforeActionListener;
	}

	protected Container getContainer(UMActivity ctx) {
		if (container == null) {
			if (ctx == null) {
				throw new RuntimeException("Container未初始化");
			}
			this.activity = ctx;
			this.container = new Container(ctx);
		}
		return container;
	}

	protected Container getContainer() {
		return getContainer(null);
	}

	protected void run(String method) {
		if (method.startsWith("native.")) {
			method = method.substring("native.".length());
			try {
				this.getClass().getMethod(method, new Class[] {})
						.invoke(this, new Object[] {});
			} catch (IllegalArgumentException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return;
		}
		this.getContainer().query(method);
	}

	public void run2(String method) {
		this.getContainer().exec(method);
	}

	public void init(UMActivity activity) {
		getContainer(activity);
	}

	public abstract void onAfterInit();

	// protected void transfer(UMContext umctx, String name) throws
	// JSONException {
	// //this.getContainer().transfer(umctx.toJson(), name);
	// }

	protected void dataCollect(Object value, String name) {
		this.getContainer().transfer(value, name);
	}

	protected void loadLibrary(String file) {
		container.loadLibrary(file);
	}

	public XJSON getUMContext() {
		return mModel;
	}

	public void setUMContext(XJSON value) {
		mModel = value;
		onDatabinding();
	}

	public void setUMContext(String value) throws JSONException {
		setUMContext(new XJSON(value));
	}

	public Object getValue(String fieldexpression) throws JSONException {
		return mModel.getValue(fieldexpression);
	}

	public void setValue(String fieldexpression, Object value) {

	}

	@Override
	public void addBinderToGroup(int id, IBinder binder) {
		mGroup.addBinderToGroup(id, binder);
	}

	@Override
	public IBinder getBinderFromGroup(int id) {
		return mGroup.getBinderFromGroup(id);
	}

	@Override
	public void bindingAll() {
		mGroup.bindingAll();
	}

	public void onDatabinding() {
		bindingAll();
	}

	@Override
	public Collection<Integer> keySet() {
		return mGroup.keySet();
	}

	public Map<String, String> getPlugin(String id) {
		// return this.getUMContext();
		return new HashMap<String, String>();
	}

	public Map<String, String> getPlugout(String id) {
		return new HashMap<String, String>();
	}

	public String getPluginString(String name) {
		return getPluginString(name, "");
	}

	public String getPluginString(String name, String defValue) {
		String r = this.getIntent().getStringExtra(name);
		if (Common.isEmpty(r)) {
			return defValue;
		}
		return r;
	}
}
