package com.yonyou.uap.um.binder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yonyou.uap.um.base.UMListViewBase;
import com.yonyou.uap.um.core.IUMContextAccessor;
import com.yonyou.uap.um.core.XJSON;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author xyy
 * @Date 2013-4-25 上午8:36:18
 * @version
 */

public class UMListBinder extends BaseAdapter implements IBinder, IBinderGroup {

	// private UMListViewBase mView = null;
	private UMBinder binder = null;
	private List<XJSON> mData = null;
	private Map<Integer, ListBindInfo> mLevel = null;
	private SimpleBinderGroup mGroup = new SimpleBinderGroup();

	public UMListBinder(IUMContextAccessor datasource) {
		binder = new UMTextBinder(datasource);
	}

	public void setControl(View v) {
		binder.setControl(v);
	}

	public List<XJSON> getValue() {
		if (mData == null) {
			mData = new ArrayList<XJSON>();
			mLevel = new HashMap<Integer, ListBindInfo>();
			String[] fields = binder.getBindInfo().getBindField().split(",");
			try {
				putData(fields, 0, binder.getDataSource().getUMContext(), "");
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
		}
		return mData;
	}

	private void putData(String[] fields, int index, XJSON parent,
			String parentfield) throws JSONException {
		String fieldname = fields[index];
		if (!parentfield.equals(""))
			parentfield += ".";
		JSONArray child = null;
		Object vv = parent.getValue(fieldname);
		if(vv instanceof JSONArray) {
			child = (JSONArray) vv;
		} else {
			child = new JSONArray(vv.toString());
		}
		for (int i = 0; i < child.length(); i++) {
			String fullpath = parentfield + fieldname + "[" + i + "]";
			XJSON item = new XJSON(child.getJSONObject(i));
			mData.add(item);
			mLevel.put(mData.size() - 1, new ListBindInfo(index, fullpath));
			if (index < fields.length - 1) {
				putData(fields, index + 1, item, fullpath);
			}
		}
	}

	public class ListBindInfo {

		public ListBindInfo(int vindex, String bfield) {
			this.viewIndex = vindex;
			this.bindfield = bfield;
		}

		private int viewIndex;

		public int getViewIndex() {
			return viewIndex;
		}

		public void setViewIndex(int viewIndex) {
			this.viewIndex = viewIndex;
		}

		private String bindfield;

		public String getBindfield() {
			return bindfield;
		}

		public void setBindfield(String bindfield) {
			this.bindfield = bindfield;
		}

		@Override
		public String toString() {
			return "" + this.viewIndex + "[" + this.bindfield + "]";
		}
	}

	@Override
	public int getCount() {
		return getValue().size();
	}

	@Override
	public Object getItem(int position) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("data", getValue().get(position));
		data.put("bindfield", mLevel.get(position));

		return data;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		UMListViewBase mView = (UMListViewBase) binder.getControl();
		int level = mLevel.get(position).getViewIndex();

		SimpleBinderGroup group = new SimpleBinderGroup();
		View v = mView.getItemView(level, group);
		String bindfield = mLevel.get(position).bindfield;
		if (bindfield != null && !bindfield.equals(""))
			bindfield += ".";
		for(int binderId : group.keySet()) {
			IBinder binder = group.getBinderFromGroup(binderId);
			BindInfo info = binder.getBindInfo();
			info.setBindField(bindfield+info.getBindField());
			binder.setBindInfo(info);
			binder.dataBinding();
			//this.addBinderToGroup(binderId, binder);
		}

		if (mView.getItemViewBinder(level) != null) {
			mView.getItemViewBinder(level).BindingListItem(position, v,
					(Map) getItem(position));
		}
		return v;
	}

	@Override
	public void setBindInfo(BindInfo info) {
		binder.setBindInfo(info);
	}

	@Override
	public void setDataSource(IUMContextAccessor value) {
		binder.setDataSource(value);
	}

	@Override
	public void dataBinding() {
		UMListViewBase mView = (UMListViewBase) binder.getControl();
		this.mData = null;
		mView.setAdapter(this);
		mView.dataBinding(this);
		//mGroup.bindingAll();
		//mView.requestLayout();
	}

	@Override
	public void dataCollect(String value) {

	}

	@Override
	public BindInfo getBindInfo() {
		return binder.getBindInfo();
	}

	@Override
	public IUMContextAccessor getDataSource() {
		return binder.getDataSource();
	}

	@Override
	public View getControl() {
		return binder.getControl();
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

	@Override
	public Collection<Integer> keySet() {
		return mGroup.keySet();
	}

}