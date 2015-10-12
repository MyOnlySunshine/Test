package com.yonyou.uap.um.test;

import com.yonyou.uap.um.base.UMSlidingLinearLayout;
import com.yonyou.uap.um.control.UMSlidingLayout;
import com.yonyou.uap.um.control.UMSlidingLayout.SlidingViewType;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class UMSlidingDrawerTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UMSlidingLayout umSlidingLayout = new UMSlidingLayout(this);

        UMSlidingLinearLayout left = new UMSlidingLinearLayout(this);
        left.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        left.setBackgroundColor(Color.BLUE);
        left.setSlidingType(SlidingViewType.LEFT);
        umSlidingLayout.addView(left);

        UMSlidingLinearLayout right = new UMSlidingLinearLayout(this);
        right.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        right.setBackgroundColor(Color.GREEN);
        right.setSlidingType(SlidingViewType.RIGHT);
        umSlidingLayout.addView(right);

        UMSlidingLinearLayout main = new UMSlidingLinearLayout(this);
        main.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        main.setBackgroundColor(Color.RED);
        main.setSlidingType(SlidingViewType.MAIN);// sliding需要最后加入才能显示

        umSlidingLayout.addView(main);
        this.setContentView(umSlidingLayout);

    }
}

