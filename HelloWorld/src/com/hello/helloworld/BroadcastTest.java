package com.hello.helloworld;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**   
 * @Title: BroadcastTest.java 
 * @Package com.hello.helloworld 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2016年2月21日 下午9:18:59 
 * @version V1.0   
 */
public class BroadcastTest extends Activity{
	
	private IntentFilter intentFilter;
	
	private NetworkChangeReceiver net;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broad_cast);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        net = new NetworkChangeReceiver();
        registerReceiver(net, intentFilter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(net);
	}
	
	class NetworkChangeReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			
			NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
			
			if(networkInfo != null && networkInfo.isAvailable()){
				
				Toast.makeText(context, "network is Available", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(context, "network is UnAvailable", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}


