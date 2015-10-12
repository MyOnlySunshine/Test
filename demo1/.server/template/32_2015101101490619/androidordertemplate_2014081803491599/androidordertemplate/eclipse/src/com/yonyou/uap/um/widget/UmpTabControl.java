package com.yonyou.uap.um.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

public class UmpTabControl extends TabHost {

	private FrameLayout frameLayout;
	private TabWidget tabWidget;
	private int positionTag; // tabwidget默认为bottom
	private List<TabSpec> tabSpecs = new ArrayList<TabSpec>();
	private Resources resource;
	
	
	public UmpTabControl(Context context) {
		this(context, 1);
	}

	public UmpTabControl(Context context, int positionTag) {
		super(context, null);
		resource = context.getResources();
		if (positionTag < 0) {
			this.positionTag = 0;
		} else {
			this.positionTag = positionTag;
		}
		// set tabhost layout
		FrameLayout.LayoutParams tabHostLayoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);
		this.setLayoutParams(tabHostLayoutParams);
		// set tabcontent framelayout
		this.frameLayout = new FrameLayout(context);
		frameLayout.setId(android.R.id.tabcontent);
		FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);
		// set relative layout
		RelativeLayout relativeLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		// set tabWidget
		tabWidget = new TabWidget(context);
		tabWidget.setId(android.R.id.tabs);
		//tabWidget.setDividerPadding(0);
		tabWidget.setBackgroundColor(Color.TRANSPARENT);
//		tabWidget.set
		RelativeLayout.LayoutParams tabWidgetLayoutParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT, 66);
		if (this.positionTag == 0) {
			frameLayoutParams.topMargin = 0;
			relativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			tabWidgetLayoutParams.setMargins(0, 0, 0, 0);
			tabWidgetLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		} else {
			frameLayoutParams.topMargin = 66;
			relativeLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
			tabWidgetLayoutParams.setMargins(0, 0, 0, 0);
			tabWidgetLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		}
//		tabWidgetLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//		tabWidgetLayoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		frameLayout.setLayoutParams(frameLayoutParams);
		relativeLayout.setLayoutParams(relativeLayoutParams);
		tabWidget.setLayoutParams(tabWidgetLayoutParams);
		// add view
		relativeLayout.addView(tabWidget);
		this.addView(frameLayout);
		this.addView(relativeLayout);

	}

	public UmpTabControl(Context context, AttributeSet attrs) {
		super(context, attrs);

		// TODO Auto-generated constructor stub
	}

	public void addUMTabSpec(View view, String tag, String tabIndicator,
			Drawable tabInitImg, Drawable tabSelectedImg) {
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);
		this.frameLayout.addView(view, layoutParams);
		TabSpec tabSpec = this.newTabSpec(tag);
		StateListDrawable stateListDrawable = new StateListDrawable();
		stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET,
				tabSelectedImg);
		stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET,
				tabSelectedImg);
		stateListDrawable.addState(View.FOCUSED_STATE_SET, tabSelectedImg);
		stateListDrawable.addState(View.SELECTED_STATE_SET, tabSelectedImg);
		stateListDrawable.addState(View.ENABLED_STATE_SET, tabInitImg);
		ImageView vv = new ImageView(this.getContext());
		vv.setImageDrawable(stateListDrawable);
		vv.setScaleType(ScaleType.FIT_XY);
		//tabSpec.setIndicator(tabIndicator, stateListDrawable);
		tabSpec.setIndicator(vv);
		tabSpec.setContent(view.getId());
		this.addTab(tabSpec);
		tabSpecs.add(tabSpec);
	}

	public void addView(View view) {
		if (view instanceof UmpTabPage) {
			UmpTabPage page = (UmpTabPage) view;
			this.addUMTabSpec(view, page.getTag(), page.getText(),
					page.getImageObject(resource),
					page.getSelectedImageObject(resource));
		} else {
			super.addView(view);
		}
	}

	public FrameLayout getFrameLayout() {
		return frameLayout;
	}

	public void setFrameLayout(FrameLayout frameLayout) {
		this.frameLayout = frameLayout;
	}

	public TabWidget getTabWidget() {
		return tabWidget;
	}

	public void setTabWidget(TabWidget tabWidget) {
		this.tabWidget = tabWidget;
	}

	public int getPositionTag() {
		return positionTag;
	}

	public List<TabSpec> getTabSpecs() {
		return tabSpecs;
	}

	public void setTabSpecs(List<TabSpec> tabSpecs) {
		this.tabSpecs = tabSpecs;
	}

	public void dataBind() {
		// TODO Auto-generated method stub

	}

	public void dataCollect() {
		// TODO Auto-generated method stub

	}

}