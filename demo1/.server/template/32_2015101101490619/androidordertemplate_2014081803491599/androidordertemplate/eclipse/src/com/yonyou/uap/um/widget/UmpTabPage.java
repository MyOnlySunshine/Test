package com.yonyou.uap.um.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

public class UmpTabPage extends LinearLayout {

	private String tag;
	private String text;
	private int image = -1;
	private int selectImage = -1;
	
	public UmpTabPage(Context context) {
		super(context);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getText() {
		if(text==null || text.length()<1) {
			return "";
		}
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getImage() {
		if(image==-1) {
			//返回一个默认的样式，但没找到合适的默认样式
			//return android.R.drawable.bottom_bar;
		}
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}
	
	public void setImageResource(int image) {
		setImage(image);
	}

	public int getSelectImage() {
		if(selectImage==-1) {
			return getImage();
		}
		return selectImage;
	}

	public void setSelectImage(int selectImage) {
		this.selectImage = selectImage;
	}

	public Drawable getImageObject(Resources resource) {
		if(getImage()==-1) {
			return null;
		}
		return resource.getDrawable(getImage());
	}
	
	public Drawable getSelectedImageObject(Resources resource) {
		if(getSelectImage()==-1) {
			return null;
		}
		return resource.getDrawable(getSelectImage());
	}
	
}
