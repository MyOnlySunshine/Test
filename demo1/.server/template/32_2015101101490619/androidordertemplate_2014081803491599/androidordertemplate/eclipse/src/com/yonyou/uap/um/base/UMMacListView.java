package com.yonyou.uap.um.base;

import com.yonyou.uap.um.binder.UMListBinder;
import com.yonyou.uap.um.util.UMCommon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author xyy
 * @Date 2013-4-25 上午8:43:54
 * @version
 */
public class UMMacListView extends UMListViewBase {

	private int line = 1;
	private int mRoundColor = Color.parseColor("#D4D4D4");

	public UMMacListView(Context context) {
		super(context);
		this.setDividerHeight(line);
	}

	protected void onDraw(Canvas canvas) {
		UMCommon.drawRound(canvas, this, mRoundColor);
	}

	@Override
	public void dataBinding(UMListBinder binder) {
		// UMListBinder binder = this.getBinder();
		int height = binder.getCount()
				* binder.getView(0, null, null).getLayoutParams().height;
		this.getLayoutParams().height = height + 2;
		super.dataBinding(binder);
	}

}
