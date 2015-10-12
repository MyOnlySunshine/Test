package com.yonyou.uap.um.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.yonyou.uap.um.model.ControlDataModel;

import android.util.Log;

public class JSONUtil {

    public static final String JSON_NAME_SPLIT = ".";
    public static final String JSON_ARRAY_START = "[";
    public static final String JSON_ARRAY_END = "]";
    public static final String CONTROL_DATA = "data";
    public static final String CONTROL_USERDATA = "userdata";
    public static final String CONTROL_INITDATA = "initdata";
    public static final String CONTROL_INITDATA_TYPE = "type";
    public static final String CONTROL_INITDATA_BINDINGINFO = "bindinginfo";
    public static final String CONTROL_INITDATA_BINDINGINFO_JCONTROLID = "jcontrolid";

    public static Object getValueBySplitName(JSONObject jObject, String name) {
        Object valueObject = null;
        if (jObject == null || name == null || "".equalsIgnoreCase(name)) {
            return null;
        }
        String[] splitNames = name.split(JSON_NAME_SPLIT);
        if (splitNames.length <= 1) {
            try {
                valueObject = jObject.get(name);
            } catch (JSONException e) {
                Log.v("JSONUtil", "Get value from JSONObject by name =" + name + "is error!");
                throw new RuntimeException("JSONUtil Exception!");
            }
        } else {
            JSONObject tempObject = null;
            try {
                if (isArray(splitNames[0])) {
                    tempObject = (JSONObject) jObject.getJSONArray(splitNames[0]).get(getIndexByName(splitNames[0]));
                } else {
                    tempObject = jObject.getJSONObject(splitNames[0]);
                }
                valueObject = getValueBySplitName(tempObject, name.substring(splitNames[0].length() - 1));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                throw new RuntimeException("JSONUtil Exception!");
            }

        }

        return valueObject;

    }

    /**
     * 检查名称是否为数组
     * 
     * @param name
     * @return
     */

    public static boolean isArray(String name) {
        if (name == null || "".equalsIgnoreCase(name)) {
            return false;
        }
        int arrayStartIndex = name.indexOf(JSON_ARRAY_START);
        int arrayEndIndex = name.indexOf(JSON_ARRAY_END);
        if (arrayStartIndex > 0 && arrayEndIndex > 0 && arrayStartIndex < arrayEndIndex) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回[n]中n的值
     * 
     * @param name
     * @return
     */
    public static int getIndexByName(String name) {
        if (name == null || "".equalsIgnoreCase(name)) {
            return -1;
        }
        int arrayStartIndex = name.indexOf(JSON_ARRAY_START);
        int arrayEndIndex = name.indexOf(JSON_ARRAY_END);
        return Integer.parseInt(name.substring(arrayStartIndex, arrayEndIndex));
    }

    public static ControlDataModel covertToControlDataModel(JSONObject jObject) {
        if (jObject == null) {
            return null;
        }
        ControlDataModel controlModel = new ControlDataModel();

        return controlModel;
    }

}
