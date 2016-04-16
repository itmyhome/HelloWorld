package com.hello.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**   
 * @Title: BootCompleteReceiver.java 
 * @Package com.hello.helloworld 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author itmyhome   
 * @date 2016年2月21日 下午10:53:57 
 * @version V1.0   
 */
public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "我是静态注册", Toast.LENGTH_LONG).show();
	}

}


