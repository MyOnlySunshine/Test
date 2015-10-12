package com.yonyou.uap.um.binder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Basic view adapter Project: UMP Function Description: Company: YONYOU Inc.
 * UAP Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-11 下午7:56:36
 * @version
 */
public class UMFieldsBinder extends UMBaseBinder {

    public String fieldName;

    public UMFieldsBinder() {
        super();
    }

    public UMFieldsBinder(Context context, String dataStr, String fieldName, View view) {
        try {
            this.dataSource = new JSONObject(dataStr);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.controlView = view;
        this.controlViewId = view.getId();
        this.fieldName = fieldName;
    }

    @Override
    public void dataBind(Context context, String dataStr, String fieldName, View view) {
        try {
            this.dataSource = new JSONObject(dataStr);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.controlView = view;
        this.controlViewId = view.getId();
        this.fieldName = fieldName;
        dataBind(view);

    }

    @Override
    public void dataBind(View view) {
        this.controlView = view;
        String modelValue = "";
        try {
            modelValue = this.dataSource.getString(this.fieldName);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (this.controlView instanceof TextView) {
            ((TextView) this.controlView).setText(modelValue);
        } else {

        }
    }

    public View getControlData() {
        return this.controlView;
    }

    public void setControlData(View view) {
        this.controlView = view;
    }

    public Object getModel() {
        return this.dataSource;
    }

    public void setModel(String model) {
        try {
            this.dataSource = new JSONObject(model);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Object getModelData() {
        try {
            return this.dataSource.get(this.fieldName);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void setModelData(Object modelData) {
        try {
            this.dataSource.put(this.fieldName, modelData);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String[] getFieldNames() {
        List<String> fieldNameList = new ArrayList<String>();
        for (@SuppressWarnings("unchecked")
        Iterator<String> iterator = this.dataSource.keys(); iterator.hasNext();) {
            fieldNameList.add(iterator.next());
        }
        return (String[]) fieldNameList.toArray();
    }

    // view控件有变化，通知model进行更新
    @Override
    public void registerListenerToModel(View view) {
        if (view == null) {
            return;
        } else if (view instanceof TextView) {
            setModelData(((TextView) view).getText());
        }

    }

    @Override
    public void registerListenerToCollection(View view) {
        // TODO Auto-generated method stub

    }

}
