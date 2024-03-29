package com.yonyou.uap.um.widget;

import java.util.ArrayList;

import com.yonyou.uap.um.widget.UmpSlidingLayout.SlidingViewType;
import com.yonyou.uap.um.widget.UmpSlidingLayout.UmpSlidingView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class UmpSlidingRelativeLayout extends RelativeLayout implements
		UmpSlidingView {

	private SlidingViewType slidingType = SlidingViewType.MAIN;

	private ArrayList<View> mViews = new ArrayList<View>();

	public UmpSlidingRelativeLayout(Context context) {
		super(context);
	}

	public UmpSlidingRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SlidingViewType getSlidingType() {
		return slidingType;
	}

	public void setSlidingType(SlidingViewType slidingType) {
		this.slidingType = slidingType;
	}

	@Override
	public void addView(View v) {
		mViews.add(v);
		super.addView(v);
	}

	public void init(UmpSlidingLayout umpSlidingLayout) {
		for (View item : mViews) {
			item.setOnTouchListener(umpSlidingLayout);
		}
	}

}
