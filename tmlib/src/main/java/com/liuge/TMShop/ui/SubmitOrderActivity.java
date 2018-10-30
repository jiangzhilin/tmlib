package com.liuge.TMShop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.SubmitMallAdapter;
import com.liuge.TMShop.entity.CreateOrderResultEntity;
import com.liuge.TMShop.entity.SubmitCartEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.network.SixGridContext;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.utils.TimeUtils;
import com.liuge.TMShop.view.LoadDialog;

import org.xutils.common.Callback;

public class SubmitOrderActivity extends BaseActivity {

    private TextView tv_name;
    private TextView tv_phone;
    private TextView tv_address;
    private ListView list;
    private TextView tv_amount;
    private LinearLayout ll_submit;

    private SubmitCartEntity entity;

    private SubmitMallAdapter mAdapter;

    public static SubmitOrderActivity instence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_order);
//        entity= JSONObject.parseObject(getIntent().getStringExtra("order"),SubmitCartEntity.class);
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("确认订单");
        instence=this;
        entity= (SubmitCartEntity) getIntent().getSerializableExtra("order");
        initView();
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        list = (ListView) findViewById(R.id.list);
        tv_amount = (TextView) findViewById(R.id.tv_amount);
        ll_submit = (LinearLayout) findViewById(R.id.ll_submit);

        if(entity!=null) {
            if(entity.getData()!=null) {
                if (entity.getData().getConsignee_default().size() > 0) {
                    tv_name.setText("收货人：" + entity.getData().getConsignee_default().get(0).getConsignee());
                    tv_phone.setText(entity.getData().getConsignee_default().get(0).getMobile());
                    tv_address.setText("地址：" + entity.getData().getConsignee_default().get(0).getAddress());
                }

                tv_amount.setText(SixGridContext.RMB + entity.getData().getTotal().getGoods_price());

                mAdapter=new SubmitMallAdapter(mContext);
                list.setAdapter(mAdapter);
                mAdapter.setmList(entity);

                ll_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createOrder(entity);
                    }
                });

            }
        }
    }

    private void createOrder(final SubmitCartEntity e){
        LoadDialog.show(mContext);
        new ApiManager().createOrder(null, e.getData().getConsignee_default().get(0).getAddress_id(), null, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("createOrder", "onSuccess: "+result);
                CreateOrderResultEntity base=JSONObject.parseObject(result,CreateOrderResultEntity.class);
                if(entity.getStatus().equals("success")) {
                    Intent intent = new Intent(mContext, OrderPayActivity.class);
                    intent.putExtra("sn",base.getData().getOrder_sn());
                    intent.putExtra("time", TimeUtils.getStrTime(System.currentTimeMillis()+""));
                    intent.putExtra("price",""+e.getData().getTotal().getGoods_price());
                    intent.putExtra("mid",base.getData().getMid());
                    startActivity(intent);
                }else{
                    NToast.shortToast(mContext,entity.getMsg());
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

    public void finishs(){
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instence=null;
    }
}
