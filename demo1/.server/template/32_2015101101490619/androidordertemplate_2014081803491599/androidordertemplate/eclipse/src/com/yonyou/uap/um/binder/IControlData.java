package com.yonyou.uap.um.binder;

import com.yonyou.uap.um.base.FieldsDataBindListener;

/**
 * 控件数据更新接口
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-5-7 下午1:14:12
 * @version
 */


public interface IControlData {
    
    void setOnChangedListener(FieldsDataBindListener l); // 数据变化监听

}
