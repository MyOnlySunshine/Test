//package com.yonyou.uap.um.base;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//import com.yonyou.uap.um.binder.UM2ListBinder;
//
//import android.content.Context;
//
///**
// * 
// * Project: UMP 
// * Function Description:
// * Company: UFIDA Inc. UAP
// * Copyright: 2013 UFIDA Inc. All rights reserved.
// * @author xyy
// * @Date 2013-4-25 上午8:41:54
// * @version
// */
//public class UM2ListView extends UMListViewBase {
//
//    protected ArrayList<ListItemView> pitemView = new ArrayList<ListItemView>();
//    protected ArrayList<IUMListItemViewBinder> pbinder = new ArrayList<IUMListItemViewBinder>();
//    protected ArrayList<Integer> mMapping = new ArrayList<Integer>(); // 参数2：0表示叶子，1表示1级
//
//    public UM2ListView(Context context) {
//        super(context);
//    }
//
//    @Override
//    public void setData(UMListValue data) {
//        mData.clear();
//        addData(data, 0);
//    }
//
//    private void addData(UMListValue data, int level) {
//        for (int i = 0; i < data.size(); i++) {
//            Map<String, ?> value = data.get(i);
//            for (Object item : value.values()) {
//                if (item instanceof UMListValue) {
//                    addData((UMListValue) item, level + 1);
//                    continue;
//                }
//            }
//            mData.add(value);
//            mMapping.add(level);
//        }
//    }
//
//    @Override
//    public void dataBinding() {
//        this.setAdapter(new UM2ListBinder(this));
//    }
//
//}
