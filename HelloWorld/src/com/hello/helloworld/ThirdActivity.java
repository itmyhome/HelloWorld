package com.hello.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * @Title: SecondActivity.java
 * @Package com.hello.helloworld
 * @Description: TODO(用一句话描述该文件做什么)
 * @author itmyhome
 * @date 2015年11月5日 下午10:12:33
 * @version V1.0
 */
public class ThirdActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("ThirdActivity", "task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
//		Intent i = super.getIntent();
//        Bundle b = i.getExtras();
//        Toast.makeText(ThirdActivity.this, b.getString("String"),
//				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(ThirdActivity.this, "you click add_item",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(ThirdActivity.this, "you click remove_item",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return true;
	}

}
