package com.yonyou.uap.um.util;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

/**
 * 
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author xyy
 * @Date 2013-4-25 上午8:46:17
 * @version
 */
public class UMCommon {

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
        // p.setColor(Color.argb(255, 0, 255, 0));
        float x = 0 + line / 2;
        float y = 0 + line;
        float w = view.getWidth() - line / 2;
        float h = view.getHeight() - line;

        // canvas.drawLine(x, y, w, h, p);
        // this.setBackgroundResource(R.drawable.c1);
        canvas.drawRoundRect(new RectF(x, y, w, h), r, r, p);
    }

}
