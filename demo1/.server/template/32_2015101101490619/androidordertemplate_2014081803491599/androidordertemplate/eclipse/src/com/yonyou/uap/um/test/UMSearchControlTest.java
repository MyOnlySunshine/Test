package com.yonyou.uap.um.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yonyou.uap.um.base.OnEventListener;
import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.control.UMSearchControl;

public class UMSearchControlTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        // layout.setGravity(Gravity.CENTER);
        setContentView(layout);

        UMSearchControl umSearch = new UMSearchControl(this);
        layout.addView(umSearch);
        umSearch.setEvent(UMSearchControl.ON_SEARCH.toString(), new OnEventListener() {
            Intent intent = null;
            @Override
            public void onEvent(View v, UMEventArgs args) {
                // TODO Auto-generated method stub
                String searchText = args.get("searchtext").toString();
                Toast.makeText(UMSearchControlTest.this, searchText, Toast.LENGTH_SHORT).show();
                intent = new Intent(UMSearchControlTest.this, UMLoginTest.class);
                startActivity(intent);
            }
        });
    }

}
