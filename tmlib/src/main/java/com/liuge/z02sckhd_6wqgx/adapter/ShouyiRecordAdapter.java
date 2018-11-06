package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.ShouyiEntity;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

public class ShouyiRecordAdapter extends BaseAdapter {
    Context mContext;

    List<ShouyiEntity.DataBean.ResultBean>mList;


    public void setmList(List<ShouyiEntity.DataBean.ResultBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public ShouyiRecordAdapter(Context mContext) {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_shouyi_record, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tv_title.setText(mList.get(i).getContent());
        vh.tv_money.setText(SixGridContext.RMB+mList.get(i).getPrice());
        vh.tv_time.setText(mList.get(i).getAdd_time());

        return view;
    }


    class ViewHolder {
        public View rootView;
        public TextView tv_title;
        public TextView tv_money;
        public TextView tv_time;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_money = (TextView) rootView.findViewById(R.id.tv_money);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }

    }
}
