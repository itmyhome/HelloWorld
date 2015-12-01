package com.hello.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**   
 * @Title: BundleActivity.java 
 * @Package com.hello.helloworld 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2015年11月28日 下午8:40:42 
 * @version V1.0   
 */
public class BundleActivity extends Activity{
	private Bundle b ;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bundle_layout);
        Intent i = getIntent();
        b = i.getExtras();
        Toast.makeText(BundleActivity.this, b.getString("String"),
				Toast.LENGTH_SHORT).show();
        
        Button bundleActivity = (Button) findViewById(R.id.go_to_third_activity);
        
        bundleActivity.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				next();
			}
		});
	}
	
	private void next(){
		Intent i = new Intent(BundleActivity.this, ThirdActivity.class);
		i.putExtras(b);
		startActivity(i);
	}
}


