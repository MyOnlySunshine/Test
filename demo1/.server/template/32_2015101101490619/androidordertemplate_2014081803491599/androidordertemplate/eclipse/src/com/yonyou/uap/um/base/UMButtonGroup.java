package com.yonyou.uap.um.base;

import java.util.ArrayList;
import java.util.List;

import com.yonyou.uap.um.control.UMSwitchButton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

/**
 * 
 * Project: UMP Function Description:LinearLayout鏀剧疆澶氫釜鍥剧墖锛岃嚜鍔ㄥ竷灞€ Company:
 * UFIDA Inc. UAP Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-26 涓嬪崍1:48:10
 * @version
 */

public class UMButtonGroup extends LinearLayout {

	public interface OnTabClickListener {
		void onClick(View v, int position);
	}

	public UMButtonGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public UMButtonGroup(Context context) {
		super(context);
	}

	private List<IUMSwitchButton> views = new ArrayList<IUMSwitchButton>();

	private UMButtonGroupStyle mStyle = UMButtonGroupStyle.SINGLE;

	@Override
	public void addView(View child) {
		// TODO Auto-generated method stub
		if (!(child instanceof IUMSwitchButton)) {
			throw new RuntimeException("不能添加未实现接口"
					+ IUMSwitchButton.class.getName() + "的视图");
		}
		LinearLayout.LayoutParams layout = this.getOrientation() == LinearLayout.HORIZONTAL ? new LinearLayout.LayoutParams(
				0, ViewGroup.LayoutParams.MATCH_PARENT)
				: new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT, 0);
		layout.weight = 1;
		child.setLayoutParams(layout);
		child.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				UMButtonGroup.this.onTabClick(v);
			}
		});
		((UMSwitchButton)child).setScaleType(ScaleType.FIT_XY);

		super.addView(child);
		views.add((IUMSwitchButton) child);
	}

	private OnTabClickListener ontabclick = null;

	private void onTabClick(View v) {
		if (mStyle == UMButtonGroupStyle.SINGLE) {
			for (IUMSwitchButton item : views) {
				item.off();
			}
			((IUMSwitchButton) v).on();
		} else {
			((IUMSwitchButton) v).switch_();
		}
		if (ontabclick != null) {
			int position = views.indexOf(v);
			ontabclick.onClick(v, position);
		}
	}

	public void setStyle(UMButtonGroupStyle style) {
		mStyle = style;
	}

	public int getSelectedButton() {
		for (int i = 0; i < views.size(); i++) {
			if (views.get(i).isOn()) {
				return i;
			}
		}
		return -1;
	}
}