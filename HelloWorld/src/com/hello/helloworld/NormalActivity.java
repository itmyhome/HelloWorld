package com.hello.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**   
 * @Title: NormalActivity.java 
 * @Package com.hello.helloworld 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2015年11月27日 下午9:17:07 
 * @version V1.0   
 */
public class NormalActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.normal_layout);
	}
}


