package com.liuge.TMShop.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.ReasonAdapter;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.entity.MineOrderEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.network.SixGridContext;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.utils.TimeUtils;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroListView;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

public class TuiHuanHuoActivity extends BaseActivity{

    private TextView tv_sn;
    private TextView tv_time;
    private TextView tv_mall_name;
    private TextView tv_status;
    private ImageView iv_goods_img;
    private TextView tv_goods_name;
    private TextView tv_guige;
    private TextView tv_goods_price;
    private TextView tv_num;
    private AppCompatCheckBox cb_tui;
    private AppCompatCheckBox cb_huan;
    private NoScroListView list_reason;
    private EditText ed_reason;
    private Button bt_submit;

    MineOrderEntity.DataBean.ResultBean entity;

    String type="1";
    String reason_str=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_huan_huo);

    }

    @Override
    protected void initData() {
        setBack();
        setTitle("退换货");
        entity= (MineOrderEntity.DataBean.ResultBean) getIntent().getSerializableExtra("order");
        initView();
    }

    private void initView() {
        tv_sn = (TextView) findViewById(R.id.tv_sn);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_mall_name = (TextView) findViewById(R.id.tv_mall_name);
        tv_status = (TextView) findViewById(R.id.tv_status);
        iv_goods_img = (ImageView) findViewById(R.id.iv_goods_img);
        tv_goods_name = (TextView) findViewById(R.id.tv_goods_name);
        tv_guige = (TextView) findViewById(R.id.tv_guige);
        tv_goods_price = (TextView) findViewById(R.id.tv_goods_price);
        tv_num = (TextView) findViewById(R.id.tv_num);
        cb_tui = (AppCompatCheckBox) findViewById(R.id.cb_tui);
        cb_huan = (AppCompatCheckBox) findViewById(R.id.cb_huan);
        list_reason = (NoScroListView) findViewById(R.id.list_reason);
        ed_reason = (EditText) findViewById(R.id.ed_reason);
        bt_submit = (Button) findViewById(R.id.bt_submit);

        tv_sn.setText("订单编号：" + entity.getOrder_sn());
        tv_time.setText("创建时间" + TimeUtils.getStrTime(entity.getAdd_time() + "000"));
        tv_mall_name.setText(entity.get_orders().get(0).getShopname());
        Glide.with(mContext).load(entity.get_orders().get(0).get_goods().get(0).getGoods_image()).into(iv_goods_img);
        tv_goods_name.setText(entity.get_orders().get(0).get_goods().get(0).getGoods_name());
        tv_guige.setText("规格：" + entity.get_orders().get(0).get_goods().get(0).getGoods_attr());
        tv_goods_price.setText(SixGridContext.RMB + entity.get_orders().get(0).get_goods().get(0).getGoods_price());
        tv_num.setText("x" + entity.get_orders().get(0).get_goods().get(0).getGoods_numbers());

        final List<String>reason=new ArrayList<>();
        reason.add("七天无理由退换货");
        reason.add("大小/尺寸与商品描述不符");
        reason.add("颜色/图案/款式与商品描述不符");
        reason.add("材料/面料与商品描述不符");

        ReasonAdapter adapter=new ReasonAdapter(mContext);
        list_reason.setAdapter(adapter);
        adapter.setReason(reason);
        adapter.setListener(new ReasonAdapter.Choose() {
            @Override
            public void choose(List<String> list) {
                System.out.println("选中数据："+ JSONObject.toJSONString(list));
                reason_str=JSONObject.toJSONString(list);
            }
        });

        cb_tui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_tui.setChecked(true);
                cb_huan.setChecked(false);
                type="1";
            }
        });
        cb_huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb_tui.setChecked(false);
                cb_huan.setChecked(true);
                type="2";
            }
        });
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void submit() {
        // validate
        String reason = ed_reason.getText().toString().trim();
        if (TextUtils.isEmpty(reason)) {
            Toast.makeText(this, "请输入退换货原因", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        returnOrder(reason);

    }

    private void returnOrder(String desc){
        LoadDialog.show(mContext);
        new ApiManager().returnOrder(entity.get_orders().get(0).get_goods().get(0).getRec_id(), entity.getOrder_sn(), type, reason_str, desc, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
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
