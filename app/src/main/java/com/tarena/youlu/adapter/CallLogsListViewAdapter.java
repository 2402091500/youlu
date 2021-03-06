package com.tarena.youlu.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.entity.CallLogs;
import com.example.youlu.R;


import android.content.Context;
import android.graphics.Color;
import android.provider.CallLog.Calls;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CallLogsListViewAdapter extends BaseAdapter{
	
	private Context context;
	private List<CallLogs> logs;
	private LayoutInflater inflater;
	public CallLogsListViewAdapter(Context context, List<CallLogs> logs) {
		this.context=context;
		this.logs=logs;
		inflater=LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return logs.size();
	}

	@Override
	public Object getItem(int position) {
		return logs.get(position);
	}

	@Override
	public long getItemId(int position) {
		return logs.get(position).getId();
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.lv_calllog_item, null);
			holder.iv=(ImageView)convertView.findViewById(R.id.callLogPhoto);
			holder.tvName=(TextView)convertView.findViewById(R.id.tvUserName);
			holder.tvNumber=(TextView) convertView.findViewById(R.id.tvNumber);
			holder.tvTime=(TextView)convertView.findViewById(R.id.tvTime);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder)convertView.getTag();
		}
		CallLogs log=logs.get(position);
		holder.tvName.setText(log.getName()==null ? "没有备注" : log.getName());

		if(log.getType()==Calls.MISSED_TYPE){
			holder.tvNumber.setTextColor(Color.RED);
		}
		if(log.getNumber().length()>11&&!log.getNumber().startsWith("0")){
			String number=log.getNumber().substring(0,log.getNumber().length()-11)+" + "+log.getNumber().substring(log.getNumber().length()-11,log.getNumber().length()-1);
		    holder.tvNumber.setText(number);
		}else{
			holder.tvNumber.setText(log.getNumber());
		}
		holder.tvTime.setText(new SimpleDateFormat("yyyy年MM月dd日 hh:mm").format(new Date(log.getTime())));
		holder.iv.setImageResource(R.drawable.baozou);
		return convertView;
	}

	private static class ViewHolder {
		ImageView iv;
		TextView tvName;
		TextView tvNumber;
		TextView tvTime;
	}
	
}



