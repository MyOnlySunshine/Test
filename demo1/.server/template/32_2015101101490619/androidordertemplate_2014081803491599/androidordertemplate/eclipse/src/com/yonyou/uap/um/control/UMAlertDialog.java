package com.yonyou.uap.um.control;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ListAdapter;

/**
 * 
 * Project: UMP Function Description:UMAlertDialog Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-26 上午9:56:46
 * @version
 */
public class UMAlertDialog extends AlertDialog.Builder {

    public UMAlertDialog(Context arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
        this.setTitle("init");
    }

    /**
     * 设置dialg的标题
     * 
     * @param text
     */
    public void setUMAlertDialogTitle(String text) {
        this.setTitle(text);
    }

    /**
     * 加入一个表单
     * 
     * @param adapter
     * @param listener
     */
    public void addUMAlertDialogList(ListAdapter adapter, OnClickListener listener) {
        this.setAdapter(adapter, listener);
    }

    /**
     * 设置dialog的icon
     * 
     * @param iconId
     */
    public void setUMAlertDialogIcon(int iconId) {
        this.setIcon(iconId);
    }

    /**
     * 加入dialog的内容
     * 
     * @param items
     * @param listener
     */
    public void addUMAlertDialogItems(CharSequence[] items, OnClickListener listener) {
        this.setItems(items, listener);
    }

    /**
     * 添加按钮
     * 
     * @param which
     * @param text
     * @param listener
     */
    public void addUMAlertDialogButton(int which, String text, OnClickListener listener) {
        if (which == 0) {
            this.setPositiveButton(text, listener);
        } else if (which == 1) {
            this.setNeutralButton(text, listener);
        } else if (which == 2) {
            this.setNegativeButton(text, listener);
        } else {
            return;
        }
    }

    /**
     * 以view的形式作为内容加入进去
     * 
     * @param view
     */
    public void setUMAlertDialogView(View view) {
        this.setView(view);
    }

}
