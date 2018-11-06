package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.UserEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.tenma.ventures.bean.TMUser;
import com.tenma.ventures.bean.utils.TMSharedPUtil;

import org.xutils.common.Callback;

public class MineCodeActivity extends BaseActivity {

    private ImageView iv_head;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private TextView tv_4;
    private TextView tv_5;
    private TextView tv_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_mine_code);

    }

    @Override
    protected void initData() {
        setTitle("我的邀请码");
        setBack();

        initView();

        getCode();

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        TMUser user= TMSharedPUtil.getTMUser(mContext);
        Log.d("头像", "initData: "+user.getHead_pic());
        Glide.with(this).load(user.getHead_pic()).apply(requestOptions).into(iv_head);

    }

    private void getCode() {
        LoadDialog.show(mContext);
        new ApiManager().mineCode(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("邀请码", "onSuccess: " + result);
                UserEntity user= JSONObject.parseObject(result,UserEntity.class);
                String code=user.getData().getCode();
                System.out.println("code="+code);
                tv_1.setText(code.substring(0,1));
                tv_2.setText(code.substring(1,2));
                tv_3.setText(code.substring(2,3));
                tv_4.setText(code.substring(3,4));
                tv_5.setText(code.substring(4,5));
                tv_6.setText(code.substring(5,6));
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
            }
        });
    }

    private void initView() {
        iv_head = (ImageView) findViewById(R.id.iv_head);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        tv_4 = (TextView) findViewById(R.id.tv_4);
        tv_5 = (TextView) findViewById(R.id.tv_5);
        tv_6 = (TextView) findViewById(R.id.tv_6);
    }
}
