package com.liuge.TMShop.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.MineOrderAdapter;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.entity.MineOrderEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.LoadDialog;

import org.xutils.common.Callback;

public class MineOrderActivity extends BaseActivity {

    private TabLayout tab;
    private ListView list;

    private int order_statue=11;

    MineOrderAdapter mAdapter;

    public static MineOrderActivity instence;

    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_order);

    }

    @Override
    protected void initData() {
        setBack();
        setTitle("我的订单");
        instence=this;
        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        list = (ListView) findViewById(R.id.list);

//        tab.addTab(tab.newTab().setText("全部"),0);
        tab.addTab(tab.newTab().setText("待付款"),0);
        tab.addTab(tab.newTab().setText("待发货"),1);
        tab.addTab(tab.newTab().setText("待收货"),2);
        tab.addTab(tab.newTab().setText("待评价"),3);
        tab.addTab(tab.newTab().setText("已完成"),4);
//        tab.addTab(tab.newTab().setText("取消"),5);

        mAdapter=new MineOrderAdapter(mContext);
        list.setAdapter(mAdapter);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        order_statue=11;
                        break;
                    case 1:
                        order_statue=20;
                        break;
                    case 2:
                        order_statue=30;
                        break;
                    case 3:
                        order_statue=40;
                        break;
                    case 4:
                        order_statue=40;
                        break;
//                    case 5:
//                        order_statue=-1;
//                        break;
                }
                position=tab.getPosition();
                mineOrer();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mineOrer();
    }

    private void mineOrer(){
        LoadDialog.show(mContext);
        new ApiManager().mineOrder(order_statue, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("order", "onSuccess: "+result);
                MineOrderEntity entity= JSONObject.parseObject(result,MineOrderEntity.class);
                mAdapter.setEntity(entity,position);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                mAdapter.setEntity(null,position);
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

    public void cancal(String mid){
        LoadDialog.show(mContext);
        new ApiManager().cancal(mid, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                mineOrer();
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

    @Override
    protected void onResume() {
        super.onResume();
        mineOrer();
    }
}
