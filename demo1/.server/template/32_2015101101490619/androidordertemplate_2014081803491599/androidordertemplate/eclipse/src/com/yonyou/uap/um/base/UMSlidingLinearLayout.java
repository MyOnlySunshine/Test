package com.yonyou.uap.um.base;

import com.yonyou.uap.um.control.UMSlidingLayout.SlidingViewType;
import com.yonyou.uap.um.control.UMSlidingLayout.UMSlidingView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * sliding drawer的基本类 Project: UMP Function Description: Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xyy
 * @Date 2013-4-23 下午5:03:55
 * @version
 */

public class UMSlidingLinearLayout extends LinearLayout implements UMSlidingView {

    private SlidingViewType slidingType = SlidingViewType.MAIN;

    public UMSlidingLinearLayout(Context context) {
        super(context);
    }

    public UMSlidingLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingViewType getSlidingType() {
        return slidingType;
    }

    public void setSlidingType(SlidingViewType slidingType) {
        this.slidingType = slidingType;
    }

}
