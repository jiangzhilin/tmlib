package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.ShouyiEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.ui.TixianRecordActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class TixianRecordAdapter extends BaseAdapter {
    Context mContext;
    List<ShouyiEntity.DataBean.ResultBean> mList;

    public void setmList(List<ShouyiEntity.DataBean.ResultBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public TixianRecordAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_layout_tixian_record, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        switch(Integer.valueOf(mList.get(i).getWay())){
            case 1:
                vh.iv_head.setBackgroundResource(R.mipmap.z02sckhd_6wqgx_icon_alipay);
            break;
            case 2:
                vh.iv_head.setBackgroundResource(R.mipmap.z02sckhd_6wqgx_icon_wx);
            break;
            case 3:
                vh.iv_head.setBackgroundResource(R.mipmap.z02sckhd_6wqgx_icon_unio);
            break;
        }

        vh.tv_account.setText(mList.get(i).getAlipay());

        vh.tv_time.setText(mList.get(i).getAdd_time());

        vh.tv_money.setText(SixGridContext.RMB+mList.get(i).getPrice());

        switch(Integer.valueOf(mList.get(i).getStatus())){
            case 0:
                vh.tv_quxiao.setText("撤消申请");
                vh.tv_quxiao.setTextColor(Color.parseColor("#0056AB"));

                vh.tv_quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cannalTixian(mList.get(i).getId());
                    }
                });

            break;
            case 1:
                vh.tv_quxiao.setText("审核通过");
                vh.tv_quxiao.setTextColor(Color.parseColor("#0055ff"));
                vh.tv_quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            break;
            case 2:
                vh.tv_quxiao.setText("已拒绝");
                vh.tv_quxiao.setTextColor(Color.parseColor("#ff0000"));
                vh.tv_quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            break;
        }

        return view;
    }
    
    private void cannalTixian(String mid){
        LoadDialog.show(mContext);
        new ApiManager().cannalTixian(mid, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                TixianRecordActivity.instance.getShouyi(""+2);
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

    public static class ViewHolder {
        public View rootView;
        public ImageView iv_head;
        public TextView tv_account;
        public TextView tv_time;
        public TextView tv_money;
        public TextView tv_quxiao;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.tv_account = (TextView) rootView.findViewById(R.id.tv_account);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_money = (TextView) rootView.findViewById(R.id.tv_money);
            this.tv_quxiao = (TextView) rootView.findViewById(R.id.tv_quxiao);
        }

    }
}
