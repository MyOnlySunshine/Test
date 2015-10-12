package com.yonyou.uap.um.base;

import android.content.Context;
import android.view.View;

import com.yonyou.uap.um.base.UMListViewBase.ListItemView;
import com.yonyou.uap.um.binder.IBinderGroup;

/**
 * 
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author xyy
 * @Date 2013-4-25 上午8:41:31
 * @version
 */

public interface IUMListView {
    ListItemView getListItemView(int index);

    ListItemView getListItemView(); // 取第0个

    void addListItemView(ListItemView value);

    View getItemView(IBinderGroup group); // 取第0个

    View getItemView(int index, IBinderGroup group);

    int getLevel(int position);

    IUMListItemViewBinder getItemViewBinder(int index);

    IUMListItemViewBinder getItemViewBinder(); // 取第0个

    void addItemViewBinder(IUMListItemViewBinder value);

    Context getContext();
}
