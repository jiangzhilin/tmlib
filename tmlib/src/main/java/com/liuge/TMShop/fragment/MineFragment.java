package com.liuge.TMShop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuge.TMShop.R;
import com.liuge.TMShop.ui.AddressActivity;
import com.liuge.TMShop.ui.ShouyiRecordActivity;
import com.liuge.TMShop.ui.TixianRecordActivity;
import com.liuge.TMShop.utils.StatusBarUtil;

/**
 * Created by Administrator on 2018/8/21.
 */

public class MineFragment extends BaseFragment {
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
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        vh = new ViewHolder(view);

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

        vh.ll_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),AddressActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_head;
        public TextView tv_name;
        public LinearLayout ll_address;
        public LinearLayout ll_vip;
        public LinearLayout ll_shouyi;
        public LinearLayout ll_tixianjilu;
        public LinearLayout ll_bar;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.ll_address = (LinearLayout) rootView.findViewById(R.id.ll_address);
            this.ll_vip = (LinearLayout) rootView.findViewById(R.id.ll_vip);
            this.ll_shouyi = (LinearLayout) rootView.findViewById(R.id.ll_shouyi);
            this.ll_tixianjilu = (LinearLayout) rootView.findViewById(R.id.ll_tixianjilu);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_nickname);
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
        }

    }
}
