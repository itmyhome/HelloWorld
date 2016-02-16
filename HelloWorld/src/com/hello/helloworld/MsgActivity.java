package com.hello.helloworld;

import java.util.ArrayList;
import java.util.List;

import com.hello.helloworld.msg.Msg;
import com.hello.helloworld.msg.MsgAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MsgActivity extends Activity {

	
	private Button send;
	
	private EditText inputText;
	
	private MsgAdapter adapter;

	private List<Msg> msgList = new ArrayList<Msg>();
	
	private ListView msgListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.msg_activity);
		
		
		send = (Button) findViewById(R.id.send);
        inputText = (EditText) findViewById(R.id.input_text);
        initMsgs();
        adapter = new MsgAdapter(MsgActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
        send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if (!"".equals(content)) {
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");
				}
			}
		});
	}
	
	private void initMsgs() {
		Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
	}

}
