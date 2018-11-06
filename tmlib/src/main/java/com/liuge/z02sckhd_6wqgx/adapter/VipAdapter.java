package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.VipEntity;

import java.util.List;

/**
 * Created by jiang on 2018/11/4.
 */

public class VipAdapter extends BaseAdapter {
    Context mContext;
    List<VipEntity.DataBean.ResultBean> mList;

    public void setmList(List<VipEntity.DataBean.ResultBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public VipAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_vip_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tv_name.setText(mList.get(position).getMember_name());
        vh.tv_time.setText(mList.get(position).getAdd_time());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_name;
        public TextView tv_time;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
