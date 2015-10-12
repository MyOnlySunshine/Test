package com.yonyou.uap.um.binder;

import org.json.JSONObject;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * UMP BASE Adapter Project: UMP Function Description: Company: YONYOU Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-11 下午7:17:18
 * @version
 */

public abstract class UMBaseBinder extends BaseAdapter {
    public Object bindingInfo;
    public String bindingType;// -1 0 1 2
    public JSONObject dataSource;
    public String dataSourceName;
    public View controlView;
    public int controlViewId;
    public String[] fieldNames;

    abstract public void dataBind(View view);

    abstract public void dataBind(Context context, String dataStr, String fieldName, View view);

    abstract public void registerListenerToModel(View view);
    
    abstract public void registerListenerToCollection(View view);
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return null;
    }

}
