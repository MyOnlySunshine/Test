package com.yonyou.uap.um.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * Project: UMP Function Description:LinearLayout放置多个图片，自动布局 Company: UFIDA Inc.
 * UAP Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-26 下午1:48:10
 * @version
 */

public class UMTabGroup extends ViewGroup {

    private final static int VIEW_MARGIN = 0;

    private View selectedView = null;

    private OnChangedViewListener mChangedViewListener = null;

    public interface IUMLinearView {

        void setImage(int statusFlag);// 0 normal image >0 selected image

    }

    public UMTabGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public UMTabGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMTabGroup(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int index = 0; index < getChildCount(); index++) {
            final View child = getChildAt(index);
            // measure
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        final int count = getChildCount();
        int lengthX = arg1;
        int lengthY = arg2;
        int newChildWidth = 0;
        newChildWidth = (arg3 - arg1 - (count - 1) * VIEW_MARGIN) / count;
        for (int i = 0; i < count; i++) {
            final View child = this.getChildAt(i);
            int height = child.getMeasuredHeight();
            child.layout(lengthX, arg2, lengthX + newChildWidth, lengthY + height);
            // Log.v("Child position",
            // "L:" + String.valueOf(lengthX) + " T:" + String.valueOf(arg2) +
            // " R:"
            // + String.valueOf(lengthX + newChildWidth) + " B:" +
            // String.valueOf(lengthY + height));
            lengthX += newChildWidth + VIEW_MARGIN;
        }

    }

    @Override
    public void addView(View child) {
        // TODO Auto-generated method stub
        if (!(child instanceof IUMLinearView)) {
            return;
        } else {
            super.addView(child);
            if (this.selectedView == null) {
                selectedView = this.getChildAt(0);
                ((IUMLinearView) selectedView).setImage(1);
            }
            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((IUMLinearView) v).setImage(1);
                    changeChildImage(v);// 改变其他child view的样式
                    setSelectedView(v);// 设置选中的view
                    if(mChangedViewListener != null){
                        mChangedViewListener.onChangedView(v);// 执行监听
                    }
                }
            });

        }
    }

    /**
     * 改变其他child的图片背景
     * 
     * @param onClickChild
     */
    private void changeChildImage(View onClickChild) {
        int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = this.getChildAt(i);
            if (child != onClickChild) {
                ((IUMLinearView) child).setImage(0);
            }
        }
    }

    public View getSelectedView() {
        return selectedView;
    }

    private void setSelectedView(View selectedView) {
        this.selectedView = selectedView;
    }

    public interface OnChangedViewListener {
        void onChangedView(View v);
    }

    /**
     * view改变监听事件
     * 
     * @param l
     */
    public void setOnChangedViewListener(OnChangedViewListener l) {
        mChangedViewListener = l;
    }

}
