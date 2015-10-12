package com.yonyou.uap.um.control;

import java.util.HashMap;

import com.yonyou.uap.um.base.OnEventListener;
import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.util.BitmapUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * UMLogin Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013 UFIDA Inc. All
 * rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-24 上午10:00:32
 * @version
 */

public class UMLogin extends LinearLayout {
    public static final String ON_LOGIN = "onlogin";
    private UMTextbox nameTextbox;
    private UMTextbox passTextbox;
    private UMLabel label;
    private UMImage loginImage;
    private LinearLayout upLayout;

    public UMLogin(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("deprecation")
    public UMLogin(Context context) {
        super(context);
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int height = dm.heightPixels;
        int width = dm.widthPixels;

        this.setOrientation(LinearLayout.VERTICAL);
        this.setBackgroundColor(Color.parseColor("#E6E6E6"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        layoutParams.gravity = Gravity.CENTER;
        this.setLayoutParams(layoutParams);

        int upWidth = width * 8 / 10;
        int upHeight = height * 1 / 5;

        upLayout = new LinearLayout(context);
        upLayout.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_login_textbackgroup.png"));
        upLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams upLayoutParams = new LinearLayout.LayoutParams(upWidth, upHeight);
        upLayoutParams.gravity = Gravity.CENTER;
        upLayoutParams.topMargin = 30;
        upLayout.setLayoutParams(upLayoutParams);

        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(upWidth * 2 / 3, upHeight / 2);
        textLayoutParams.leftMargin = 30;
        nameTextbox = new UMTextbox(context);
        nameTextbox.setHint("用户名");

        nameTextbox.setSingleLine();
        nameTextbox.setInputType(InputType.TYPE_CLASS_TEXT);
        nameTextbox.setBackgroundDrawable(null);

        upLayout.addView(nameTextbox, textLayoutParams);

        passTextbox = new UMTextbox(context);

        passTextbox.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        passTextbox.setHint("密码");
        passTextbox.setSingleLine();
        passTextbox.setInputType(InputType.TYPE_CLASS_TEXT);
        passTextbox.setBackgroundDrawable(null);
        upLayout.addView(passTextbox, textLayoutParams);

        label = new UMLabel(context);
        label.setText("请输入用户名和密码！");
        label.setTextColor(Color.BLUE);
        LinearLayout.LayoutParams labelLayoutParams = new LinearLayout.LayoutParams(upWidth, upHeight / 4);
        labelLayoutParams.gravity = Gravity.CENTER;
        labelLayoutParams.topMargin = 10;
        label.setLayoutParams(labelLayoutParams);

        LinearLayout.LayoutParams imgLayoutParams = new LinearLayout.LayoutParams(upWidth, upHeight / 2);
        imgLayoutParams.gravity = Gravity.CENTER;
        imgLayoutParams.topMargin = 10;
        loginImage = new UMImage(context);
        loginImage.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_login_button.png"));
        loginImage.setAdjustViewBounds(true);
        loginImage.setLayoutParams(imgLayoutParams);
        loginImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = UMLogin.this.getNameTextbox().getText().toString();
                String pass = UMLogin.this.getPassTextbox().getText().toString();
                if (name == null || "".equalsIgnoreCase(name) || pass == null || "".equalsIgnoreCase(pass)) {
                    UMLogin.this.getLabel().setText("用户名和密码不能为空！");
                    UMLogin.this.getLabel().setTextColor(Color.RED);

                } else {
                    UMLogin.this.getLabel().setText("");
                    if (events.containsKey(UMLogin.ON_LOGIN)) {
                        OnEventListener el = events.get(UMLogin.ON_LOGIN);
                        UMEventArgs arg = new UMEventArgs();
                        arg.put("logincode", nameTextbox.getText().toString());
                        arg.put("loginpass", passTextbox.getText().toString());
                        arg.put("isauthor", true);
                        el.onEvent(upLayout, arg);
                    }

                }
            }
        });

        this.addView(upLayout);
        this.addView(label);
        this.addView(loginImage);
    }

    public UMTextbox getNameTextbox() {
        return nameTextbox;
    }

    public void setNameTextbox(UMTextbox nameTextbox) {
        this.nameTextbox = nameTextbox;
    }

    public UMTextbox getPassTextbox() {
        return passTextbox;
    }

    public void setPassTextbox(UMTextbox passTextbox) {
        this.passTextbox = passTextbox;
    }

    public UMLabel getLabel() {
        return label;
    }

    public void setLabel(UMLabel label) {
        this.label = label;
    }

    public UMImage getLoginImage() {
        return loginImage;
    }

    public void setLoginImage(UMImage loginImage) {
        this.loginImage = loginImage;
    }

    private HashMap<String, OnEventListener> events = new HashMap<String, OnEventListener>();

    @SuppressLint("DefaultLocale")
    public void setEvent(String eventName, OnEventListener eventListener) {
        events.put(eventName.toLowerCase(), eventListener);
    }

}
