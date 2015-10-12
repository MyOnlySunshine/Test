package com.yonyou.uap.um.model;

import java.util.Map;

/**
 * 用户自定义数据模型
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-5-3 上午10:57:32
 * @version
 */

public class UserDataModel {
    
    private Map<String, Object> userDataMap;

    public Map<String, Object> getUserDataMap() {
        return userDataMap;
    }

    public void setUserDataMap(Map<String, Object> userDataMap) {
        this.userDataMap = userDataMap;
    }

}
