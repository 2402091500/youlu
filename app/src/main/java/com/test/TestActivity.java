package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.youlu.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends Activity {

    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.bt)
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        x.Ext.init(getApplication());

    }

    @OnClick(R.id.bt)
    public void onClick() {
        RequestParams params=new RequestParams("http://apis.juhe.cn/mobile/get");

//        phone 	int 	是 	需要查询的手机号码或手机号码前7位
//        key 	string 	是 	应用APPKEY(应用详细页查询)
//                dtype
        params.addBodyParameter("phone","18725773513");
        params.addBodyParameter("key","57c3900f395278cab3611035c1a25fd7");
        params.addBodyParameter("dtype","");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Log.d("请求数据成功",s);
                tv.setText(s);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                tv.setText(throwable.getMessage());
            }

            @Override
            public void onCancelled(CancelledException e) {
                tv.setText(e.getMessage());
            }

            @Override
            public void onFinished() {
//                        tv.setText("finish");
            }
        });
    }
}
