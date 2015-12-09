package com.hello.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**   
 * @Title: BaseActivity.java 
 * @Package com.hello.helloworld 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2015年11月30日 下午10:23:55 
 * @version V1.0   
 */
public class BaseActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("BaseActivity", getClass().getSimpleName());
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	
	

}


