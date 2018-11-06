package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.AccountListAdpater;
import com.liuge.z02sckhd_6wqgx.entity.AccountEntity;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.AskDialog;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

import java.util.ArrayList;

public class AccountManagerActivity extends BaseActivity{

    private AppCompatSpinner spinner;
    private EditText ed_account_name;
    private Button bt_submit;
    private NoScroListView list;

    String type="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_account_manager);
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("提现账户");

        initView();
    }

    private void initView() {
        spinner = (AppCompatSpinner) findViewById(R.id.spinner);
        ed_account_name = (EditText) findViewById(R.id.ed_account_name);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        list = (NoScroListView) findViewById(R.id.list);

        ArrayList<String> account_type=new ArrayList<>();
        account_type.add("请选择账户类型");
        account_type.add("支付宝");
        account_type.add("微信");
        account_type.add("银联");

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,account_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type=""+position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

        getUserAccount();
    }
    private void submit() {
        // validate
        String name = ed_account_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入账户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if(type.equals("0")){
            Toast.makeText(this, "请选择账户类型", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        addAccount(name);

    }

    private void addAccount(String num){
        LoadDialog.show(mContext);
        new ApiManager().addAccount(type, num, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                getUserAccount();
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

    private void getUserAccount(){
        LoadDialog.show(mContext);
        new ApiManager().userAccount(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("体现账户", "onSuccess: "+result);
                final AccountEntity entity=JSONObject.parseObject(result,AccountEntity.class);
                AccountListAdpater adapter=new AccountListAdpater(mContext);
                list.setAdapter(adapter);
                adapter.setAccount(entity);
                list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                        new AskDialog(mContext,AccountManagerActivity.this)
                                .setCloseListener()
                                .setWinTitle("系统提示")
                                .setMessage("是否删除该条账户？")
                                .setSubmitListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        del(entity.getData().getResult().get(position).getId());
                                    }
                                })
                                .show();
                        return false;
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

    private void del(String id){
        LoadDialog.show(mContext);
        new ApiManager().delAccount(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                getUserAccount();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.show(mContext);
            }
        });
    }
}
