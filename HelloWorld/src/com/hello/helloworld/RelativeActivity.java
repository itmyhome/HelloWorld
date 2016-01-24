package com.hello.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

/**
 * 
 * @author Administrator
 *
 */
public class RelativeActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("RelativeActivity", "task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.relative_layout);
	}
	

}
