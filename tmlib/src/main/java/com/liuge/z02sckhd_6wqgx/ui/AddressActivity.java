package com.liuge.z02sckhd_6wqgx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.AddressAdapter;
import com.liuge.z02sckhd_6wqgx.entity.AddressEntity;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

public class AddressActivity extends BaseActivity {

    private NoScroListView list;
    private SmoothRefreshLayout refreshLayout;

    AddressAdapter mAdapter;
    AddressEntity add;
    private String isChoose=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_address);
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
        isChoose=getIntent().getStringExtra("choose");
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

        if(isChoose!=null){
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(mContext,SubmitOrderActivity.class);
                    intent.putExtra("address",add.getData().get(i));
                    setResult(10000,intent);
                    finish();
                }
            });
        }

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
