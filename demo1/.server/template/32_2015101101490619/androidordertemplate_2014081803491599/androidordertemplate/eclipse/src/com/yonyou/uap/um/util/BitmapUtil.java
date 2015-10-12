package com.yonyou.uap.um.util;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * 
 * Project: UMP Function Description:bmp util Company: UFIDA Inc. UAP Copyright:
 * 2013 UFIDA Inc. All rights reserved.
 * 
 * @author pujie
 * @Date 2013-4-25 上午8:46:01
 * @version
 */
public class BitmapUtil {

    public static String DEFAULT_BMP_SRC_PATH = "com.yonyou.uap.um.drawable";
    /**
     * 获取bitmap drawable
     * @param srcPath
     * @param bmpFileName
     * @return
     */
    public static Drawable getDrawableFromSrc(String srcPath, String bmpFileName) {
        if (bmpFileName == null || "".equalsIgnoreCase(bmpFileName)) {
            return null;
        }
        if (srcPath == null || "".equalsIgnoreCase(srcPath)) {
            srcPath = DEFAULT_BMP_SRC_PATH.replace(".", "/") + "/" + bmpFileName;
        } else {
            srcPath = srcPath.replace(".", "/") + "/" + bmpFileName;
        }
        BitmapDrawable db = null;
        InputStream is = null;
        try {
            is = BitmapUtil.class.getClassLoader().getResourceAsStream(srcPath);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            db = new BitmapDrawable(null, bitmap);
            is.close();
        } catch (IOException e) {
            Log.w("Read UM Drawable", e.getMessage());
        } finally {
            if (is != null) {
                is = null;
            }
        }
        return db;

    }

    /**
     * 获取bitmap
     * @param srcPath
     * @param bmpFileName
     * @return
     */
    public static Bitmap getBitmapFromSrc(String srcPath, String bmpFileName) {
        if (bmpFileName == null || "".equalsIgnoreCase(bmpFileName)) {
            return null;
        }
        if (srcPath == null || "".equalsIgnoreCase(srcPath)) {
            srcPath = DEFAULT_BMP_SRC_PATH.replace(".", "/") + "/" + bmpFileName;
        } else {
            srcPath = srcPath.replace(".", "/") + "/" + bmpFileName;
        }
        InputStream is = null;
        Bitmap bitmap = null;
        try {
            is = BitmapUtil.class.getClassLoader().getResourceAsStream(srcPath);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            Log.w("Read UM Bitmap", e.getMessage());
        } finally {
            if (is != null) {
                is = null;
            }
        }
        return bitmap;
    }
}