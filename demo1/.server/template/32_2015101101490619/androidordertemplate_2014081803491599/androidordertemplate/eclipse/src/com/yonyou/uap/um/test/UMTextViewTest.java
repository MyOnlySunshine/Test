package com.yonyou.uap.um.test;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.yonyou.uap.um.base.UMTextView;

public class UMTextViewTest extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		
		UMTextView umTextview = new UMTextView(this);
		//设置显示内容
		umTextview.setUMTextViewText("第一个text测试");
		//设置颜色为蓝色
		umTextview.setUMTextViewTextColor(Color.BLUE);
		//设置字体大小为45
		umTextview.setUMTextViewTextSize(45);
		//设置字体
		umTextview.setUMTextViewFont(Typeface.DEFAULT_BOLD);
		//加入到view中
		layout.addView(umTextview);
	}

}
