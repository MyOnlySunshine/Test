package com.yonyou.uap.um.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.view.View;

public class UmpCommon {

	public static void drawRound(Canvas canvas, View view) {
		drawRound(canvas, view, Color.argb(99, 253, 253, 253));
	}
	
	public static void drawRound(Canvas canvas, View view, int color) {
		int line = 2;
		int r = 10;
		
		Paint p = new Paint();
		
		p.setStyle(Style.STROKE);
		p.setAntiAlias(true);
		p.setColor(color);
		
		drawRound(canvas, view, line, r, p);
	}
	
	public static void drawRound(Canvas canvas, View view, int line, int r, Paint p) {

		p.setStrokeWidth(line);
		//p.setColor(Color.argb(255, 0, 255, 0));
		float x = 0 + line/2;
		float y = 0 + line;
		float w = view.getWidth() - line/2;
		float h = view.getHeight() - line;

		//canvas.drawLine(x, y, w, h, p);
		//this.setBackgroundResource(R.drawable.c1);
		canvas.drawRoundRect(new RectF(x,y,w,h), r, r, p);
	}
}
