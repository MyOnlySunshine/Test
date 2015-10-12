package com.yonyou.uap.um.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.yonyou.uap.um.control.UMButton;
import com.yonyou.uap.um.control.UMButton.ButtonStyle;

public class UMButtonTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        
        layout.setBackgroundColor(Color.RED);
        layout.setOrientation(LinearLayout.VERTICAL);
       
        setContentView(layout);
        
        
        UMButton umButton = new UMButton(this);
        umButton.setText("按钮");
        umButton.setPadding(50, 0, 50, 50);
        
        
        

        UMButton umButton2 = new UMButton(this);
        umButton2.setText("返回");
        umButton2.setStyle(ButtonStyle.Back);
        umButton2.setUMButtonSize(100, 100);
        umButton2.setPadding(100, 220, 0, 0);

        UMButton umButton3 = new UMButton(this);
        umButton3.setText("向前");
        umButton3.setStyle(ButtonStyle.Forward);
        umButton3.setUMButtonSize(100, 100);
        umButton3.setPadding(100, 320, 0, 0);
        
        layout.addView(umButton);
//        layout.addView(umButton2);
//        layout.addView(umButton3);

        // umButton.setStyle(ButtonStyle.Forward);

        // 设置按钮的点击与未点击时的图片背景
        // umButton.addUMButtonBackgroundImg(R.drawable.toolbar_date_normal,
        // R.drawable.toolbar_date_selected);
        // 按钮的大小为长70，高50
        // umButton.setUMButtonSize(70,50);
        // 按钮显示的内容为demo
        // umButton.setUMButtonText("demo");
        // 按钮的文本内容的字体大小为15pix
        // umButton.setUMButtonTextFontSize(15);
        // 按钮的文本颜色，设为白色
        // umButton.setUMButtonTextFontColor(Color.WHITE);

        // 设置按钮是否可见，此处设为不可见false，可见为true
        // umButton.setUMButtonVisible(false);
        // 设置按钮的默认颜色以及点击颜色
        // umButton.setUMButtonColor(Color.GREEN,Color.GRAY);
        // 设置按钮可否被点击，此处设置不能
        // umButton.setUMButtonEnable(false);
        // 将按钮添加到这个相对布局ll中


    }

}
