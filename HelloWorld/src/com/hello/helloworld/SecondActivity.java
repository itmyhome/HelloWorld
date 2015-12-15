package com.hello.helloworld;

import android.content.Context;
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
public class SecondActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity", "task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		
		Intent intent = getIntent();
		Toast.makeText(SecondActivity.this, intent.getStringExtra("param1"),
				Toast.LENGTH_SHORT).show();
		
		
		Button button2 = (Button) findViewById(R.id.button2);
		
		
		button2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//				intent.putExtra("data_return", "i am back");
//				setResult(RESULT_OK, intent);
//				finish();
				startActivity(intent);
			}
			
		});
		
	}
	
	public static void actionStart(Context context, String data1, String data2){
		Intent intent = new Intent(context, SecondActivity.class);
		intent.putExtra("param1", data1);
		intent.putExtra("param2", data2);
		context.startActivity(intent);
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
			Toast.makeText(SecondActivity.this, "you click add_item",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(SecondActivity.this, "you click remove_item",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("data_return", "i am back from secondActivity");
		setResult(RESULT_OK, intent);
		finish();
	}

}
