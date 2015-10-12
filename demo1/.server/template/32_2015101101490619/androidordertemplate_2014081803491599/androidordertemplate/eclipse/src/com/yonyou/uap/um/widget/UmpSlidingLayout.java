package com.yonyou.uap.um.widget;

import com.yonyou.uap.um.core.IUMDataBinding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class UmpSlidingLayout extends RelativeLayout implements
		OnTouchListener, IUMDataBinding {
	public enum SlidingViewType {
		MAIN, LEFT, RIGHT
	}

	private View main = null;
	private View left = null;
	private View right = null;
	private Handler handler = null;

	private onSlidingListener onSlidingEvent = null;

	public UmpSlidingLayout(Context context) {
		super(context);
	}

	public interface UmpSlidingView {
		SlidingViewType getSlidingType();
	}

	public interface onSlidingListener {
		void onSliding(View v, int left);
	}

	public void setOnSliding(onSlidingListener event) {
		this.onSlidingEvent = event;
	}

	@Override
	public void addView(View v) {
		SlidingViewType type = ((UmpSlidingView) v).getSlidingType();
		if (type == SlidingViewType.MAIN) {
			this.main = v;
		} else if (type == SlidingViewType.LEFT) {
			this.left = v;
		} else {
			this.right = v;
		}
		/*
		 * throw new RuntimeException("No support the " +
		 * v.getClass().getName());
		 */}

	private int currentPos = 0;

	private int hideWidth = 0;

	public int getCurrentLeft() {
		return ((RelativeLayout.LayoutParams) main.getLayoutParams()).leftMargin;
	}

	public void setLayoutLeft(int x) {
		currentPos = x;
		new Thread() {
			private View inner = UmpSlidingLayout.this.main;

			public void run() {
				int c = ((RelativeLayout.LayoutParams) inner.getLayoutParams()).leftMargin;
				int obj = UmpSlidingLayout.this.currentPos;
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
					UmpSlidingLayout.this.handler.sendMessage(msg);
				}
			}
		}.start();
		if (this.onSlidingEvent != null) {
			this.onSlidingEvent.onSliding(this, x);
		}
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

	public int getMinPos() {
		return minPos;
	}

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
				lastPos = x;
			}
			if (isMove()) {
				moveLayoutTo(startLeft - (startPos - x));
			}
			Log.v("Move", "[" + getDirection() + "]" + x);
			break;
		case MotionEvent.ACTION_UP:
			Log.v("Up", "[" + getDirection() + "]" + x);
			if (isMove()) {
				if (move == 1) {
					// left
					setLayoutLeft(minPos);

				} else {
					setLayoutLeft(0);
				}
			}
			break;
		default:
			break;
		}
		/*
		 * if (isMove()) return true;
		 */
		if (v.getId() == this.main.getId())
			return true;
		return v.onTouchEvent(event);
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

	private int getCurrentWidth() {
		if (this.getLayoutParams().width < 15) {
			DisplayMetrics dm = new DisplayMetrics();
			((Activity) getContext()).getWindowManager().getDefaultDisplay()
					.getMetrics(dm);
			return dm.widthPixels;
		}
		return this.getLayoutParams().width;
	}

	private void setOnTouchEvent(ViewGroup v) {
		// v.setOnTouchListener(this);
		for (int i = 0; i < v.getChildCount(); i++) {
			View item = v.getChildAt(i);
			if (item instanceof ViewGroup) {
				setOnTouchEvent((ViewGroup) item);
			}
			item.setOnTouchListener(this);
		}
	}

	public void onInit(Bundle savedInstanceState) {
		int width = getCurrentWidth();
		main.getLayoutParams().width = width;
		maxPos = (int) (width * 0.8);
		minPos = maxPos * -1;
		main.setOnTouchListener(this);
		if (main instanceof ViewGroup) {
			setOnTouchEvent((ViewGroup) main);
		}
		// if(main instanceof UmpSlidingLinearLayout) {
		// UmpSlidingLinearLayout usll = (UmpSlidingLinearLayout) main;
		// for(int i=0;i<usll.getChildCount();i++) {
		// View v = usll.getChildAt(i);
		// if(v instanceof ViewGroup) {
		//
		// }
		// }
		// }

		if (left == null) {
			left = new LinearLayout(getContext());
			left.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}
		super.addView(left);
		if (right == null) {
			right = new LinearLayout(getContext());
			right.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}
		super.addView(right);
		if (main == null)
			throw new Error("main view is null.");
		super.addView(main);
		// activity.findViewById(R.id.lstCustomerList).setOnTouchListener(this);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {

				if (!Thread.currentThread().isInterrupted()) {
					int c = msg.arg1;
					UmpSlidingLayout.this.moveLayoutTo(c);
				}
				super.handleMessage(msg);
			}
		};
		this.moveLayoutTo(0);
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDatabinding() {
		// TODO Auto-generated method stub

	}

}
