package com.yonyou.uap.um.binder;

/**
 * 绑定多个字段
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-5-6 下午4:46:41
 * @version
 */
public class CompoundBindInfo {
    
    private String[] bindFields;

    public CompoundBindInfo(String[] bindFields) {
        this.bindFields = bindFields;
    }

    public String[] getBindFields() {
        return bindFields;
    }

    public void setBindFields(String[] bindFields) {
        this.bindFields = bindFields;
    }

}
