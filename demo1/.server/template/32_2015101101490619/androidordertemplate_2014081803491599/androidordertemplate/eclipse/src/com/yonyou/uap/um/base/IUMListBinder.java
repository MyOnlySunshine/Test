package com.yonyou.uap.um.base;

import java.util.Map;

import android.view.View;

/**
 * 
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author xyy
 * @Date 2013-4-25 上午8:41:14
 * @version
 */

public interface IUMListBinder {
    @SuppressWarnings("rawtypes")
    void BindingListItem(int position, View view, Map dataSet);
}
