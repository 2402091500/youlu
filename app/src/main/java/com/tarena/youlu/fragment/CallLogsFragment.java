package com.tarena.youlu.fragment;


import java.util.List;

import com.example.biz.CallLogsBiz;
import com.example.entity.CallLogs;
import com.example.ui.myAnimation;
import com.example.youlu.R;
import com.tarena.youlu.adapter.CallLogsListViewAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 *
 */
public class CallLogsFragment extends BaseFragment{
	
	private ListView lvCallLogs;
	private CallLogsListViewAdapter adapter;
	private List<CallLogs> log;

	/*@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_calllog, null);
		//��ȡ����
		List<CallLogs> logs=new CallLogsBiz(getActivity()).loadCallLogs();

//		System.out.println("--------"+logs);
		CallLogsListViewAdapter adapter=
				new CallLogsListViewAdapter(getActivity(), logs);
		lvCallLogs=(ListView)view.findViewById(R.id.lvCallLogs);
		lvCallLogs.setAdapter(adapter);
		return view;
	}
	*/

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_calllog;
	}

	@Override
	protected void initView() {
		lvCallLogs=findView(R.id.lvCallLogs);
	}

	@Override
	protected void initData() {

		//��ȡ����
		 log= myAnimation.logs;

		 adapter=new CallLogsListViewAdapter(getActivity(), log);
		lvCallLogs.setAdapter(adapter);
	}

	@Override
	protected void showDate() {
		if(adapter==null){

		 adapter=new CallLogsListViewAdapter(getActivity(), log);
		lvCallLogs.setAdapter(adapter);
		}else{
		lvCallLogs.setAdapter(adapter);

		}
	}
}
