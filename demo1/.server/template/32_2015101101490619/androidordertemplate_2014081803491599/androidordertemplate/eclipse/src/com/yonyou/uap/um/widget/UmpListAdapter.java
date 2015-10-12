package com.yonyou.uap.um.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.Map;

public class UmpListAdapter extends BaseAdapter {

	private UmpListView mView = null;
	private int mHeight = 0;

	public UmpListAdapter(UmpListView view) {
		mView = view;
	}

	@Override
	public int getCount() {
		return mView.getData().size();
	}

	@Override
	public Object getItem(int position) {
		return getItemObject(position);
	}

	private Map<String, ?> getItemObject(int position) {
		return mView.getData().get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int level = mView.getLevel(position);
		View v = mView.getItemView(level);
		if (mView.getBinder(level) != null) {
			mView.getBinder(level).BindingListItem(position, v,
					getItemObject(position));
		}
		return v;
	}

}
