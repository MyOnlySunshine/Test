/*package com.yonyou.uap.um.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.yonyou.uap.um.control.UMCheckbox;
import com.yonyou.uap.um.widget.R;

public class UMCheckboxTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(1);
		setContentView(layout);

		UMCheckbox umCheckbox1 = new UMCheckbox(this);
		UMCheckbox umCheckbox2 = new UMCheckbox(this);
		UMCheckbox umCheckbox3 = new UMCheckbox(this);
		UMCheckbox umCheckbox4 = new UMCheckbox(this);
		UMCheckbox umCheckbox5 = new UMCheckbox(this);

		// 设置多选框的文本提示
		umCheckbox1.setUMCheckboxLabelText("菠萝");
		umCheckbox2.setUMCheckboxLabelText("芒果");
		umCheckbox3.setUMCheckboxLabelText("橙子");
		umCheckbox4.setUMCheckboxLabelText("柠檬");
		umCheckbox5.setUMCheckboxLabelText("草莓");

		// 设置第一个多选为只读的
		umCheckbox1.setUMCheckboxReadOnly(true);
		// 设置第二个多选不可见
		umCheckbox2.setUMCheckboxVisible(false);
		// 设置第三个按钮一开始就被选中
		umCheckbox3.setUMCheckboxSelected(true);
		// 设置第四个多选框的按钮图片
		umCheckbox4.setUMCheckboxButton(R.drawable.ump_animate1,
				R.drawable.ump_animate2);
		// 给第5个多选添加背景图片
		umCheckbox5.setUMCheckboxBackgroundImg(
				R.drawable.demolist_checkbox_normal,
				R.drawable.demolist_checkbox_selected);
		
		// 加入到view中
		layout.addView(umCheckbox1);
		layout.addView(umCheckbox2);
		layout.addView(umCheckbox3);
		layout.addView(umCheckbox4);
		layout.addView(umCheckbox5);
	}

}
*/