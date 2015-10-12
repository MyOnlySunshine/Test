package com.yonyou.uap.um.model;

import java.util.Map;

/**
 * 控件和数据绑定模型
 * Project: UMP Function Description: Company: UFIDA Inc. UAP Copyright: 2013 UFIDA Inc.
 * All rights reserved.
 * 
 * @author pujie
 * @Date 2013-5-3 上午10:09:32
 * @version
 */

public class BindingInfoModel {
   /**
    * 数据源类型
    * Project: UMP 
    * Function Description:
    * Company: UFIDA Inc. UAP
    * Copyright: 2013 UFIDA Inc. All rights reserved.
    * @author pujie
    * @Date 2013-5-3 上午10:53:52
    * @version
    */
    public enum DataSourceType {
        Model("Model"), // 基本模型
        Collection("Collection");// 集合类型
        private DataSourceType(String value) {
            this.value = value;
        }

        private final String value;

        public String getValue() {
            return value;
        }
    }

    /**
     * 控件和数据绑定类型
     * Project: UMP 
     * Function Description:
     * Company: UFIDA Inc. UAP
     * Copyright: 2013 UFIDA Inc. All rights reserved.
     * @author pujie
     * @Date 2013-5-3 上午10:54:30
     * @version
     */
    public enum DataBindingType {
        None(-1), // 控件与模型没有绑定关系
        DoubleWay(0), // 控件和模型之间双向绑定
        OneWayDataBind(1), // JControl<--Model 控件绑定模型，控件数据的变化不会更新模型
        OneWayDataCollect(2); // JControl-->Model 控件数据自动收集到模型，模型数据变化不会更新到控件
        private DataBindingType(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }

    private String jControlId;
    private String dataSourceName;
    private DataSourceType dataSourceType = DataSourceType.Model;
    private Map<String, String> fieldsNames;
    private DataBindingType bindingType = DataBindingType.DoubleWay;
    
    public String getjControlId() {
        return jControlId;
    }
    public void setjControlId(String jControlId) {
        this.jControlId = jControlId;
    }
    public String getDataSourceName() {
        return dataSourceName;
    }
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }
    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }
    public Map<String, String> getFieldsNames() {
        return fieldsNames;
    }
    public void setFieldsNames(Map<String, String> fieldsNames) {
        this.fieldsNames = fieldsNames;
    }
    public DataBindingType getBindingType() {
        return bindingType;
    }
    public void setBindingType(DataBindingType bindingType) {
        this.bindingType = bindingType;
    }

}
