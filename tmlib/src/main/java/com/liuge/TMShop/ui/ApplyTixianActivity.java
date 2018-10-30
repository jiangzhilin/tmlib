package com.liuge.TMShop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.AccountEntity;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.LoadDialog;

import org.xutils.common.Callback;

import java.util.ArrayList;

public class ApplyTixianActivity extends BaseActivity{

    private TextView tv_ketixian;
    private TextView tv_leiji;
    private EditText ed_jine;
    private AppCompatSpinner spinner;
    private TextView tv_account_manager;
    private Button bt_submit;

    private String aid="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_tixian);
    }

    @Override
    protected void initData() {

        setBack();
        setTitle("申请提现");

        initView();
    }

    private void initView() {
        tv_ketixian = (TextView) findViewById(R.id.tv_ketixian);
        tv_leiji = (TextView) findViewById(R.id.tv_leiji);
        ed_jine = (EditText) findViewById(R.id.ed_jine);
        spinner = (AppCompatSpinner) findViewById(R.id.spinner);
        tv_account_manager = (TextView) findViewById(R.id.tv_account_manager);
        bt_submit = (Button) findViewById(R.id.bt_submit);

        getUserAccount();


        tv_account_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,AccountManagerActivity.class);
                startActivity(intent);
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

    }


    private void getUserAccount(){
        LoadDialog.show(mContext);
        new ApiManager().userAccount(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("体现账户", "onSuccess: "+result);
                final AccountEntity account= JSONObject.parseObject(result,AccountEntity.class);
                ArrayList<String>acc=new ArrayList<String>();
                acc.add("请选择账户");
                if(account.getStatus().equals("success")){
                    for(int x=0;x<account.getData().getResult().size();x++){

                        StringBuffer msg=new StringBuffer();
                        switch (Integer.valueOf(account.getData().getResult().get(x).getType())){
                            case 1:
                                msg.append("支付宝   ");
                                break;
                            case 2:
                                msg.append("微信     ");
                                break;
                            case 3:
                                msg.append("银联     ");
                                break;
                        }
                        msg.append(account.getData().getResult().get(x).getNumber());
                        acc.add(msg.toString());
                    }
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,acc);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position!=0) {
                            aid = account.getData().getResult().get(position - 1).getId();
                        }else{
                            aid="0";
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
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

    @Override
    protected void onResume() {
        super.onResume();
        getUserAccount();
    }

    private void submit() {
        // validate
        String jine = ed_jine.getText().toString().trim();
        if (TextUtils.isEmpty(jine)) {
            Toast.makeText(this, "输入提现金额", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        tixian(aid,jine);

    }

    private void tixian(String id,String account){
        LoadDialog.show(mContext);
        new ApiManager().applyTixian(id, account, new Callback.CommonCallback<String>() {
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
