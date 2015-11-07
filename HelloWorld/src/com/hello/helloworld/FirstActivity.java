package com.hello.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * @Title: FirstActivity.java
 * @Package com.hello.helloworld
 * @Description: TODO(用一句话描述该文件做什么)
 * @author itmyhome
 * @date 2015年11月5日 下午10:12:33
 * @version V1.0
 */
public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
		Button button1 = (Button) findViewById(R.id.button1);

		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
//				Toast.makeText(FirstActivity.this, "you click button1",
//						Toast.LENGTH_SHORT).show();
				//销毁一个活动
//				finish();
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
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
			Toast.makeText(FirstActivity.this, "you click add_item",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(FirstActivity.this, "you click remove_item",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return true;
	}

}
