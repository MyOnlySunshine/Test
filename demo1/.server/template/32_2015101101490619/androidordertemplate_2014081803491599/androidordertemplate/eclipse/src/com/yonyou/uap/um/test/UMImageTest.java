package com.yonyou.uap.um.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.yonyou.uap.um.control.UMImage;

public class UMImageTest extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		setContentView(ll);
		
		//定义一个UMImage新对象
		UMImage umImage1 = new UMImage(this);
		//设置该图片的大小为50*50
		umImage1.setUMImageSize(50, 50);
		//设置该图片的背景资源显示
		umImage1.setUMImage(android.R.drawable.btn_star);
		//设置该图片是否可见，此处设为可见
		umImage1.setUMImageVisible(true);
		//将图片加进view中
		ll.addView(umImage1);
		
		UMImage umImage2 = new UMImage(this);
		umImage2.setUMImage(android.R.drawable.btn_radio);
		//设为不可见
		umImage2.setUMImageVisible(false);
		ll.addView(umImage2);
	}

}
