package com.yonyou.uap.um.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

import com.yonyou.uap.um.binder.IBinder;
import com.yonyou.uap.um.binder.IBinderGroup;
import com.yonyou.uap.um.binder.SimpleBinderGroup;
import com.yonyou.uap.um.binder.UMListBinder;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author xyy
 * @Date 2013-4-25 上午8:43:42
 * @version
 */
public class UMListViewBase extends ListView implements IUMListView {

	protected ArrayList<ListItemView> mItemView = new ArrayList<ListItemView>();
	protected Map<Integer, ListItemView> mItemViewExtend = new HashMap<Integer, ListItemView>();
	protected ArrayList<IUMListItemViewBinder> mItemViewBinder = new ArrayList<IUMListItemViewBinder>();
	protected ArrayList<Integer> mMapping = new ArrayList<Integer>(); // 参数2：0表示叶子，1表示1级
	protected UMListValue mData = null;
	protected Context context;
	protected UMListBinder mBinder = null;

	public UMListViewBase(Context context) {
		super(context);
		init(context);
	}

	public UMListViewBase(Context context, AttributeSet attrs) {
		super(context);
		init(context);
	}

	public UMListViewBase(Context context, AttributeSet attrs, int defStyle) {
		super(context);
		init(context);
	}

	private void init(Context ctx) {
		this.context = ctx;
		this.setDividerHeight(0);
		this.setCacheColorHint(Color.TRANSPARENT);
		this.setItemsCanFocus(false);
	}

	public UMListBinder getBinder() {
		return mBinder;
	}

	public void setBinder(UMListBinder binder) {
		this.mBinder = binder;
	}

	public interface ListItemView {
		View getItemView(Context ctx, View parent, IBinderGroup binderGroup);
	}

	public void dataBinding(UMListBinder binder) {
//		IBinder binder = getBinder();
//		if (binder != null) {
//			binder.dataBinding();
//		}
//		this.requestLayout();
	}

	@Override
	public IUMListItemViewBinder getItemViewBinder() {
		return getItemViewBinder(0);
	}

	@Override
	public ListItemView getListItemView() {
		return getListItemView(0);
	}

	@Override
	public View getItemView(IBinderGroup group) {
		return getListItemView().getItemView(context, null, group);
	}

	@Override
	public ListItemView getListItemView(int index) {
		return mItemView.get(index);
	}

	@Override
	public void addListItemView(ListItemView value) {
		mItemView.add(value);
	}

	public void addListItemViewExtend(int index, ListItemView value) {
		mItemViewExtend.put(index, value);
	}

	@Override
	public View getItemView(int index, IBinderGroup group) {
		View v = mItemView.get(index).getItemView(getContext(), null, group);
		ListItemView itemV = getListItemViewExtend(index);
		if (itemV != null) {
			v = itemV.getItemView(getContext(), v, group);
		}
		return v;
	}

	public ListItemView getListItemViewExtend(int index) {
		return mItemViewExtend.get(index);
	}

	@Override
	public IUMListItemViewBinder getItemViewBinder(int index) {
		if (index < mItemViewBinder.size()) {
			return mItemViewBinder.get(index);
		}
		return null;
	}

	@Override
	public void addItemViewBinder(IUMListItemViewBinder value) {
		mItemViewBinder.add(value);
	}

	@Override
	public int getLevel(int position) {
		return mMapping.get(position);
	}

}
