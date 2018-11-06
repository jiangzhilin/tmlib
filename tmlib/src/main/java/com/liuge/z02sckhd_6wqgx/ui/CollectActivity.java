package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.GridView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.CollectGoodsAdapter;
import com.liuge.z02sckhd_6wqgx.adapter.CollectMallsAdapter;
import com.liuge.z02sckhd_6wqgx.entity.CollectGoodsEntity;
import com.liuge.z02sckhd_6wqgx.entity.CollectMallEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

public class CollectActivity extends BaseActivity {

    private TabLayout tab;
    private GridView gv;

    public static CollectActivity instance;

    int type=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_collect);
        instance=this;
        initView();
    }

    @Override
    protected void initData() {
        setTitle("我的收藏");
        setBack();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        gv = (GridView) findViewById(R.id.gv);

        tab.addTab(tab.newTab().setText("商品"),0);
        tab.addTab(tab.newTab().setText("商家"),1);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 switch (tab.getPosition()){
                     case 0:
                         type=1;
                         break;
                     case 1:
                         type=2;
                         break;
                 }
                MineCollect();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        MineCollect();
    }

    public void MineCollect(){
        LoadDialog.show(mContext);
        new ApiManager().getCollect(type + "", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("MineCollect", "onSuccess: "+result);
                if(type==1){
                    CollectGoodsEntity goods= JSONObject.parseObject(result,CollectGoodsEntity.class);
                    CollectGoodsAdapter mAdapter=new CollectGoodsAdapter(mContext);
                    gv.setAdapter(mAdapter);
                    mAdapter.setGoods(goods);
                }else{
                    CollectMallEntity mall=JSONObject.parseObject(result,CollectMallEntity.class);
                    CollectMallsAdapter mAdpater=new CollectMallsAdapter(mContext);
                    gv.setAdapter(mAdpater);
                    mAdpater.setGoods(mall);
                }
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
}
