package com.yonyou.uap.um.model;
/**
 * 控件元数据模型
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-5-3 上午10:56:31
 * @version
 */
public class InitDataModel {
    
    private BindingInfoModel bindingInfo;
    private String type;
    public BindingInfoModel getBindingInfo() {
        return bindingInfo;
    }
    public void setBindingInfo(BindingInfoModel bindingInfo) {
        this.bindingInfo = bindingInfo;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    

}
