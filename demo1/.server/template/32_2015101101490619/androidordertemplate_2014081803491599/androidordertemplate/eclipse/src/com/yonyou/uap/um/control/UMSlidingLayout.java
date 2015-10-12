package com.yonyou.uap.um.control;

import com.yonyou.uap.um.base.IViewDataBind;
import com.yonyou.uap.um.binder.IBinder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.View.OnTouchListener;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author xyy
 * @Date 2013-4-23 下午6:19:44
 * @version
 */

public class UMSlidingLayout extends RelativeLayout implements OnTouchListener, IViewDataBind {
    public enum SlidingViewType {
        MAIN, LEFT, RIGHT
    }

    private View main = null;
    private View left = null;
    private View right = null;
    private Handler handler = null;

    public UMSlidingLayout(Context context) {
        super(context);
    }

    public interface UMSlidingView {
        SlidingViewType getSlidingType();
    }

    @Override
    public void addView(View v) {
        SlidingViewType type = ((UMSlidingView) v).getSlidingType();
        if (type == SlidingViewType.MAIN) {
            this.main = v;
        } else if (type == SlidingViewType.LEFT) {
            this.left = v;
        } else {
            this.right = v;
        }
    }

    private int currentPos = 0;

    private int hideWidth = 0;

    private int getCurrentLeft() {
        return ((RelativeLayout.LayoutParams) main.getLayoutParams()).leftMargin;
    }

    public void setLayoutLeft(int x) {
        currentPos = x;
        new Thread() {
            private LinearLayout inner = (LinearLayout) UMSlidingLayout.this.main;

            public void run() {
                int c = ((RelativeLayout.LayoutParams) inner.getLayoutParams()).leftMargin;
                int obj = UMSlidingLayout.this.currentPos;
                while (c != obj) {
                    int step = c - obj;
                    if (step < 0)
                        step *= -1;
                    if (step > 2) {
                        step = (int) Math.log(step);
                    }
                    if (c < obj) {
                        c += step;
                    } else {
                        c -= step;
                    }
                    Message msg = new Message();
                    msg.arg1 = c;
                    UMSlidingLayout.this.handler.sendMessage(msg);
                }
            }
        }.start();
    }

    private void moveLayoutTo(float f) {
        if (f > 0)
            f = 0;
        RelativeLayout.LayoutParams ww = (LayoutParams) main.getLayoutParams();
        ww.leftMargin = (int) f;
        if (f < 0) {
            right.setVisibility(View.VISIBLE);
            left.setVisibility(View.GONE);
        } else {
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.GONE);
        }
        main.requestLayout();
    }

    @SuppressWarnings("unused")
    private int getLayout() {
        RelativeLayout.LayoutParams ww = (LayoutParams) main.getLayoutParams();
        return ww.leftMargin + hideWidth;
    }

    float startPos = 0;
    float startLeft = 0;
    float lastPos = 0;
    private int maxPos = 440;
    private int minPos = -440;
    private int move = 0; // 0未移动 1向左，2向右

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int what = event.getAction();
        int x = (int) event.getRawX();
        switch (what) {
        case MotionEvent.ACTION_DOWN:
            move = 0;
            startPos = x;
            startLeft = this.getCurrentLeft();
            lastPos = x;
            break;
        case MotionEvent.ACTION_MOVE:
            int step = (int) (x - lastPos);
            if (step < 0)
                step *= -1;
            if (step > 100) {
                move = x > lastPos ? 2 : 1;
            }
            if (isMove()) {
                moveLayoutTo(startLeft - (startPos - x));
            }
            break;
        case MotionEvent.ACTION_UP:
            if (isMove()) {
                float ll = startLeft - (startPos - x);
                float w = main.getLayoutParams().width / 2;
                if (ll < (w * -1)) {
                    setLayoutLeft(minPos);
                } else if (ll < w) {
                    setLayoutLeft(0);
                } else {
                    setLayoutLeft(maxPos);
                }
            }
            break;
        default:
            break;
        }
        if (v.getId() == this.main.getId())
            return true;
        return v.onTouchEvent(event);
    }

    private boolean isMove() {
        return move != 0;
    }

    @SuppressWarnings("unused")
    private String getDirection() {
        if (move == 0)
            return "NONE";
        if (move == 1)
            return "TO LEFT";
        return "TO RIGHT";
    }

    private int getCurrentWidth() {
        if (this.getLayoutParams().width < 15) {
            DisplayMetrics dm = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
            return dm.widthPixels;
        }
        return this.getLayoutParams().width;
    }

    @SuppressLint("HandlerLeak") 
    public void onInit(Bundle savedInstanceState) {
        int width = getCurrentWidth();
        main.getLayoutParams().width = width;
        maxPos = (int) (width * 0.9);
        minPos = maxPos * -1;
        main.setOnTouchListener(this);

        super.addView(left);
        super.addView(right);
        super.addView(main);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                if (!Thread.currentThread().isInterrupted()) {
                    int c = msg.arg1;
                    UMSlidingLayout.this.moveLayoutTo(c);
                }
                super.handleMessage(msg);
            }
        };
        this.moveLayoutTo(0);
    }

    @Override
    public void dataBind() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dataCollect() {
        // TODO Auto-generated method stub

    }

	@Override
	public void setBinder(IBinder binder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder getBinder() {
		// TODO Auto-generated method stub
		return null;
	}

}
