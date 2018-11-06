package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.MineOrderMallAdapter;
import com.liuge.z02sckhd_6wqgx.entity.MineOrderEntity;
import com.liuge.z02sckhd_6wqgx.entity.OrderDetails;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.TimeUtils;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

public class OrderDetailsActivity extends BaseActivity {
    MineOrderEntity.DataBean.ResultBean order;
    private TextView tv_sn;
    private TextView tv_time;
    private NoScroListView mall_list;
    private TextView tv_num;
    private TextView tv_price;
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private LinearLayout ll_bottom;
    private TextView tv_create_time;
    private TextView tv_pay_time;
    private TextView tv_order_liushui;
    private TextView tv_fahuo_time;
    private TextView tv_order_wuliu;
    private TextView tv_receive_time;
    private TextView tv_comment_time;
    private TextView tv_yunfei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_order_details);
    }

    @Override
    protected void initData() {
        setTitle("订单详情");
        setBack();
        order = (MineOrderEntity.DataBean.ResultBean) getIntent().getSerializableExtra("order");
        initView();
        orderTails();
    }

    private void orderTails() {
        LoadDialog.show(mContext);
        new ApiManager().orderDetails(order.getMid(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("订单详情", "onSuccess: " + result);
                OrderDetails details = JSONObject.parseObject(result, OrderDetails.class);
                if (details.getStatus().equals("success")) {
                    tv_create_time.setText(TimeUtils.getStrTime(details.getData().getAdd_time() + "000"));
                    tv_receive_time.setText(TimeUtils.getStrTime(details.getData().get_orders().get(0).getConfirm_time() + "000"));
                    tv_fahuo_time.setText(TimeUtils.getStrTime(details.getData().get_orders().get(0).getDeliver_time() + "000"));
                    tv_comment_time.setText(TimeUtils.getStrTime(details.getData().get_orders().get(0).getEvaluation_time() + "000"));
                    tv_pay_time.setText(TimeUtils.getStrTime(details.getData().getPay_time() + "000"));
                    tv_order_liushui.setText(order.getOrder_sn());
                    tv_order_wuliu.setText(details.getData().get_orders().get(0).getExtension_code());
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

    private void initView() {
        tv_sn = (TextView) findViewById(R.id.tv_sn);
        tv_time = (TextView) findViewById(R.id.tv_time);
        mall_list = (NoScroListView) findViewById(R.id.mall_list);
        tv_num = (TextView) findViewById(R.id.tv_num);
        tv_price = (TextView) findViewById(R.id.tv_price);
        bt_1 = (Button) findViewById(R.id.bt_1);
        bt_2 = (Button) findViewById(R.id.bt_2);
        bt_3 = (Button) findViewById(R.id.bt_3);
        ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
        tv_create_time = (TextView) findViewById(R.id.tv_create_time);
        tv_pay_time = (TextView) findViewById(R.id.tv_pay_time);
        tv_order_liushui = (TextView) findViewById(R.id.tv_order_liushui);
        tv_fahuo_time = (TextView) findViewById(R.id.tv_fahuo_time);
        tv_order_wuliu = (TextView) findViewById(R.id.tv_order_wuliu);
        tv_receive_time = (TextView) findViewById(R.id.tv_receive_time);
        tv_comment_time = (TextView) findViewById(R.id.tv_comment_time);
        tv_yunfei = (TextView) findViewById(R.id.tv_yunfei);

        ll_bottom.setVisibility(View.GONE);
        tv_sn.setText("订单编号：" + order.getOrder_sn());
        tv_time.setText("创建时间：" + TimeUtils.getStrTime(order.getAdd_time() + "000"));
        MineOrderMallAdapter mall = new MineOrderMallAdapter(mContext);
        mall_list.setAdapter(mall);
        mall.setmList(order);

        tv_num.setText("共" + order.get_orders().get(0).get_goods().get(0).getGoods_numbers() + "件商品");
        tv_yunfei.setText(order.get_orders().get(0).getPay_fee());
    }
}
