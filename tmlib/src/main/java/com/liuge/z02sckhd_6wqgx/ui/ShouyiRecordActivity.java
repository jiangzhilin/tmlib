package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.ShouyiRecordAdapter;
import com.liuge.z02sckhd_6wqgx.entity.ShouyiEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

import static android.content.ContentValues.TAG;

public class ShouyiRecordActivity extends BaseActivity {

    private TextView tv_daishenhe;
    private TextView tv_shenhe;
    private NoScroListView gv_Goods;
    private SmoothRefreshLayout refreshLayout;

    int p=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_shouyi_record);
        setTitle("我的收益");
        setBack();
    }

    @Override
    protected void initData() {
        initView();
        refreshLayout.setMode(SmoothRefreshLayout.MODE_BOTH);
        refreshLayout.setHeaderView(new ClassicHeader(this));
        refreshLayout.setFooterView(new ClassicFooter(this));
        refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(refreshLayout.isRefreshing()){
                    p=1;
                    getShouyi(""+11);
                }
                if(refreshLayout.isLoadingMore()){
                    p++;
                    getShouyi(""+11);
                }
            }
        });
        getShouyi(""+11);
    }

    private void getShouyi(String type){
        LoadDialog.show(mContext);
        new ApiManager().getShouyi(type, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                ShouyiEntity base= JSONObject.parseObject(result,ShouyiEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                ShouyiRecordAdapter adapter=new ShouyiRecordAdapter(mContext);
                gv_Goods.setAdapter(adapter);
                adapter.setmList(base.getData().getResult());
                tv_daishenhe.setText(base.getData().getWait());
                tv_shenhe.setText(base.getData().getOk());
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
                if(refreshLayout.isRefreshing()){
                    refreshLayout.refreshComplete();
                }
                if(refreshLayout.isLoadingMore()){
                    refreshLayout.refreshComplete();
                }
            }
        });
    }

    private void initView() {
        tv_daishenhe = (TextView) findViewById(R.id.tv_daishenhe);
        tv_shenhe = (TextView) findViewById(R.id.tv_shenhe);
        gv_Goods = (NoScroListView) findViewById(R.id.gv_Goods);
        refreshLayout = (SmoothRefreshLayout) findViewById(R.id.smoothRefreshLayout);
    }
}
