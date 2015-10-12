package com.yonyou.uap.um.control;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.yonyou.uap.um.base.IFieldsDataBind;
import com.yonyou.uap.um.base.UMCompoundButton;
import com.yonyou.uap.um.binder.IBinder;

/**
 * 
 * Project: UMP Function Description:UM Checkbox Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author xiaochj
 * @Date 2013-4-25 上午9:17:36
 * @version
 */

@SuppressWarnings("unused")
public class UMCheckbox extends UMCompoundButton implements IFieldsDataBind {

    private String label;// 多选的内容提示
    private boolean readonly = false;// 是否只读，默认否
    private boolean visible = true;// label是否可见，默认可见

    private boolean selected = false;// 是否选中，默认没有
    private int imgNormal;
    private int imgSelected;

    /**
     * 设置多选框的显示的文字提示
     * 
     * @param label
     */
    public void setUMCheckboxLabelText(String label) {
        this.label = label;
        this.setText(label);
    }

    /**
     * 返回label显示内容
     * 
     * @return
     */
    public String getUMCheckboxLabel() {
        return label;
    }

    /**
     * 设置是否被选中状态
     * 
     * @param selected
     */
    public void setUMCheckboxSelected(boolean selected) {
        this.selected = selected;
        if (selected == true) {
            this.setChecked(true);
        } else {
            this.setChecked(false);
        }
    }

    /**
     * 设置按钮的图片
     * 
     * @param imgNormal
     * @param imgSelected
     */
    public void setUMCheckboxButton(final int imgNormal, final int imgSelected) {
        this.imgNormal = imgNormal;
        this.imgSelected = imgSelected;
        if (isChecked() && imgSelected != 0) {
            this.setButtonDrawable(imgSelected);
        } else if (isChecked() == false && imgNormal != 0) {
            this.setButtonDrawable(imgNormal);
        } else {
            this.setButtonDrawable(android.R.attr.checkboxStyle);
        }
        this.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked() && imgSelected != 0) {
                    buttonView.setButtonDrawable(imgSelected);
                } else if (isChecked() == false && imgNormal != 0) {
                    buttonView.setButtonDrawable(imgNormal);
                }
            }
        });

    }

    /**
     * 根据选中状态进而改变checkbox背景图
     * 
     * @param resid
     */
    public void setUMCheckboxBackgroundImg(final int residNormal, final int residSelected) {
        if (isChecked() && residSelected != 0) {
            this.setBackgroundResource(residSelected);
        } else if (isChecked() == false && residNormal != 0) {
            this.setBackgroundResource(residNormal);
        }
        this.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {// 选中后显示的背景图片
                    buttonView.setBackgroundResource(residSelected);
                } else {
                    buttonView.setBackgroundResource(residNormal);
                }
            }
        });
    }

    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        // TODO Auto-generated method stub
        super.setOnCheckedChangeListener(listener);
    }

    public boolean isUMCheckboxReadOnly() {
        return readonly;
    }

    /**
     * 设置checkbox是否可选
     * 
     * @param readonly
     */
    public void setUMCheckboxReadOnly(boolean readonly) {
        this.readonly = readonly;
        if (readonly == true) {
            this.setEnabled(false);
        } else {
            this.setEnabled(true);
        }
    }

    /**
     * 返回checkbox是否可见
     * 
     * @return
     */
    public boolean isUMCheckboxVisible() {
        return visible;
    }

    /**
     * 设置checkbox是否可见
     * 
     * @param labelTextVisible
     */
    public void setUMCheckboxVisible(boolean visible) {
        this.visible = visible;
        if (visible == true) {
            this.setVisibility(VISIBLE);
        } else {
            this.setVisibility(INVISIBLE);
        }
    }

    public UMCheckbox(Context context) {
        this(context, null);
    }

    public UMCheckbox(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.checkboxStyle);
    }

    public UMCheckbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
