package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.TixianRecordAdapter;
import com.liuge.z02sckhd_6wqgx.entity.ShouyiEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

import static android.content.ContentValues.TAG;

public class TixianRecordActivity extends BaseActivity {

    private TextView tv_daishenhe;
    private TextView tv_shenhe;
    private NoScroListView gv_Goods;
    private SmoothRefreshLayout refreshLayout;

    public static TixianRecordActivity instance;

    int p=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_tixian_record);
        setTitle("提现记录");
        setBack();
    }

    @Override
    protected void initData() {
        initView();
        instance=this;
        refreshLayout.setMode(SmoothRefreshLayout.MODE_BOTH);
        refreshLayout.setHeaderView(new ClassicHeader(this));
        refreshLayout.setFooterView(new ClassicFooter(this));
        refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(refreshLayout.isRefreshing()){
                    p=1;
                    getShouyi(""+2);
                }
                if(refreshLayout.isLoadingMore()){
                    p++;
                    getShouyi(""+2);
                }
            }
        });
    }

    public void getShouyi(String type){
        LoadDialog.show(mContext);
        new ApiManager().getShouyi(type, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                ShouyiEntity base= JSONObject.parseObject(result,ShouyiEntity.class);
//                NToast.shortToast(mContext,base.getMsg());
                tv_daishenhe.setText(SixGridContext.RMB+base.getData().getWait());
                tv_shenhe.setText(SixGridContext.RMB+base.getData().getOk());
                TixianRecordAdapter adapter=new TixianRecordAdapter(mContext);
                gv_Goods.setAdapter(adapter);
                adapter.setmList(base.getData().getResult());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
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

        getShouyi(""+2);
    }
}
