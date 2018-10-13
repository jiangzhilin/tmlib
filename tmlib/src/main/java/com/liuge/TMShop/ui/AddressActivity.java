package com.liuge.TMShop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.AddressAdapter;
import com.liuge.TMShop.entity.AddressEntity;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.AddressDialog;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroListView;

import org.xutils.common.Callback;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

public class AddressActivity extends BaseActivity {

    private NoScroListView list;
    private SmoothRefreshLayout refreshLayout;

    AddressAdapter mAdapter;
    AddressEntity add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        setBack();
        setTitle("收货地址");
        setRight("新增", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,EditAddressActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        initView();
        refreshLayout.setMode(SmoothRefreshLayout.MODE_REFRESH);
        refreshLayout.setHeaderView(new ClassicHeader(this));
//        refreshLayout.setFooterView(new ClassicFooter(this));
        refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(refreshLayout.isRefreshing()){
                    getAddress();
                }
            }
        });

        mAdapter=new AddressAdapter(mContext);
        list.setAdapter(mAdapter);

        mAdapter.setDel(new AddressAdapter.del() {
            @Override
            public void del(int position) {
                if(add!=null){
                    deladd(""+add.getData().get(position).getAddress_id());
                }
            }
        });

        mAdapter.setBeDef(new AddressAdapter.beDef() {
            @Override
            public void def(int position) {
                if(add!=null){
                    beDef(""+add.getData().get(position).getAddress_id());
                }
            }
        });

        mAdapter.setEdit(new AddressAdapter.edit() {
            @Override
            public void edit(int position) {
                if(add!=null){
                    Intent intent=new Intent(mContext,EditAddressActivity.class);
                    intent.putExtra("address",add.getData().get(position));
                    startActivity(intent);
                }
            }
        });

        getAddress();
    }

    private void beDef(String id){
        LoadDialog.show(mContext);
        new ApiManager().beDef(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                if(base.getStatus().equals("success")){
                    getAddress();
                }else{
                    NToast.shortToast(mContext,base.getMsg());
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

    private void deladd(String id){
        LoadDialog.show(mContext);
        new ApiManager().delAddress(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                if(base.getStatus().equals("success")){
                    getAddress();
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

    private void getAddress(){
        LoadDialog.show(mContext);
        new ApiManager().getAddress(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("地址", "onSuccess: "+result);
                add= JSONObject.parseObject(result,AddressEntity.class);
                mAdapter.setAdd(add);
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
            }
        });
    }

    private void initView() {
        list = (NoScroListView) findViewById(R.id.list);
        refreshLayout = (SmoothRefreshLayout) findViewById(R.id.smoothRefreshLayout);
    }
}
