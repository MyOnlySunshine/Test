package com.yonyou.uap.um.model;

/**
 * 控件数据模型
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-5-3 上午10:49:47
 * @version
 */

public class ControlDataModel {

    private ValuesDataModel data; // 数据
    private InitDataModel initData;// 控件元数据，包含绑定信息，绑定类型
    private UserDataModel userData;// 用户自定义保存的数据
    private DefaultValuesModel defaultValues;// 控件默认数据

    public ValuesDataModel getData() {
        return data;
    }

    public void setData(ValuesDataModel data) {
        this.data = data;
    }

    public InitDataModel getInitData() {
        return initData;
    }

    public void setInitData(InitDataModel initData) {
        this.initData = initData;
    }

    public UserDataModel getUserData() {
        return userData;
    }

    public void setUserData(UserDataModel userData) {
        this.userData = userData;
    }

    public DefaultValuesModel getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(DefaultValuesModel defaultValues) {
        this.defaultValues = defaultValues;
    }

}
