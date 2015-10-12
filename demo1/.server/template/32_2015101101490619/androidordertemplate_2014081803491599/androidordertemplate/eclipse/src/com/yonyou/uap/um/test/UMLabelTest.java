package com.yonyou.uap.um.test;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.yonyou.uap.um.control.UMLabel;

public class UMLabelTest extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		//ll.setGravity(1);
		setContentView(layout);
		
		//创建一个UMLabel对象
		UMLabel umLabel = new UMLabel(this);
		//设置label上显示的文本内容
		umLabel.setUMLabelText("第一个UMLabel测试");
		//设置label上文本的颜色，设为红色
		umLabel.setUMLabelTextColor(Color.RED);
		//设置label上的文本字体
		umLabel.setUMLabelFont(Typeface.MONOSPACE);
		//设置label上的文本大小为30
		umLabel.setUMLabelTextSize(30);
		//加入view中
		layout.addView(umLabel);
	}

}
