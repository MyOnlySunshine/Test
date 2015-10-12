//package com.yonyou.uap.um.test;
//
//import com.yonyou.uap.um.base.UMTabGroup;
//import com.yonyou.uap.um.base.UMTabGroup.OnChangedViewListener;
//import com.yonyou.uap.um.control.UMTabImage;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//public class UMLinearLayoutTest extends Activity {
//
//	private UMTabImage img1;
//	private UMTabImage img2;
//	private UMTabImage img3;
//	private UMTabImage img4;
//	private UMTabGroup umLayout;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//
//		umLayout = new UMTabGroup(this);
//		umLayout.setLayoutParams(new LinearLayout.LayoutParams(200, 100));
//		img1 = new UMTabImage(this);
//		img2 = new UMTabImage(this);
//		img3 = new UMTabImage(this);
//		img4 = new UMTabImage(this);
//		umLayout.addView(img1);
//		umLayout.addView(img2);
//		umLayout.addView(img3);
//		umLayout.addView(img4);
//		umLayout.setOnChangedViewListener(new OnChangedViewListener() {
//
//			@Override
//			public void onChangedView(View v) {
//				if (img1 == v) {
//					Toast.makeText(UMLinearLayoutTest.this, "select img1",
//							Toast.LENGTH_SHORT).show();
//				}
//				if (img2 == v) {
//					Toast.makeText(UMLinearLayoutTest.this, "select img2",
//							Toast.LENGTH_SHORT).show();
//				}
//				if (img3 == v) {
//					Toast.makeText(UMLinearLayoutTest.this, "select img3",
//							Toast.LENGTH_SHORT).show();
//				}
//				if (img4 == v) {
//					Toast.makeText(UMLinearLayoutTest.this, "select img4",
//							Toast.LENGTH_SHORT).show();
//				}
//			}
//		});
//
//		setContentView(umLayout);
//
//	}
//
//}