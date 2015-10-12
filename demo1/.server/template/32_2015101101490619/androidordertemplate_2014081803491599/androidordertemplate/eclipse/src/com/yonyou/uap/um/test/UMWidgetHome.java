package com.yonyou.uap.um.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SimpleAdapter;

public class UMWidgetHome extends Activity {
    LinearLayout linearLayout;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        listView = new ListView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // listView.setBackgroundColor(Color.BLACK);
        linearLayout.addView(listView, params);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));
        setContentView(linearLayout);
        listView.setOnItemClickListener(new OnItemClickListener() {
            Intent intent = null;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    intent = new Intent(UMWidgetHome.this, UMLoginTest.class);
                } else if (position == 1) {
                    intent = new Intent(UMWidgetHome.this, UMSearchControlTest.class);
                }
                startActivity(intent);

            }
        });

    }

    private List<String> getData() {

        List<String> data = new ArrayList<String>();
        data.add("UMLogin");
        data.add("UMSearch");
        return data;
    }

}
