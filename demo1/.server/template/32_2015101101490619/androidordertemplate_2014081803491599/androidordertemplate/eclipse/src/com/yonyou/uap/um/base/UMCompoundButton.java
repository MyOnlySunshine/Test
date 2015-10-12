package com.yonyou.uap.um.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
//import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午10:09:27
 * @version
 */
public class UMCompoundButton extends CompoundButton {

    public int id;
    public String type;
    public Object element;
    public boolean display;
    public boolean visible;
    public boolean enabled;
    public String height;
    public String width;

    public UMCompoundButton(Context context) {
        this(context, null);
    }

    public UMCompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.checkboxStyle);
    }

    public UMCompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @Override
//    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
//        super.onInitializeAccessibilityEvent(event);
//        event.setClassName(CheckBox.class.getName());
//    }
//
//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @Override
//    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
//        super.onInitializeAccessibilityNodeInfo(info);
//        info.setClassName(CheckBox.class.getName());
//    }

}
