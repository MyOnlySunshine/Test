package com.yonyou.uap.um.base;

import org.json.JSONObject;

public interface IUMContext {

    UMContext getUMContext();

    JSONObject getBindingInfo();

    JSONObject getDataSource();
    
    JSONObject getDefaultData();
    
    String[] getFieldNames();

}
