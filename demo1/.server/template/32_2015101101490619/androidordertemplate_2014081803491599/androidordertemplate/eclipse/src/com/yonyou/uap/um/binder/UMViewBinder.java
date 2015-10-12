package com.yonyou.uap.um.binder;

import java.util.Collection;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


/**
 * view group adapter
 * Project: UMP 
 * Function Description:
 * Company: YONYOU Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-4-11 下午8:30:22
 * @version
 */

public class UMViewBinder extends UMBaseBinder {
    private Object focusRecord;
    private Collection<?> collection;
    private String collectionName;
    
    public Object getFocusRecord() {
        return focusRecord;
    }

    public void setFocusRecord(Object focusRecord) {
        this.focusRecord = focusRecord;
    }

    public Collection<?> getCollection() {
        return collection;
    }

    public void setCollection(Collection<?> collection) {
        this.collection = collection;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void dataBindRow(){
        
    }
    
    public void registerListenerToCollection(ViewGroup viewGroup, Collection<?> collection){
        
    }

    

    @Override
    public void dataBind(View view) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dataBind(Context context, String dataStr, String fieldName, View view) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registerListenerToModel(View view) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registerListenerToCollection(View view) {
        // TODO Auto-generated method stub
        
    }
    
    
    

}
