package com.yonyou.uap.um.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

public class UmpTab extends TabHost {

	public UmpTab(Context context) {
		super(context);
		
		TabWidget w = new TabWidget(context);
		w.setId(android.R.id.tabs);
		
		FrameLayout frame = new FrameLayout(context);
		frame.setId(android.R.id.tabcontent);
		
		
		
		this.addView(frame);
		this.addView(w);
		
	}
	
	public void addTab(View tab, int icon, int selectIcon) {
		
		;
	}
	
	public void setPosition() {
		
	}
	
	
	
	
	
	

}
