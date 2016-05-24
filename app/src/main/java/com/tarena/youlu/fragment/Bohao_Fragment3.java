package com.tarena.youlu.fragment;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dao.daoAll;
import com.example.listener.MyPhoneListener;
import com.example.youlu.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class Bohao_Fragment3 extends Fragment {
	private View view;
	private Animation ani;
	int b=1;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button bt10;
	private Button bt11;
	private Button bt12;
	private Button bt13;



	private TextView haoma;

	private ImageView del;

	private TableLayout table;
	private TextView tv_guisu;

	public void ContactFragment3(){

		haoma=(TextView)view.findViewById(R.id.haoma);
		haoma.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void afterTextChanged(Editable editable) {
             if(haoma.getText().toString().length()==8){
				 System.out.println("瞄瞄");
				 getData(haoma.getText().toString());
			 }
			}
		});
		tv_guisu=(TextView)view.findViewById(R.id.tv99);
		del=(ImageView)view.findViewById(R.id.del);

		
		bt1=(Button)view.findViewById(R.id.bt1);
		bt2=(Button)view.findViewById(R.id.bt2);
		bt3=(Button)view.findViewById(R.id.bt3);
		bt4=(Button)view.findViewById(R.id.bt4);
		bt5=(Button)view.findViewById(R.id.bt5);
		bt6=(Button)view.findViewById(R.id.bt6);
		bt7=(Button)view.findViewById(R.id.bt7);
		bt8=(Button)view.findViewById(R.id.bt8);
		bt9=(Button)view.findViewById(R.id.bt9);
		bt10=(Button)view.findViewById(R.id.bt10);
		bt11=(Button)view.findViewById(R.id.bt11);
		bt12=(Button)view.findViewById(R.id.bt12);
		bt13=(Button)view.findViewById(R.id.bt13);
		table=(TableLayout)view.findViewById(R.id.tablelay);
		
		bt1.setOnClickListener(new daoAll(bt1, haoma));
		bt2.setOnClickListener(new daoAll(bt2, haoma));
		bt3.setOnClickListener(new daoAll(bt3, haoma));
		bt4.setOnClickListener(new daoAll(bt4, haoma));
		bt5.setOnClickListener(new daoAll(bt5, haoma));
		bt6.setOnClickListener(new daoAll(bt6, haoma));
		bt7.setOnClickListener(new daoAll(bt7, haoma));
		bt8.setOnClickListener(new daoAll(bt8, haoma));
		bt9.setOnClickListener(new daoAll(bt9, haoma));
		bt10.setOnClickListener(new daoAll(bt10, haoma));
		bt11.setOnClickListener(new daoAll(bt11, haoma));
		bt12.setOnClickListener(new daoAll(bt12, haoma));


		haoma.setOnClickListener(new OnClickListener() {
			

		

			@Override
			public void onClick(View v) {
					if(b%2!=0){
						table.setVisibility(View.VISIBLE);
						ani=AnimationUtils.loadAnimation(getActivity(), R.anim.bohao_ani);
						
						table.startAnimation(ani);
						b++;
					}else if(b%2==0){
						table.clearAnimation();
						table.setVisibility(View.GONE);
						b++;
					}
					
				
			}
		});
		bt13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+haoma.getText().toString()));
				startActivity(intent);
				
			}
		});
		
		del.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				haoma.setText("");
				return false;
			}
		});
		del.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String s=haoma.getText().toString();
				int l=s.length();
				if(l<=1){
					haoma.setText("");
				}else{
					
					haoma.setText(s.substring(0, l-1));
				}
			}
		});
	}

	private void getData(String s) {
		RequestParams params=new RequestParams("http://apis.juhe.cn/mobile/get");

//        phone 	int 	是 	需要查询的手机号码或手机号码前7位
//        key 	string 	是 	应用APPKEY(应用详细页查询)
//                dtype
		params.addBodyParameter("phone",s);
		params.addBodyParameter("key","57c3900f395278cab3611035c1a25fd7");
		params.addBodyParameter("dtype","");
		x.http().get(params, new Callback.CommonCallback<String>() {
			@Override
			public void onSuccess(String s) {
				Log.d("请求数据成功",s);
				tv_guisu.setText(s);
				Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onError(Throwable throwable, boolean b) {
				Toast.makeText(getActivity(),"2",Toast.LENGTH_SHORT).show();
//				tv_guisu.setText(throwable.getMessage());
			}

			@Override
			public void onCancelled(CancelledException e) {
				Toast.makeText(getActivity(),"3",Toast.LENGTH_SHORT).show();
//				tv_guisu.setText(e.getMessage());
			}

			@Override
			public void onFinished() {
				Toast.makeText(getActivity(),"4",Toast.LENGTH_SHORT).show();
//                        tv.setText("finish");
			}
		});
	}


	@Override
	public View onCreateView(LayoutInflater inflater, 
			ViewGroup container,
			Bundle savedInstanceState) {
		 view=inflater.inflate(R.layout.fragment_contact3, null);
		   TelephonyManager manager=(TelephonyManager)getActivity().getSystemService(Context.TELEPHONY_SERVICE);
		    manager.listen(new MyPhoneListener(getActivity()), PhoneStateListener.LISTEN_CALL_STATE);
		    ContactFragment3();
		return view;
	}
}
