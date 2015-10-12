package com.yonyou.uap.um.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 
 * Project: UMP Function Description:UMImageView Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:52:57
 * @version
 */
public class UMImageView extends ImageView {

    public int id;
    public String type;
    public Object element;
    public boolean display;
    public boolean visible;
    public boolean enabled;
    public String height;
    public String width;

    public UMImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public UMImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

}
