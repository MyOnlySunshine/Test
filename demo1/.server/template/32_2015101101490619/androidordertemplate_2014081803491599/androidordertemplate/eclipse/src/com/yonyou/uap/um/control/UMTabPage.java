package com.yonyou.uap.um.control;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-4-25 上午8:45:38
 * @version
 */
public class UMTabPage extends LinearLayout {

    private String tag;
    private String indicator;
    private int initImage;
    private int selectedImage;

    public UMTabPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMTabPage(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public int getInitImage() {
        return initImage;
    }

    public void setInitImage(int initImage) {
        this.initImage = initImage;
    }

    public int getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(int selectedImage) {
        this.selectedImage = selectedImage;
    }

}
