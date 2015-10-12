/*package com.yonyou.uap.um.test;

import com.yonyou.uap.um.base.UMTabGroup;
import com.yonyou.uap.um.base.UMTabGroup.OnChangedViewListener;
import com.yonyou.uap.um.control.UMTabImage;

import com.yonyou.uap.um.widget.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UMTabGroupTest extends Activity {

    private UMTabImage img1;
    private UMTabImage img2;
    private UMTabImage img3;
    private UMTabImage img4;
    private UMTabGroup umLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        umLayout = new UMTabGroup(this);
        umLayout.setLayoutParams(new LinearLayout.LayoutParams(200, 100));
        img1 = new UMTabImage(this);
        img1.initImage(R.drawable.toolbar_date_normal, R.drawable.toolbar_date_selected);
        img2 = new UMTabImage(this);
        img2.initImage(R.drawable.toolbar_mainpage_normal, R.drawable.toolbar_mainpage_selected);
        img3 = new UMTabImage(this);
        img3.initImage(android.R.drawable.ic_search_category_default, android.R.drawable.list_selector_background);
        img4 = new UMTabImage(this);
        
      //  img4.initImage(android.R.style., android.R.drawable.list_selector_background);
        umLayout.addView(img1);
        umLayout.addView(img2);
        umLayout.addView(img3);
        umLayout.addView(img4);
        umLayout.setOnChangedViewListener(new OnChangedViewListener() {

            @Override
            public void onChangedView(View v) {
                if (img1 == v) {
                    Toast.makeText(UMTabGroupTest.this, "select img1", Toast.LENGTH_SHORT).show();
                }
                if (img2 == v) {
                    Toast.makeText(UMTabGroupTest.this, "select img2", Toast.LENGTH_SHORT).show();
                }
                if (img3 == v) {
                    Toast.makeText(UMTabGroupTest.this, "select img3", Toast.LENGTH_SHORT).show();
                }
                if (img4 == v) {
                    Toast.makeText(UMTabGroupTest.this, "select img4", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setContentView(umLayout);

    }
}
*/