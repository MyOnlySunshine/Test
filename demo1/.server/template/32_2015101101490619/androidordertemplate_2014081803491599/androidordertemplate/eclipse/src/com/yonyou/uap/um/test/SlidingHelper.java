package com.yonyou.uap.um.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint("HandlerLeak") 
public class SlidingHelper implements OnTouchListener {

    private Activity activity = null;
    private LinearLayout sliding = null;
    private LinearLayout left = null;
    private LinearLayout right = null;
    private Handler handler = null;

    public SlidingHelper(Activity a, LinearLayout s, LinearLayout l,
            LinearLayout r) {
        this.activity = a;
        this.sliding = s;
        this.left = l;
        this.right = r;
    }

    private int currentPos = 0;

    private int hideWidth = 0;

    private int getCurrentLeft() {
        return ((RelativeLayout.LayoutParams) sliding.getLayoutParams()).leftMargin;
    }

    public void setLayoutLeft(int x) {
        currentPos = x;
        new Thread() {
            private LinearLayout inner = (LinearLayout) SlidingHelper.this.sliding;

            public void run() {
                int c = ((RelativeLayout.LayoutParams) inner.getLayoutParams()).leftMargin;
                int obj = SlidingHelper.this.currentPos;
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
                    SlidingHelper.this.handler.sendMessage(msg);
                }
            }
        }.start();
    }

    private void moveLayoutTo(float f) {
        RelativeLayout.LayoutParams ww = (LayoutParams) sliding
                .getLayoutParams();
        ww.leftMargin = (int) f;
        if (f < 0) {
            right.setVisibility(View.VISIBLE);
            left.setVisibility(View.GONE);
        } else {
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.GONE);
        }
        sliding.requestLayout();
    }

    @SuppressWarnings("unused")
    private int getLayout() {
        RelativeLayout.LayoutParams ww = (LayoutParams) sliding
                .getLayoutParams();
        return ww.leftMargin + hideWidth;
    }

    float startPos = 0;
    float startLeft = 0;
    float lastPos = 0;
    private int maxPos = 440;
    private int minPos = -440;
    private int move = 0; // 0鏈Щ鍔�1鍚戝乏锛�鍚戝彸

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
            Log.v("Down", "[" + getDirection() + "]" + x);
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
            Log.v("Move", "[" + getDirection() + "]" + x);
            break;
        case MotionEvent.ACTION_UP:
            Log.v("Up", "[" + getDirection() + "]" + x);
            if(isMove()) {
                float ll = startLeft - (startPos - x);
                float w = sliding.getLayoutParams().width/2;
                if(ll<(w*-1)) {
                    setLayoutLeft(minPos);
                } else if(ll<w) {
                    setLayoutLeft(0);
                } else {
                    setLayoutLeft(maxPos);
                }
            }
            // if (isMove()) {
            //
            // if (x < 200) {
            // setLayoutLeft(0);
            // } else {
            // setLayoutLeft(maxPos);
            // }
            // }
            break;
        default:
            break;
        }
        /*
         * if (isMove()) return true;
         */return true;
    }

    private boolean isMove() {
        return move != 0;
    }

    private String getDirection() {
        if (move == 0)
            return "NONE";
        if (move == 1)
            return "TO LEFT";
        return "TO RIGHT";
    }


    public void onInit(Bundle savedInstanceState) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        sliding.getLayoutParams().width = dm.widthPixels + hideWidth;
        maxPos = (int) (dm.widthPixels * 0.9);
        minPos = maxPos*-1;
        sliding.setOnTouchListener(this);
        // activity.findViewById(R.id.lstCustomerList).setOnTouchListener(this);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                if (!Thread.currentThread().isInterrupted()) {
                    int c = msg.arg1;
                    SlidingHelper.this.moveLayoutTo(c);
                }
                super.handleMessage(msg);
            }
        };
        this.moveLayoutTo(0);
    }

}
