package com.yonyou.uap.um.base;

import com.yonyou.uap.um.binder.IBinder;

/**
 * 
 * Project: UMP Function Description: Base Control Company: YONYOU Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-11 下午1:58:57
 * @version
 */
public interface IBaseDataBind {
	
	void setBinder(IBinder binder);
	IBinder getBinder();

    void dataBind();// 数据绑定 将model的数据绑定到控件上

    void dataCollect();// 数据收集 将控件上的数据收集并更新model数据

}
