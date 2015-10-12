package com.yonyou.uap.um.widget;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;

import com.yonyou.uap.um.widget.UmpListViewBase.ListItemView;

public interface UmpListView {
	
	ListItemView getListItemView(int index);
	ListItemView getListItemView(); //取第0个
	void addListItemView(ListItemView value);
	View getItemView();	//取第0个
	View getItemView(int index);
	
	int getLevel(int position);
	
	UmListItemViewBinder getBinder(int index);
	UmListItemViewBinder getBinder(); //取第0个
	void addBinder(UmListItemViewBinder value);
	
	UmpListValue getData();
	void setData(UmpListValue value);
	
	Context getContext();
}
