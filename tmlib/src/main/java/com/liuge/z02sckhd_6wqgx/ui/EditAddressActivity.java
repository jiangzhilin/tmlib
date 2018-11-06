package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.AddressEntity;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;

import org.xutils.common.Callback;

public class EditAddressActivity extends BaseActivity{

    private EditText ed_name;
    private EditText ed_phone;
    private TextView tv_sheng;
    private TextView tv_shi;
    private TextView tv_area;
    private EditText ed_tails;
    private Button bt_submit;
    CityPickerView mPicker;

    String pro;
    String shi;
    String qu;

    AddressEntity.DataBean address=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_edit_address_dialog);

    }

    @Override
    protected void initData() {
        initView();

        setBack();

        address=(AddressEntity.DataBean)getIntent().getSerializableExtra("address");
        if(address!=null){
            setTitle("修改地址");
        }else {
            setTitle("收货地址");
        }

        mPicker=new CityPickerView();
        mPicker.init(mContext);

        tv_sheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPick();
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        if(address!=null){
            ed_name.setText(address.getConsignee());
            ed_phone.setText(address.getMobile());
            ed_tails.setText(address.getAddress_name());
            tv_sheng.setText(address.getAddress());
        }


    }

    private void showPick(){
        //添加默认的配置，不需要自己定义
        CityConfig cityConfig = new CityConfig.Builder().build();
        mPicker.setConfig(cityConfig);

//监听选择点击事件及返回结果
        mPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {

                //省份
                if (province != null) {
                    pro=province.getName();
                }

                //城市
                if (city != null) {
                    shi=city.getName();
                }

                //地区
                if (district != null) {
                    qu=district.getName();
                }
                tv_sheng.setText(pro+shi+qu);
            }

            @Override
            public void onCancel() {
                NToast.shortToast(mContext, "已取消");
            }
        });

        //显示
        mPicker.showCityPicker( );
    }

    private void initView() {
        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_phone = (EditText) findViewById(R.id.ed_phone);
        tv_sheng = (TextView) findViewById(R.id.tv_sheng);
        tv_shi = (TextView) findViewById(R.id.tv_shi);
        tv_area = (TextView) findViewById(R.id.tv_area);
        ed_tails = (EditText) findViewById(R.id.ed_tails);
        bt_submit = (Button) findViewById(R.id.bt_submit);


    }

    private void submit() {
        // validate
        String name = ed_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "收件人姓名", Toast.LENGTH_SHORT).show();
            return;
        }

        String phone = ed_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "联系电话", Toast.LENGTH_SHORT).show();
            return;
        }

        String tails = ed_tails.getText().toString().trim();
        if (TextUtils.isEmpty(tails)) {
            Toast.makeText(this, "详细地址", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if(address==null) {
            add(pro + shi + qu, tails, name, phone);
        }else{
            edit(address.getAddress_id(),pro + shi + qu, tails, name, phone);
        }

    }

    private void add(String address,String detail,String name,String phone){
        LoadDialog.show(mContext);
        new ApiManager().addAddress(address, detail, name, phone, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                if (base.getStatus().equals("success")){
                    finish();
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

    private void edit(String id,String address,String detail,String name,String phone){
        LoadDialog.show(mContext);
        new ApiManager().editAddress(id,address, detail, name, phone, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                if (base.getStatus().equals("success")){
                    finish();
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
}
