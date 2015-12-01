package com.hello.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        if(savedInstanceState != null){
        	String tempData = savedInstanceState.getString("data_key");
        	Log.i(TAG, tempData);
        	Toast.makeText(MainActivity.this, tempData,
					Toast.LENGTH_SHORT).show();
        }
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        startNormalActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				startActivity(intent);
			}
		});
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startDialogActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
				startActivity(intent);
			}
		});
        Log.d("MainActivity", this.toString());
        Button firstDialogActivity = (Button) findViewById(R.id.start_first_activity);
        firstDialogActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = "go to first activity";
				Intent intent = new Intent(MainActivity.this, FirstActivity.class);
				intent.putExtra("extra_data", str);
				startActivity(intent);
//				startActivityForResult(intent, 1);
			}
			
		});
        
        Button secondDialogActivity = (Button) findViewById(R.id.go_to_second_activity);
        secondDialogActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = "go to second activity";
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", str);
				startActivity(intent);
//				startActivityForResult(intent, 1);
			}
		});
        
        Button bundleActivity = (Button) findViewById(R.id.test_bundle);
        
        bundleActivity.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				next();
			}
		});
        
        
    }
    
    private void next(){
    	Intent i = new Intent(MainActivity.this, BundleActivity.class);
    	Bundle b = new Bundle();
        b.putInt("int", 1000);
        b.putString("String", "测试");
        b.putChar("char", 'c');
        i.putExtras(b);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		String tempData = "something you just typed";
		outState.putString("data_key", tempData);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i("come in", String.valueOf(requestCode));
		switch (requestCode) {
		case 1:
			if(resultCode == RESULT_OK){
				Toast.makeText(MainActivity.this, data.getStringExtra("data_return"),
						Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}
	
	
}
