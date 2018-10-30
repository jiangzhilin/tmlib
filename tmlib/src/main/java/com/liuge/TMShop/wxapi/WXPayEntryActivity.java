package com.liuge.TMShop.wxapi;

import android.app.Activity;
import android.os.Bundle;

import com.liuge.TMShop.ui.OrderPayActivity;
import com.liuge.TMShop.utils.NToast;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by Administrator on 2018/5/3.
 */

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(OrderPayActivity.instence!=null) {
            OrderPayActivity.instence.wxapi.handleIntent(getIntent(), this);
        }
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp resp) {
        if(resp.errCode== 0){
            NToast.shortToast(this,"支付成功");
            if(OrderPayActivity.instence!=null){
                OrderPayActivity.instence.finish();
            }
        }else if(resp.errCode== -1){
            NToast.shortToast(this,"支付失败");
        }else if(resp.errCode== -2){
            NToast.shortToast(this,"支付取消");
        }
        finish();
    }
}
