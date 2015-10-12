package com.yonyou.uap.um.binder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;
import android.widget.TextView;

import com.yonyou.uap.um.core.IUMContextAccessor;

public class UMTextBinder extends UMBinder {

	public UMTextBinder(IUMContextAccessor ac) {
		super(ac);
	}

	@Override
	public void dataBinding() {
		View v = getControl();
		String value = getValue().toString();
		if (v instanceof TextView) {
			((TextView) v).setText(value);
			return;
		}
		Method m = getMethod(getControl());
		if (m != null) {
			try {
				m.invoke(v, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Method getMethod(View v) {
		Method m = null;
		if (v == null)
			return null;
		try {
			m = v.getClass().getMethod("setText",
					new Class[] { CharSequence.class });
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void dataCollect(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue() {
		return this.getDataSource().getUMContext()
				.getString(this.getBindInfo().getBindField());
	}

}
