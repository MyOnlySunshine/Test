package com.yonyou.uap.um.control;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.yonyou.uap.um.base.IFieldsDataBind;
import com.yonyou.uap.um.base.UMTextView;
import com.yonyou.uap.um.binder.IBinder;

/**
 * 
 * Project: UMP Function Description:UMLabel Company: UFIDA Inc. UAP Copyright:
 * 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:58:35
 * @version
 */
public class UMLabel extends UMTextView implements IFieldsDataBind {

    private String text;// label上显示的内容
    private Context context = null;

    public enum Alignment {
        Alignment_Left(0), // 水平居左
        Alignment_Right(1), // 水平居右
        Alignment_Center(2); // 水平居中
        private int value;

        public int getValue() {
            return value;
        }

        private Alignment(int value1) {
            this.value = value1;
        }
    }

    /**
     * 设置label上的字体颜色
     */
    public void setUMLabelTextColor(int color) {
        this.setTextColor(color);
    }

    /**
     * 设置显示的内容
     * 
     * @param title
     */
    public void setUMLabelText(String title) {
        text = title;
        super.setText(title);
    }

    /**
     * 获取label上的内容
     * 
     * @return
     */
    public String getUMLabelText() {
        return text;
    }

    /**
     * 设置label上的文本大小
     * 
     * @param size
     */
    public void setUMLabelTextSize(float size) {
        this.setTextSize(size);
    }

    /**
     * 设置label上文本的位置
     * 
     * @param align
     */
    public void setUMLabelAlignment(Alignment align) {
        LinearLayout ll = new LinearLayout(context);
        switch (align) {
        case Alignment_Left:
            ll.setGravity(Gravity.LEFT);
        case Alignment_Right:
            ll.setGravity(Gravity.RIGHT);
        case Alignment_Center:
            ll.setGravity(Gravity.CENTER);
        }
    }

    /**
     * 设置label上的文本字体
     * 
     * @param boldItalic
     */
    public void setUMLabelFont(Typeface bold) {
        this.setTypeface(bold);
    }

    public UMLabel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    public UMLabel(Context context, String text) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.text = text;
    }

    public UMLabel(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public void dataBind() {
        mBinder.dataBinding();
    }

    @Override
    public void dataCollect() {
        mBinder.dataCollect(this.getText().toString());
    }

    @Override
    public void onChanged() {
    	dataCollect();
    }

    private IBinder mBinder = null;
    
	@Override
	public void setBinder(IBinder binder) {
		mBinder = binder;
	}

	@Override
	public IBinder getBinder() {
		return mBinder;
	}
}
