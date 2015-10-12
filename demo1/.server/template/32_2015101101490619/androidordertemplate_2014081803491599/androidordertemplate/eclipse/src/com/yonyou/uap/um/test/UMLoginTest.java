package com.yonyou.uap.um.test;

import com.yonyou.uap.um.base.OnEventListener;
import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.control.UMLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UMLoginTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UMLogin umLogin = new UMLogin(this);
        umLogin.setEvent(UMLogin.ON_LOGIN, new OnEventListener() {
            Intent intent = null;

            @Override
            public void onEvent(View v, UMEventArgs args) {
                boolean isAuthor = Boolean.valueOf(args.get("isauthor").toString());
                if (isAuthor) {
                    intent = new Intent(UMLoginTest.this, UMSearchControlTest.class);
                    startActivity(intent);
                }
            }
        });
        setContentView(umLogin);

    }
}
