package com.liuge.z02sckhd_6wqgx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.ShouyiEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.ui.ApplyTixianActivity;
import com.liuge.z02sckhd_6wqgx.ui.MineCodeActivity;
import com.liuge.z02sckhd_6wqgx.ui.MineVipActivity;
import com.liuge.z02sckhd_6wqgx.ui.ShouyiRecordActivity;
import com.liuge.z02sckhd_6wqgx.ui.TixianRecordActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/8/21.
 */

public class ShouyiFragment extends BaseFragment {
    /**
     * 预加载标志，默认值为false，设置为true，表示已经预加载完成，可以加载数据
     */
    private boolean isPrepared;

    private View view;
    private ViewHolder vh;

    /**
     * Fragment生命周期方法，此view可改为自定义的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.z02sckhd_6wqgx_fragment_shouyi, container, false);
        vh=new ViewHolder(view);
        //获得状态栏高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(getActivity()));
        vh.ll_bar.setLayoutParams(params);

        //TODO 此处初始化view中各个控件
        isPrepared = true;
        setlazyLoad();
        return view;
    }

    /**
     * 加载数据的方法，只要保证isPrepared和isVisible都为true的时候才往下执行开始加载数据
     */
    @Override
    protected void setlazyLoad() {
        super.setlazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        //TODO 此处填充view中各个控件的数据
        initView();
    }

    private void initView() {
        vh.ll_erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MineCodeActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),MineVipActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_shouyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),ShouyiRecordActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_tixianjilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),TixianRecordActivity.class);
                startActivity(intent);
            }
        });

        getShouyi(11+"");
        getShouyi(2+"");

        vh.tv_tixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ApplyTixianActivity.class);
                startActivity(intent);
            }
        });
        vh.tv_leijishouyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ShouyiRecordActivity.class);
                startActivity(intent);
            }
        });
    }


    private void getShouyi(final String type){
        LoadDialog.show(getActivity());
        new ApiManager().getShouyi(type, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                ShouyiEntity base= JSONObject.parseObject(result,ShouyiEntity.class);
                NToast.shortToast(getActivity(),base.getMsg());
                if(type.equals("11")){
                    vh.tv_tixianshouyi.setText(SixGridContext.RMB+base.getData().getMoney());
                }else{
                    vh.tv_leijishouyi.setText(SixGridContext.RMB+base.getData().getMoney());
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
                LoadDialog.dismiss(getActivity());
            }
        });
    }

    public  class ViewHolder {
        public View rootView;
        public TextView tv_tixianshouyi;
        public TextView tv_tixian;
        public TextView tv_leijishouyi;
        public TextView tv_details;
        public LinearLayout ll_erweima;
        public LinearLayout ll_vip;
        public LinearLayout ll_shouyi;
        public LinearLayout ll_tixianjilu;
        public LinearLayout ll_bar;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_tixianshouyi = (TextView) rootView.findViewById(R.id.tv_tixianshouyi);
            this.tv_tixian = (TextView) rootView.findViewById(R.id.tv_tixian);
            this.tv_leijishouyi = (TextView) rootView.findViewById(R.id.tv_leijishouyi);
            this.tv_details = (TextView) rootView.findViewById(R.id.tv_details);
            this.ll_erweima = (LinearLayout) rootView.findViewById(R.id.ll_erweima);
            this.ll_vip = (LinearLayout) rootView.findViewById(R.id.ll_vip);
            this.ll_shouyi = (LinearLayout) rootView.findViewById(R.id.ll_shouyi);
            this.ll_tixianjilu = (LinearLayout) rootView.findViewById(R.id.ll_tixianjilu);

            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
        }

    }
}
