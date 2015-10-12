//package com.yonyou.uap.um.binder;
//
//import java.util.Map;
//
//import com.yonyou.uap.um.base.UM2ListView;
//
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
///**
// * 
// * Project: UMP 
// * Function Description:
// * Company: UFIDA Inc. UAP
// * Copyright: 2013 UFIDA Inc. All rights reserved.
// * @author xyy
// * @Date 2013-4-25 上午8:35:57
// * @version
// */
//
//public class UM2ListBinder extends BaseAdapter {
//private UM2ListView mView = null;
//    
//    
////    private int mHeight = 0;
//
//    public UM2ListBinder(UM2ListView view) {
//        mView = view;
//    }
//
//    @Override
//    public int getCount() {
//        return mView.getData().size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return getItemObject(position);
//    }
//
//    private Map<String, ?> getItemObject(int position) {
//        return mView.getData().get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View v = mView.getItemView();
//        if (mView.getItemViewBinder() != null) {
//            mView.getItemViewBinder().BindingListItem(position, v,
//                    getItemObject(position));
//        }
//        return v;
//    }
//}
