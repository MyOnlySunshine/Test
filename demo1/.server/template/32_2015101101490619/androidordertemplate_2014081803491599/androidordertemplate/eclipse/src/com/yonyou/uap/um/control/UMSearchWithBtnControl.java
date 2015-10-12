package com.yonyou.uap.um.control;

import com.yonyou.uap.um.base.UMImageView;
import com.yonyou.uap.um.util.BitmapUtil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 搜索查询控件，增加搜索按钮 Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013 UFIDA
 * Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-28 下午1:26:23
 * @version
 */

@SuppressLint("DrawAllocation")
public class UMSearchWithBtnControl extends LinearLayout {

    private UMTextbox searchText;
    private UMImageView cleanImg;
    private UMButton searchBtn;
    private OnSearchListener mOnSearchListener;

    public UMSearchWithBtnControl(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @SuppressWarnings("deprecation")
    public UMSearchWithBtnControl(Context context) {
        super(context);

        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.LEFT);
        
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int width = dm.widthPixels;

        LinearLayout leftLayout = new LinearLayout(context);
        leftLayout.setOrientation(LinearLayout.HORIZONTAL);
        leftLayout.setGravity(Gravity.LEFT);
        
        
        
        
        LinearLayout.LayoutParams leftParams = new LinearLayout.LayoutParams(width * 2 / 3,
                LinearLayout.LayoutParams.MATCH_PARENT);
        leftLayout.setLayoutParams(leftParams);
        leftLayout.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_searchcontrol_background.png"));
        leftLayout.setPadding(0, 0, width * 2 / 3, 0);

        LinearLayout rightLayout = new LinearLayout(context);
        LinearLayout.LayoutParams rightParams = new LinearLayout.LayoutParams(width * 1 / 3,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        rightLayout.setLayoutParams(rightParams);
        rightLayout.setGravity(Gravity.RIGHT);
        rightLayout.setPadding(width * 2 / 3, 0, 0, 0);

        this.addView(leftLayout);
        this.addView(rightLayout);

        searchText = new UMTextbox(context);
        searchText.setHint("请输入查询条件...");
        searchText.setSingleLine();
        searchText.setInputType(InputType.TYPE_CLASS_TEXT);
        searchText.setBackgroundDrawable(null);
        searchText.setPadding(40, 0, 40, 0);
        searchText.setMaxWidth(300);
        leftLayout.addView(searchText);

        LinearLayout cleanLayout = new LinearLayout(context);
        LinearLayout.LayoutParams cleanParams = new LinearLayout.LayoutParams(40,
                LinearLayout.LayoutParams.MATCH_PARENT);
        cleanLayout.setLayoutParams(cleanParams);
        cleanLayout.setGravity(Gravity.RIGHT);
        cleanLayout.setPadding(leftLayout.getWidth() - searchText.getWidth() - 40, 2, 5, 0);
        cleanImg = new UMImageView(context);
        cleanImg.setBackgroundDrawable(BitmapUtil.getDrawableFromSrc("", "um_searchcontrol_clean.png"));
        cleanLayout.addView(cleanImg);
        cleanImg.setVisibility(INVISIBLE);
        leftLayout.addView(cleanLayout);

        
        UMButton searchBtn = new UMButton(context);
        searchBtn.setText("查询");
        rightLayout.addView(searchBtn);

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
                    cleanImg.setVisibility(INVISIBLE);
                } else {
                    cleanImg.setVisibility(VISIBLE);
                }

            }
        });

        cleanImg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                searchText.setText("");
            }
        });

        searchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnSearchListener != null) {
                    mOnSearchListener.onSearch(UMSearchWithBtnControl.this.searchBtn, searchText.getText().toString());
                }
            }
        });

    }

    public interface OnSearchListener {
        void onSearch(View view, CharSequence s);
    }

    /**
     * 设置搜索条件改变监听
     * 
     * @param l
     */
    public void setOnSearchListener(OnSearchListener l) {
        this.mOnSearchListener = l;
    }

}
