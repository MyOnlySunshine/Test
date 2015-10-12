package com.yonyou.uap.um.base;

import android.view.View;

/**
 * model和数据绑定监听
 * Project: UMP Function Description: Company:
 * YONYOU Inc. UAP Copyright: 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-11 下午2:00:21
 * @version
 */
public interface FieldsDataBindListener {
    void onChanged(View view, Object value);// 控件监听
}
