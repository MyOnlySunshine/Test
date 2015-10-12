package com.yonyou.uap.um.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.yonyou.uap.um.control.UMSearchWithBtnControl.OnSearchListener;
import com.yonyou.uap.um.control.UMSearchWithBtnControl;

public class UMSearchWithBtnControlTest extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        UMSearchWithBtnControl umSearchControl = new UMSearchWithBtnControl(this);
        UMSearchWithBtnControl umSearchControl2 = new UMSearchWithBtnControl(this);
        UMSearchWithBtnControl umSearchControl3 = new UMSearchWithBtnControl(this);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 40);
        umSearchControl.setLayoutParams(mainParams);
        umSearchControl2.setLayoutParams(mainParams);
        umSearchControl3.setLayoutParams(mainParams);
        mainLayout.addView(umSearchControl);
        mainLayout.addView(umSearchControl2);
        mainLayout.addView(umSearchControl3);
        setContentView(mainLayout);
        umSearchControl.setOnSearchListener(new OnSearchListener() {
            @Override
            public void onSearch(View view, CharSequence s) {
                Toast.makeText(UMSearchWithBtnControlTest.this, "Search Text:" + s.toString(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        //

    }
}
