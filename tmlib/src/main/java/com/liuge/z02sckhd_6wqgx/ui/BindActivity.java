package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

public class BindActivity extends BaseActivity{

    private EditText ed_code;
    private Button bt_bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_bind);

    }

    @Override
    protected void initData() {
        setBack();
        setTitle("分销绑定");
        initView();
    }

    private void initView() {
        ed_code = (EditText) findViewById(R.id.ed_code);
        bt_bind = (Button) findViewById(R.id.bt_bind);
        bt_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }


    private void submit() {
        // validate
        String code = ed_code.getText().toString().trim();
        if (TextUtils.isEmpty(code)) {
            Toast.makeText(this, "code不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        bind(code);

    }

    private void bind(String code){
        LoadDialog.show(mContext);
        new ApiManager().bindCode(code, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
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
