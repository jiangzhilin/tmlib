package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.app.PayTask;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.OrderPayEntity;
import com.liuge.z02sckhd_6wqgx.entity.OrderWxPayEntity;
import com.liuge.z02sckhd_6wqgx.entity.PayResult;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.xutils.common.Callback;

import java.util.Map;

public class OrderPayActivity extends BaseActivity {

    private TextView tv_sn;
    private TextView tv_time;
    private TextView tv_price;
    private LinearLayout ll_alipay;
    private LinearLayout ll_wx;

    public static IWXAPI wxapi;

    public static OrderPayActivity instence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_order_pay);
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("在线支付");
        instence=this;
        initView();
    }

    private void initView() {
        tv_sn = (TextView) findViewById(R.id.tv_sn);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_price = (TextView) findViewById(R.id.tv_price);
        ll_alipay = (LinearLayout) findViewById(R.id.ll_alipay);
        ll_wx = (LinearLayout) findViewById(R.id.ll_wx);

        final String orderSN=getIntent().getStringExtra("sn");
        String orderTime=getIntent().getStringExtra("time");
        final String mid=getIntent().getStringExtra("mid");
        String price=getIntent().getStringExtra("price");

        tv_sn.setText(orderSN);
        tv_time.setText(orderTime);
        tv_price.setText(SixGridContext.RMB+price);

        ll_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay(mid,"1",orderSN);
            }
        });
        ll_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay(mid,"4",orderSN);
            }
        });
    }

    private void pay(String mid, final String type, String sn){
        LoadDialog.show(mContext);
        new ApiManager().orderPay(mid, type,sn, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("支付信息", "onSuccess: "+result);
                if(type.equals("1")){
                    final OrderPayEntity pay= JSONObject.parseObject(result,OrderPayEntity.class);
                    if(pay.getStatus().equals("success")) {
                        Runnable payRunnable = new Runnable() {
                            @Override
                            public void run() {
                                PayTask alipay = new PayTask(OrderPayActivity.this);
                                Map<String, String> result = alipay.payV2(pay.getData(), true);
                                Message msg = new Message();
                                msg.obj = result;
                                mHandler.sendMessage(msg);
                            }
                        };
                        // 必须异步调用
                        Thread payThread = new Thread(payRunnable);
                        payThread.start();
                    }
                }else{
                    OrderWxPayEntity wxpay=JSONObject.parseObject(result,OrderWxPayEntity.class);
                    if(wxpay.getStatus().equals("success")) {
                        wxapi = WXAPIFactory.createWXAPI(mContext, wxpay.getData().getAppid(), true);
                        wxapi.registerApp(wxpay.getData().getAppid());
                        if (wxapi.isWXAppInstalled()) {
                            PayReq request = new PayReq();
                            request.appId = wxpay.getData().getAppid();
                            request.partnerId = wxpay.getData().getPartnerid();
                            request.prepayId = wxpay.getData().getPrepayid();
                            request.packageValue = wxpay.getData().getPackageX();
                            request.nonceStr = wxpay.getData().getNoncestr();
                            request.timeStamp = ""+wxpay.getData().getTimestamp();
                            request.sign = wxpay.getData().getSign();
                            wxapi.sendReq(request);
                        } else {
                            NToast.shortToast(mContext,"请先安装微信客户端");
                        }
                    }
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
        this.finish();
        if(SubmitOrderActivity.instence!=null){
            SubmitOrderActivity.instence.finish();
        }
    }
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            PayResult payResult = new PayResult((Map<String, String>) msg.obj);
            /**
             对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
             */
            String resultInfo = payResult.getResult();// 同步返回需要验证的信息
            String resultStatus = payResult.getResultStatus();
            // 判断resultStatus 为9000则代表支付成功
            if (TextUtils.equals(resultStatus, "9000")) {
                // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                NToast.shortToast(mContext,"支付成功");
                finishs();
            } else {
                // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                NToast.shortToast(mContext,"支付失败");
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        instence=null;
    }
}
