package com.yonyou.uap.um.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * sliding drawer的基本类 Project: UMP Function Description: Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-23 下午5:03:55
 * @version
 */

public class UMSlidingLayout extends LinearLayout {

    private SlidingType slidingType;

    public SlidingType getSlidingType() {
        return slidingType;
    }

    public void setSlidingType(SlidingType slidingType) {
        this.slidingType = slidingType;
    }

    public enum SlidingType {
        LEFT("left"), SLIDING("sliding"), RIGHT("right");
        private SlidingType(String type) {
            this.type = type;
        }

        private final String type;

        public String getType() {
            return type;
        }
    }

    public UMSlidingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMSlidingLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

}
