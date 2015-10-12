package com.yonyou.uap.um.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundLinearLayout extends LinearLayout {
	
	private int mRoundColor = Color.parseColor("#D4D4D4");

	public RoundLinearLayout(Context context) {
		super(context);
		setWillNotDraw(false);
	}

	public RoundLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setWillNotDraw(false);
	}
	
	
	public int getRoundColor() {
		return mRoundColor;
	}

	public void setRoundColor(int roundColor) {
		this.mRoundColor = roundColor;
	}
	
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		UmpCommon.drawRound(canvas, this, mRoundColor);
	}
}
