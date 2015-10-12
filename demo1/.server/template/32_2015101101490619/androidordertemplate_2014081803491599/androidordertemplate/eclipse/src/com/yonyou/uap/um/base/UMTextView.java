package com.yonyou.uap.um.base;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 * Project: UMP Function Description:UMTextView Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:54:16
 * @version
 */
public class UMTextView extends TextView {

    public int id;
    public String type;
    public Object element;
    public boolean display;
    public boolean visible;
    public boolean enabled;
    public String height;
    public String width;

    private String text;// 显示的文本

    /**
     * 设置textview的字体颜色
     */
    public void setUMTextViewTextColor(int color) {
        this.setTextColor(color);
    }

    /**
     * 设置显示的内容
     * 
     * @param title
     */
    public void setUMTextViewText(String title) {
        text = title;
        super.setText(title);
    }

    /**
     * 获取textview上的内容
     * 
     * @return
     */
    public String getUMTextViewText() {
        return text;
    }

    /**
     * 设置textview上的文本大小
     * 
     * @param size
     */
    public void setUMTextViewTextSize(float size) {
        this.setTextSize(size);
    }

    /**
     * 设置textview上的文本字体
     * 
     * @param boldItalic
     */
    public void setUMTextViewFont(Typeface bold) {
        this.setTypeface(bold);
    }

    public UMTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public UMTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

}
