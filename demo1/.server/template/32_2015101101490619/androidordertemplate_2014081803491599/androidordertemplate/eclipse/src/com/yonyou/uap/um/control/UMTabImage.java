package com.yonyou.uap.um.control;

import android.content.Context;
import android.util.AttributeSet;

import com.yonyou.uap.um.base.UMImageView;

public class UMTabImage extends UMImageView {

    private int normalImg = android.R.drawable.btn_star_big_off;
    private int selectedImg = android.R.drawable.btn_star_big_on;

    public UMTabImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public UMTabImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMTabImage(Context context) {
        super(context);
        this.setImageResource(this.normalImg);
        // TODO Auto-generated constructor stub
    }

    public void initImage(int normalImgResId, int selectedImgResId) {
        this.normalImg = normalImgResId;
        this.selectedImg = selectedImgResId;
        setImage(0);
    }
    
    public void setNormalImage(int resid) {
    	this.normalImg = resid;
    }

    public void setSelectedImage(int resid) {
    	this.selectedImg = resid;
    }
    

    public void setImage(int statusFlag) {
        // TODO Auto-generated method stub
        if (statusFlag == 0) {
            this.setImageResource(this.normalImg);
        } else {
            this.setImageResource(this.selectedImg);
        }
    }

}