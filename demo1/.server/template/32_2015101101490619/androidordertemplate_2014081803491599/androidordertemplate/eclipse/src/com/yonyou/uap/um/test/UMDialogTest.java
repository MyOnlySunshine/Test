package com.yonyou.uap.um.test;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yonyou.uap.um.control.UMAlertDialog;
import com.yonyou.uap.um.control.UMButton;

public class UMDialogTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        setContentView(layout);

        UMButton button = new UMButton(this);
        layout.addView(button);

        button.setUMButtonText("test");
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                UMAlertDialog umDialog = new UMAlertDialog(UMDialogTest.this);
                // 设置titie
                umDialog.setUMAlertDialogTitle("请选择：");
                // 设置icon
                umDialog.setUMAlertDialogIcon(android.R.drawable.ic_menu_directions);

                // 添加内容
                final String[] arrayCheckoutShow = new String[] { "打电话", "发短信","SOS" };
                umDialog.addUMAlertDialogItems(arrayCheckoutShow, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        if (which == 0) {
                            // 加入触发事件
                            Toast.makeText(UMDialogTest.this, "打电话！", Toast.LENGTH_LONG).show();
                        } else if (which == 1) {
                            // 加入触发事件
                            Toast.makeText(UMDialogTest.this, "发短信！", Toast.LENGTH_LONG).show();
                        }else if (which == 2) {
                            // 加入触发事件
                            Toast.makeText(UMDialogTest.this, "Help！！！", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                // 添加按钮
                umDialog.addUMAlertDialogButton(2, "取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        // 加入触发事件
                        Toast.makeText(UMDialogTest.this, "关闭Dialog！", Toast.LENGTH_LONG).show();
                    }
                });
                umDialog.addUMAlertDialogButton(0, "进入", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        // 加入触发事件
                        Toast.makeText(UMDialogTest.this, "进入！", Toast.LENGTH_LONG).show();
                    }
                });

                // 建立这个dialog
                umDialog.create();
                // 显示它
                umDialog.show();
            }
        });

    }

}
