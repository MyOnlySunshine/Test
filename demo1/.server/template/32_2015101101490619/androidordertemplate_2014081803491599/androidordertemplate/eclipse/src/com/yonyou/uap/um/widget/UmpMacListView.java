package com.yonyou.uap.um.widget;

import com.yonyou.uap.um.base.UMListViewBase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ListAdapter;

public class UmpMacListView extends UMListViewBase {

	public UmpMacListView(Context context) {
		super(context);
	}

	protected void onDraw(Canvas canvas) {
		UmpCommon.drawRound(canvas, this, Color.BLACK);
	}

}
