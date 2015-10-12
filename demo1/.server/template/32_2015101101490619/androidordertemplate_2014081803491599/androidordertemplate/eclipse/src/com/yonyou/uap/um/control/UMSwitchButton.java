package com.yonyou.uap.um.control;

import com.yonyou.uap.um.base.IUMSwitchButton;
import com.yonyou.uap.um.control.UMSwitchListener;
import android.content.Context;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class UMSwitchButton extends ImageView implements IUMSwitchButton, OnClickListener {

	private int onImage = android.R.drawable.btn_star_big_on;
	private int offImage = android.R.drawable.btn_star_big_off;

	private boolean mIsOn = true;

	private UMSwitchListener mSwitchOn = null;
	private UMSwitchListener mSwitchOff = null;

	public UMSwitchButton(Context context) {
		super(context);
		//this.setScaleType(ScaleType.FIT_XY);
		this.setOnClickListener(this);
	}

	public void setSwitchOn(UMSwitchListener switchlistener) {
		this.mSwitchOn = switchlistener;
	}
	
	public void setSwitchOff(UMSwitchListener switchlistener) {
		this.mSwitchOff = switchlistener;
	}

	@Override
	public void on() {
		mIsOn = true;
		if (this.mSwitchOn != null) {
			this.mSwitchOn.onSwitch(this);
		}
		refreshImageResource();
	}

	@Override
	public void switch_() {
		if (mIsOn)
			off();
		else
			on();
	}

	@Override
	public void off() {
		mIsOn = false;
		if (this.mSwitchOff != null) {
			this.mSwitchOff.onSwitch(this);
		}
		refreshImageResource();
	}

	private void refreshImageResource() {
		if (mIsOn) {
			this.setImageResource(onImage);
		} else {
			this.setImageResource(offImage);
		}
	}

	@Override
	public void setOnImageResource(int res) {
		onImage = res;
	}

	@Override
	public void setOffImageResource(int res) {
		offImage = res;
	}

	@Override
	public boolean isOn() {
		return mIsOn;
	}

	@Override
	public void onClick(View v) {
		switch_();
	}

}
