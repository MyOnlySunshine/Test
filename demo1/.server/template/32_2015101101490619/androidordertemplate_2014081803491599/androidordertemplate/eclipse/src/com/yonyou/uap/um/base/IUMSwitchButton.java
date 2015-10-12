package com.yonyou.uap.um.base;

public interface IUMSwitchButton {
	void on(); // open

	void off(); // close

	void setOnImageResource(int res);

	void setOffImageResource(int res);

	boolean isOn();
	
	void switch_();
}
