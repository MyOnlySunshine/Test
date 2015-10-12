package com.yonyou.uap.um.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import com.yonyou.uap.um.base.OnEventListener;
import com.yonyou.uap.um.base.UMEventArgs;
import com.yonyou.uap.um.base.UMEventListener;
import com.yonyou.uap.um.base.UMImageView;
import com.yonyou.uap.um.util.BitmapUtil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/**
 * 搜索查询控件 Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013 UFIDA Inc. All
 * rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-28 下午1:26:23
 * @version
 */

@SuppressLint({ "DrawAllocation", "DefaultLocale" })
public class UMSearchControl extends LinearLayout implements UMEventListener {

    public static final Object ON_SEARCH = "onsearch";
    private UMImageView leftBtn;
    private UMTextbox searchText;
    private UMImageView cleanBtn;
    private ListView listView;
    private List<String> resultList = new ArrayList<String>();
    private ArrayAdapter<String> mAdapter;

    private static final String SEARCH_KEY_FILENAME = "searchkey.properties";
    private static Context mContext;

    public UMSearchControl(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private void searchResult() {
        if (events.containsKey(UMSearchControl.ON_SEARCH)) {
            OnEventListener ll = events.get(UMSearchControl.ON_SEARCH);
            UMEventArgs arg = new UMEventArgs();
            arg.put("searchtext", searchText.getText().toString());
            arg.put("listview", listView);
            arg.put("resultlist", resultList);
            ll.onEvent(searchText, arg);
            addList(resultList, searchText.getText().toString());
            mAdapter.notifyDataSetChanged();
            saveFile(resultList, new File(mContext.getFilesDir().getAbsolutePath() + File.separator
                    + SEARCH_KEY_FILENAME));
        }
    }

    @SuppressWarnings("deprecation")
    public UMSearchControl(Context context) {
        super(context);
        mContext = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.LEFT);
        // this.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("",
        // "um_searchcontrol_background.png"));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams leftParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        leftBtn = new UMImageView(context);
        leftBtn.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_search_left.png"));
        leftBtn.setId(0x10000);
        leftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UMSearchControl.this.searchResult();
            }
        });
        // todo modify ID values
        relativeLayout.addView(leftBtn, leftParams);

        RelativeLayout.LayoutParams rightParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        cleanBtn = new UMImageView(context);
        cleanBtn.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_search_right.png"));
        cleanBtn.setVisibility(VISIBLE);
        cleanBtn.setId(0x10002);
        relativeLayout.addView(cleanBtn, rightParams);

        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.RIGHT_OF, 0x10000);
        textParams.addRule(RelativeLayout.LEFT_OF, 0x10002);

        searchText = new UMTextbox(context);
        searchText.setHint("请输入查询条件...");
        searchText.setSingleLine();
        searchText.setInputType(InputType.TYPE_CLASS_TEXT);
        searchText.setBackgroundDrawable(null);
        searchText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchText.setId(0x10001);
        searchText.setHeight(60);
        searchText.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_search_middle.png"));
        relativeLayout.addView(searchText, textParams);

        RelativeLayout.LayoutParams listViewParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        listViewParams.addRule(RelativeLayout.BELOW, 0x10000);
        listView = new ListView(context);
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + SEARCH_KEY_FILENAME);
        createFile(file);
        resultList = loadFile(file);
        mAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_expandable_list_item_1, resultList);
        listView.setAdapter(mAdapter);
        relativeLayout.addView(listView, listViewParams);
        this.addView(relativeLayout);

        searchText.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    UMSearchControl.this.searchResult();

                }
                return false;
            }
        });

        searchText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ("".equalsIgnoreCase(searchText.getText().toString()) || searchText.getText() == null) {
                    cleanBtn.setVisibility(VISIBLE);
                } else {
                    cleanBtn.setVisibility(VISIBLE);
                }
            }
        });

        cleanBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                searchText.setText("");
            }
        });

    }

    private HashMap<String, OnEventListener> events = new HashMap<String, OnEventListener>();

    public void setEvent(String eventName, OnEventListener l) {
        events.put(eventName.toLowerCase(), l);
    }

    private void createFile(File file) {

        if (!file.exists() || !file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private List<String> loadFile(File file) {
        List<String> list = new ArrayList<String>();
        if (!file.exists()) {
            return list;
        }
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Set<Object> keySet = pro.keySet();
        for (Object obj : keySet) {
            System.out.println(obj.toString());
            list.add(pro.get(obj).toString());
        }

        return list;
    }

    private void saveFile(List<String> list, File file) {
        Properties pro = new Properties();
        if (list != null && list.size() > 0) {
            int i = 0;
            for (String tempStr : list) {
                i++;
                pro.put(String.valueOf(i), tempStr);
            }
        }
        try {
            pro.store(new FileOutputStream(file), "");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void addList(List<String> list, String addStr) {
        if (list != null && list.size() < 10) {
            list.add(addStr);
        } else if (list != null && list.size() == 10) {
            for (int i = 0; i < 9; i++) {
                list.set(i, list.get(i + 1));
            }
            list.set(9, addStr);
        }
    }

}
