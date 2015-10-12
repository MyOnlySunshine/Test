package com.yonyou.uap.um.widget;

import java.util.Map;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class Ump2ListAdapter extends BaseAdapter {

	private Ump2ListView mView = null;
	
	
	private int mHeight = 0;

	public Ump2ListAdapter(Ump2ListView view) {
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
		View v = mView.getItemView();
		if (mView.getBinder() != null) {
			mView.getBinder().BindingListItem(position, v,
					getItemObject(position));
		}
		return v;
	}

}

