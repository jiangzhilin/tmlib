package com.liuge.z02sckhd_6wqgx.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;

/**
 * Created by jiang on 2018/2/26.
 */

public class AddressDialog extends Dialog {
    private Activity mActivity;
    private Context mContext;
    private View view;
    private ViewHolder vh;
    CityPickerView mPicker;

    public AddressDialog(Context context, Activity activity) {
        super(context);
        mActivity = activity;
        mContext = context;
        //申明对象
        mPicker=new CityPickerView();
        mPicker.init(mContext);
        init();
    }

    private void init() {
        view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_edit_address_dialog, null);
        vh = new ViewHolder(view);
        this.onBackPressed();
        this.setContentView(view);
        this.setCanceledOnTouchOutside(true);

        Window window = getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.height = mActivity.getWindowManager().getDefaultDisplay().getHeight()/7*4;
        lp.width = mActivity.getWindowManager().getDefaultDisplay().getWidth() / 7 * 6;
        lp.gravity = Gravity.CENTER;
        window.setAttributes(lp);

        vh.tv_sheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPick();
            }
        });
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

                }

                //城市
                if (city != null) {

                }

                //地区
                if (district != null) {

                }

            }

            @Override
            public void onCancel() {
                NToast.shortToast(mContext, "已取消");
            }
        });

        //显示
        mPicker.showCityPicker( );
    }


    public AddressDialog setSubmitListener(String submit_txt, final View.OnClickListener listener) {
        vh.bt_submit.setVisibility(View.VISIBLE);
        vh.bt_submit.setText(submit_txt);
        vh.bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onClick(v);
            }
        });
        return this;
    }

    public AddressDialog setSubmitListener(final View.OnClickListener listener) {
        vh.bt_submit.setVisibility(View.VISIBLE);
        vh.bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onClick(v);
            }
        });
        return this;
    }

    @Override
    public void show() {
        super.show();
    }


    class ViewHolder {
        public View rootView;
        public EditText ed_name;
        public EditText ed_phone;
        public TextView tv_sheng;
        public TextView tv_shi;
        public TextView tv_area;
        public EditText ed_tails;
        public Button bt_submit;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ed_name = (EditText) rootView.findViewById(R.id.ed_name);
            this.ed_phone = (EditText) rootView.findViewById(R.id.ed_phone);
            this.tv_sheng = (TextView) rootView.findViewById(R.id.tv_sheng);
            this.tv_shi = (TextView) rootView.findViewById(R.id.tv_shi);
            this.tv_area = (TextView) rootView.findViewById(R.id.tv_area);
            this.ed_tails = (EditText) rootView.findViewById(R.id.ed_tails);
            this.bt_submit = (Button) rootView.findViewById(R.id.bt_submit);
        }

    }
}
