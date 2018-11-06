package com.liuge.z02sckhd_6wqgx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.ui.AddressActivity;
import com.liuge.z02sckhd_6wqgx.ui.BindActivity;
import com.liuge.z02sckhd_6wqgx.ui.CollectActivity;
import com.liuge.z02sckhd_6wqgx.ui.MineOrderActivity;
import com.liuge.z02sckhd_6wqgx.ui.ShouyiRecordActivity;
import com.liuge.z02sckhd_6wqgx.ui.TixianRecordActivity;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.tenma.ventures.bean.TMUser;
import com.tenma.ventures.bean.utils.TMSharedPUtil;

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
        view = inflater.inflate(R.layout.z02sckhd_6wqgx_fragment_mine, container, false);
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
                Intent intent = new Intent(getActivity(), AddressActivity.class);
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
                Intent intent = new Intent(getActivity(), ShouyiRecordActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_tixianjilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TixianRecordActivity.class);
                startActivity(intent);
            }
        });
        vh.ll_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent);
            }
        });

        vh.ll_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MineOrderActivity.class);
                startActivity(intent);
            }
        });

        vh.ll_fenxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BindActivity.class);
                startActivity(intent);
            }
        });

        TMUser user = TMSharedPUtil.getTMUser(getActivity());

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load(user.getHead_pic()).apply(requestOptions).into(vh.iv_head);

        vh.tv_nickname.setText(user.getMember_name());

    }

    class ViewHolder {
        public View rootView;
        public LinearLayout ll_bar;
        public ImageView iv_head;
        public TextView tv_nickname;
        public LinearLayout ll_address;
        public LinearLayout ll_vip;
        public LinearLayout ll_shouyi;
        public LinearLayout ll_tixianjilu;
        public LinearLayout ll_collect;
        public LinearLayout ll_fenxiao;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.tv_nickname = (TextView) rootView.findViewById(R.id.tv_nickname);
            this.ll_address = (LinearLayout) rootView.findViewById(R.id.ll_address);
            this.ll_vip = (LinearLayout) rootView.findViewById(R.id.ll_vip);
            this.ll_shouyi = (LinearLayout) rootView.findViewById(R.id.ll_shouyi);
            this.ll_tixianjilu = (LinearLayout) rootView.findViewById(R.id.ll_tixianjilu);
            this.ll_collect = (LinearLayout) rootView.findViewById(R.id.ll_collect);
            this.ll_fenxiao = (LinearLayout) rootView.findViewById(R.id.ll_fenxiao);
        }

    }
}
