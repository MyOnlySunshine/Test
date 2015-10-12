package com.yonyou.uap.um.widget;

import java.util.ArrayList;
import java.util.Map;
import android.content.Context;

public class Ump2ListView extends UmpListViewBase {

	protected ArrayList<ListItemView> pitemView = new ArrayList<ListItemView>();
	protected ArrayList<UmListItemViewBinder> pbinder = new ArrayList<UmListItemViewBinder>();
	protected ArrayList<Integer> mMapping = new ArrayList<Integer>(); //参数2：0表示叶子，1表示1级
	
	public Ump2ListView(Context context) {
		super(context);
	}
	
	@Override
	public void setData(UmpListValue data) {
		mData.clear();
		addData(data,0);
	}
	
	private void addData(UmpListValue data, int level) {
		for(int i=0;i<data.size();i++) {
			Map<String,?> value = data.get(i);
			for(Object item:value.values()) {
				if(item instanceof UmpListValue) {
					addData((UmpListValue) item,level+1);
					continue;
				}
			}
			mData.add(value);
			mMapping.add(level);
		}
	}
	
	@Override
	public void dataBinding() {
		this.setAdapter(new Ump2ListAdapter(this));
	}

}
