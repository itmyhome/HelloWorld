package com.hello.helloworld;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends BaseActivity implements OnClickListener{

	public static final String TAG = "MainActivity";
	
	private Button button;
	
	private Button progressDialogButton;
	
	private EditText editText;
	
	private ImageView imageView;
	
	private ProgressBar progressBar;
	
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
        Button getEditText = (Button) findViewById(R.id.get_edit_text);
        
//        button = (Button) findViewById(R.id.test_process);
        progressDialogButton = (Button) findViewById(R.id.get_progress_dialog);
//        imageView = (ImageView) findViewById(R.id.image_view);
//        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        getEditText.setOnClickListener(this);
//        button.setOnClickListener(this);
        progressDialogButton.setOnClickListener(this);
        
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        startNormalActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, NormalActivity.class);
				startActivity(intent);
			}
		});
//        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
//        startDialogActivity.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(MainActivity.this, DialogActivity.class);
//				startActivity(intent);
//			}
//		});
//        Log.d("MainActivity", this.toString());
//        Button firstDialogActivity = (Button) findViewById(R.id.start_first_activity);
//        firstDialogActivity.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				String str = "go to first activity";
//				Intent intent = new Intent(MainActivity.this, FirstActivity.class);
//				intent.putExtra("extra_data", str);
//				startActivity(intent);
////				startActivityForResult(intent, 1);
//			}
//			
//		});
        
//        Button secondDialogActivity = (Button) findViewById(R.id.go_to_second_activity);
//        secondDialogActivity.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				String str = "go to second activity";
//				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//				intent.putExtra("extra_data", str);
//				startActivity(intent);
////				startActivityForResult(intent, 1);
//			}
//		});
        
//        Button bundleActivity = (Button) findViewById(R.id.test_bundle);
//        
//        bundleActivity.setOnClickListener(new OnClickListener() {
//        	
//			@Override
//			public void onClick(View v) {
//				next();
//			}
//		});
        
        
    }
    
    public void onClick(View v){
    	switch (v.getId()) {
    	case R.id.get_progress_dialog:
    		ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
    		progressDialog.setTitle("this is a progress dialog");
    		progressDialog.setMessage("loading");
    		progressDialog.setCancelable(true);
    		progressDialog.show();
    		break;
		case R.id.get_edit_text:
			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
			dialog.setTitle("gagagagaga");
			dialog.setMessage("gaewqeqeqw");
			dialog.setCancelable(false);
			dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});	
			dialog.show();
//			editText = (EditText) findViewById(R.id.edit_view);
//			Toast.makeText(MainActivity.this, editText.getText().toString(),
//					Toast.LENGTH_SHORT).show();
//			imageView.setImageResource(R.drawable.test);
			break;
//		case R.id.test_process:
//			int progress = progressBar.getProgress();
//			progress += 10;
//			progressBar.setProgress(progress);
//			if(progressBar.getVisibility() == View.GONE){
//				progressBar.setVisibility(View.VISIBLE);
//			}else{
//				progressBar.setVisibility(View.GONE);
//			}
//			break;
		default:
			break;
		}
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
