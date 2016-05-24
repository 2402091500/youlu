package com.example.ui;



import com.example.biz.CallLogsBiz;
import com.example.biz.ContactBiz;
import com.example.biz.MsgBiz;
import com.example.entity.CallLogs;
import com.example.entity.Contact;
import com.example.entity.Msg;
import com.example.listener.MyPhoneListener;
import com.example.youlu.R;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.List;

public class myAnimation extends Activity {

	public ImageView im1;
	public static List<CallLogs> logs;
	public static List<Contact> cs;
	public static List<Msg> msgs;
	//private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		new Thread(new Runnable() {
			@Override
			public void run() {
				logs=new CallLogsBiz(myAnimation.this).loadCallLogs();
				cs=new ContactBiz(myAnimation.this).loadContacts();
				msgs=new MsgBiz(myAnimation.this).loadMsgs();
			}
		}).start();
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			Intent intent=new Intent(myAnimation.this,MainActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.translate2, R.anim.translate);
			myAnimation.this.finish();
			}
		}, 2000);

	}





}
