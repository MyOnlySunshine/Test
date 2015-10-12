package com.yonyou.uap.um.control;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
//import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.yonyou.uap.um.base.IFieldsDataBind;
import com.yonyou.uap.um.base.UMTextView;
import com.yonyou.uap.um.util.BitmapUtil;

/**
 * 
 * Project: UMP Function Description:UM Button Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:16:02
 * @version
 */
public class UMButton extends UMTextView {
	private Drawable imgNormal;// 按钮被点击后显示图片id
	private Drawable imgSelected;// 按钮被点击显示图片id
	private int width;// 按钮宽度
	private int height;// 按钮高度
	private int normalColor;// 按钮的普通颜色
	private int selectedColor;// 按钮被点击后的颜色
	private boolean flagColor = false;// 按钮是否设置颜色，默认没有
	private boolean enable = true;// 按钮是否可被点击，默认可以
	private ButtonStyle style = ButtonStyle.Normal;

	public enum ButtonStyle {
		Normal, Forward, Back
	}

	public UMButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public UMButton(Context context, AttributeSet attrs) {
		super(context, attrs, android.R.attr.buttonStyle);
		// TODO Auto-generated constructor stub
	}

	public UMButton(Context context) {
		this(context, null);
		resetBackgroundImg();
		this.setTextColor(Color.WHITE);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_UP:
			if (imgNormal != null) {
				this.setBackgroundDrawable(imgNormal);
			}
			if (flagColor == true) {
				this.setBackgroundColor(normalColor);
			}
			break;
		case MotionEvent.ACTION_DOWN:
			if (imgSelected != null) {
				this.setBackgroundDrawable(imgSelected);
			}
			if (flagColor == true) {
				this.setBackgroundColor(selectedColor);
			}
			break;
		}
		return super.onTouchEvent(event);
	}

	public int getUMButtonWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getUMButtonHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setStyle(ButtonStyle style) {
		this.style = style;
		switch (style) {
		case Forward:
			this.imgNormal = BitmapUtil.getDrawableFromSrc("",
					"um_button_forward_normal.png");
			this.imgSelected = BitmapUtil.getDrawableFromSrc("",
					"um_button_forward_selected.png");
			break;
		case Back:
			this.imgNormal = BitmapUtil.getDrawableFromSrc("",
					"um_button_back_normal.png");
			this.imgSelected = BitmapUtil.getDrawableFromSrc("",
					"um_button_back_selected.png");
			break;
		default:
			break;
		}
		resetBackgroundImg();

	}

	public ButtonStyle getButtonStyle() {
		return this.style;
	}

	/**
	 * 重置背景
	 * 
	 */
	public void resetBackgroundImg() {
		if (imgNormal == null) {
			this.imgNormal = BitmapUtil.getDrawableFromSrc("",
					"um_button_default_normal.png");
		}
		if (imgSelected == null) {
			this.imgSelected = BitmapUtil.getDrawableFromSrc("",
					"um_button_default_selected.png");
		}
		this.setBackgroundDrawable(imgNormal);

	}

	/**
	 * 设置按钮的大小
	 * 
	 * @param width
	 *            ：按钮宽度
	 * @param height
	 *            ：按钮高度
	 */
	public void setUMButtonSize(int width, int height) {
		this.width = width;
		this.height = height;
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				width, height);
		this.setLayoutParams(params);
	}

	/**
	 * 设置按钮显示文本
	 * 
	 * @param text
	 */
	public void setUMButtonText(String text) {
		this.setGravity(Gravity.CENTER);
		this.setText(text);
	}

	/**
	 * 设置当前按钮的字体大小
	 * 
	 * @param size
	 */
	public void setUMButtonTextFontSize(int size) {
		this.setTextSize(size);
	}

	/**
	 * 设置当前按钮的字体颜色
	 * 
	 * @param color
	 */
	public void setUMButtonTextFontColor(int color) {
		this.setTextColor(color);
	}

	/**
	 * 返回按钮是否可见的状态
	 * 
	 * @return
	 */
	public Boolean getUMButtonVisible() {
		if (this.getVisibility() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 设置按钮是否可见
	 * 
	 * @param visible
	 */
	public void setUMButtonVisible(Boolean visible) {
		this.visible = visible;
		if (visible == true) {
			this.setVisibility(View.VISIBLE);
		} else if (visible == false) {
			this.setVisibility(View.INVISIBLE);
		}
	}

	/**
	 * 设置按钮的颜色
	 * 
	 * @param colorId
	 */
	public void setUMButtonColor(int normalColorId, int selectedColorId) {
		normalColor = normalColorId;
		selectedColor = selectedColorId;
		this.setBackgroundColor(normalColorId);
		flagColor = true;
	}

	/**
	 * 返回按钮是否可被点击的状态
	 * 
	 * @return
	 */
	public Boolean getUMButtonEnable() {
		return enable;
	}

	/**
	 * 设置按钮是否可被点击
	 * 
	 * @param enable
	 */
	public void setUMButtonEnable(Boolean enable) {
		this.enable = enable;
		if (enable == true) {
			this.setClickable(true);
		} else if (enable == false) {
			imgSelected = null;
			this.setClickable(false);
		}
	}

//	@Override
//	public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
//		super.onInitializeAccessibilityEvent(event);
//		event.setClassName(Button.class.getName());
//	}
//
//	@Override
//	public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
//		super.onInitializeAccessibilityNodeInfo(info);
//		// info.setClassName(Button.class.getName());
//	}

	public void setImageResource(int normal) {
		// TODO Auto-generated method stub
		
	}

	public void setScaleType(ScaleType fitCenter) {
		// TODO Auto-generated method stub
		
	}
}
