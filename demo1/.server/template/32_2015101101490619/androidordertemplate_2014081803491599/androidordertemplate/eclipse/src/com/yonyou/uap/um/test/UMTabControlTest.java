/*package com.yonyou.uap.um.test;

import com.yonyou.uap.um.control.UMTabControl;
import com.yonyou.uap.um.widget.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UMTabControlTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        UMTabControl umTabControl = new UMTabControl(this, 1);
        umTabControl.setup();
        TextView tv1 = new TextView(this);
        tv1.setId(0x7f130001);
        tv1.setText("test 1");

        TextView tv2 = new TextView(this);
        tv2.setText("test 2");
        tv2.setId(0x7f130002);

        TextView tv3 = new TextView(this);
        tv3.setText("test 3");
        tv3.setId(0x7f130003);

        umTabControl.addUMTabSpec(tv1, "TAG1", "context1", getResources().getDrawable(R.drawable.toolbar_date_normal),
                getResources().getDrawable(R.drawable.toolbar_date_selected));
        umTabControl.addUMTabSpec(tv2, "TAG2", "context2",
                getResources().getDrawable(R.drawable.toolbar_mainpage_normal),
                getResources().getDrawable(R.drawable.toolbar_mainpage_selected));
        umTabControl.addUMTabSpec(tv3, "TAG3", "context3",
                getResources().getDrawable(R.drawable.toolbar_mainpage_normal),
                getResources().getDrawable(R.drawable.toolbar_mainpage_selected));

        this.setContentView(umTabControl);

    }
}
*/