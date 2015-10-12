package com.yonyou.uap.um.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 
 * Project: UMP 
 * Function Description:
 * Company: UFIDA Inc. UAP
 * Copyright: 2013 UFIDA Inc. All rights reserved.
 * @author pujie
 * @Date 2013-4-25 上午8:44:26
 * @version
 */

public class UMEditText extends EditText {
    
    public int id;
    public String type;
    public Object element;
    public boolean display;
    public boolean visible;
    public boolean enabled;
    public String height;
    public String width;
    
  
    
    
    
    // TODO add some properties

    public UMEditText(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public UMEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public UMEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

}