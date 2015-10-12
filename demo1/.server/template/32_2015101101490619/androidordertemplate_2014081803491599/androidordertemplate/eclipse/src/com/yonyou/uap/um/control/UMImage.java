package com.yonyou.uap.um.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

import com.yonyou.uap.um.base.IFieldsDataBind;
import com.yonyou.uap.um.base.UMImageView;
import com.yonyou.uap.um.binder.IBinder;

/**
 * 
 * Project: UMP Function Description:UMImage Company: UFIDA Inc. UAP Copyright:
 * 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:19:18
 * @version
 */
public class UMImage extends UMImageView implements IFieldsDataBind {

    private boolean visible = true;// 设置imageview的可见性，默认可见
    private Context mContext = null;
    private AnimationDrawable frameAnimation = null;// 定义动画
    private Drawable mBitAnimation = null;// drawable对象
    private boolean isAnimating = false;// 动画是否循环播放，默认是

    public UMImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        mContext = context;
    }

    public UMImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        mContext = context;
    }

    public UMImage(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        mContext = context;
    }

    /**
     * 设置动画播放
     * 
     * @param imgNum
     *            图片资源的数目
     * @param frame
     *            每帧播放时间，毫秒
     */
    @SuppressWarnings("deprecation")
    public void setImgsForAnimate(int imgNum, int frame) {
        frameAnimation = new AnimationDrawable();
        for (int i = 1; i <= imgNum; i++) {
            int id = getResources().getIdentifier("ump_animate" + i, "drawable", mContext.getPackageName());
            mBitAnimation = getResources().getDrawable(id);
            frameAnimation.addFrame(mBitAnimation, frame);
            // System.out.println("----->"+id);
        }
        frameAnimation.setOneShot(isAnimating);
        this.setBackgroundDrawable(frameAnimation);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_UP:// 点击向上按钮，开始动画
            frameAnimation.start();
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:// 点击向下按钮，停止动画
            frameAnimation.stop();
            break;
        }
        return true;

    }

    /**
     * 设置动画开始
     */
    public void startAnimate() {
        frameAnimation.start();
    }

    /**
     * 设置动画停止
     */
    public void stopAnimate() {
        frameAnimation.stop();
    }

    /**
     * 设置动画是否循环播放
     * 
     * @param isAnimating
     */
    public void setAnimateShot(boolean isAnimating) {
        this.isAnimating = isAnimating;
        if (isAnimating == false) {
            frameAnimation.setOneShot(false);
        } else {
            frameAnimation.setOneShot(true);
        }
    }

    /**
     * 设置显示图片
     * 
     * @param resId
     */
    public void setUMImage(int resId) {
        this.setImageResource(resId);
    }

    /**
     * 设置图片的大小
     * 
     * @param width
     * @param height
     */
    public void setUMImageSize(int width, int height) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        this.setLayoutParams(params);
    }

    /**
     * 返回是否可见
     * 
     * @return
     */
    public boolean isUMImageVisible() {
        return visible;
    }

    /**
     * 设置图片的可见性
     * 
     * @param visible
     */
    public void setUMImageVisible(boolean visible) {
        this.visible = visible;
        if (visible == false) {
            this.setVisibility(INVISIBLE);
        } else {
            this.setVisibility(VISIBLE);
        }
    }

    @Override
    public void dataBind() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dataCollect() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onChanged() {
        // TODO Auto-generated method stub

    }

	@Override
	public void setBinder(IBinder binder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder getBinder() {
		// TODO Auto-generated method stub
		return null;
	}

}
