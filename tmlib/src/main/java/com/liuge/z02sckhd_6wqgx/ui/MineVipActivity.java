package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.VipAdapter;
import com.liuge.z02sckhd_6wqgx.entity.VipEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

public class MineVipActivity extends BaseActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_mine_vip);
    }

    @Override
    protected void initData() {
        setTitle("我的会员");
        setBack();
        initView();
        mineVip();
    }

    private void mineVip() {
        LoadDialog.show(mContext);
        new ApiManager().mineVip(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("vip会员" + result);
                VipEntity vip= JSONObject.parseObject(result,VipEntity.class);
                VipAdapter adapter=new VipAdapter(mContext);
                list.setAdapter(adapter);
                adapter.setmList(vip.getData().getResult());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    private void initView() {
        list = (ListView) findViewById(R.id.list);
    }
}
