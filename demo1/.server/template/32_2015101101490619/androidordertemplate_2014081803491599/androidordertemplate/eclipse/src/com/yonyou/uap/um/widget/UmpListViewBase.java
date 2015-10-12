package com.yonyou.uap.um.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class UmpListViewBase extends ListView implements UmpListView {

	protected ArrayList<ListItemView> mItemView = new ArrayList<ListItemView>();
	protected ArrayList<UmListItemViewBinder> mBinder = new ArrayList<UmListItemViewBinder>();
	protected ArrayList<Integer> mMapping = new ArrayList<Integer>(); // 参数2：0表示叶子，1表示1级
	protected UmpListValue mData = new UmpListValue();
	protected Context context;

	public UmpListViewBase(Context context) {
		super(context);
		init(context);
	}

	public UmpListViewBase(Context context, AttributeSet attrs) {
		super(context);
		init(context);
	}

	public UmpListViewBase(Context context, AttributeSet attrs, int defStyle) {
		super(context);
		init(context);
	}

	@Override
	public void setData(UmpListValue data) {
		mData.clear();
		addData(data, 0);
	}

	private void addData(UmpListValue data, int level) {
		for (int i = 0; i < data.size(); i++) {
			Map<String, ?> value = data.get(i);
			mData.add(value);
			mMapping.add(level);
			for (Object item : value.values()) {
				if (item instanceof UmpListValue) {
					addData((UmpListValue) item, level + 1);
					continue;
				}
			}
		}
	}

	private void init(Context ctx) {
		this.context = ctx;
		this.setDividerHeight(0);
		this.setCacheColorHint(Color.TRANSPARENT);
		this.setItemsCanFocus(false);
	}

	public interface ListItemView {
		View getItemView(Context ctx);
	}

	public void dataBinding() {
		this.setAdapter(new UmpListAdapter(this));
	}

	@Override
	public UmListItemViewBinder getBinder() {
		return getBinder(0);
	}

	@Override
	public UmpListValue getData() {
		return mData;
	}

	@Override
	public ListItemView getListItemView() {
		return getListItemView(0);
	}

	@Override
	public View getItemView() {
		return getListItemView().getItemView(context);
	}

	@Override
	public ListItemView getListItemView(int index) {
		return mItemView.get(index);
	}

	@Override
	public void addListItemView(ListItemView value) {
		mItemView.add(value);
	}

	@Override
	public View getItemView(int index) {
		return mItemView.get(index).getItemView(getContext());
	}

	@Override
	public UmListItemViewBinder getBinder(int index) {
		if(index<mBinder.size()) {
			return mBinder.get(index);
		}
		return null;
	}

	@Override
	public void addBinder(UmListItemViewBinder value) {
		mBinder.add(value);
	}

	@Override
	public int getLevel(int position) {
		return mMapping.get(position);
	}

}
