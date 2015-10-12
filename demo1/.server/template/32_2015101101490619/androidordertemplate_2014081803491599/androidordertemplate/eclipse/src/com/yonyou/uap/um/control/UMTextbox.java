package com.yonyou.uap.um.control;

import com.yonyou.uap.um.base.IFieldsDataBind;
import com.yonyou.uap.um.base.UMEditText;
import com.yonyou.uap.um.binder.IBinder;
import com.yonyou.uap.um.binder.UMBaseBinder;
import com.yonyou.uap.um.binder.UMFieldsBinder;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

/**
 * 
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013
 * UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-25 上午8:45:46
 * @version
 */

@SuppressWarnings("unused")
public class UMTextbox extends UMEditText implements IFieldsDataBind {
    private Object controlData;
    private String data;
    private String initData;
    private String userData;
    private String defaultValues;
    private Object event;
    private boolean modified;
    private Object bindingInfo;
    private boolean required;
    private boolean readOnly;
    private Object value;
    private String text;
    private boolean masked;
    private String maskChars;
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    private UMBaseBinder adapter;

    public UMTextbox(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public UMTextbox(Context context, AttributeSet attrs) {
        super(context, attrs);
        int idIndex = attrs.getIdAttributeResourceValue(0);
        this.id = attrs.getAttributeResourceValue(idIndex, 0);
        // dataBind();
    }

    public UMTextbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void dataBind() {
        this.adapter.dataBind(this.getContext(), this.initData, this.fieldName, this);
    }

    @Override
    public void dataCollect() {
        this.adapter.registerListenerToModel(this);
    }

    @Override
    public void onChanged() {

        this.addTextChangedListener(new TextWatcher() {

            private String oldStr = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                oldStr = s.toString();

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                dataCollect();
                Toast.makeText(getContext(),
                        "Before text:" + oldStr + "; Curret text: " + ((UMFieldsBinder) getAdapter()).getModelData(),
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    public UMBaseBinder getAdapter() {
        return adapter;
    }

    public void setAdapter(UMBaseBinder adapter) {
        this.adapter = adapter;

    }

    public String getInitData() {
        return initData;
    }

    public void setInitData(String initData) {
        this.initData = initData;
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
