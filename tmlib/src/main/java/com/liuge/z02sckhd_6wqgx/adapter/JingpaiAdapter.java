package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.PaimaiDetailsEntity;
import com.liuge.z02sckhd_6wqgx.utils.TimeUtils;

/**
 * Created by Administrator on 2018/8/23.
 */

public class JingpaiAdapter extends BaseAdapter {
    Context mContext;
   PaimaiDetailsEntity.DataBean logs;

    public JingpaiAdapter(Context mContext, PaimaiDetailsEntity.DataBean logs) {
        this.mContext = mContext;
        this.logs = logs;
    }

    public JingpaiAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return logs==null?0:logs.getAuctionlog().size();
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
        ViewHolder vh=null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_jilu_jingpai, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        vh.tv_username.setText(logs.getAuctionlog().get(i).getTel());
        vh.tv_time.setText(TimeUtils.getStrTime(logs.getAuctionlog().get(i).getBid_time()+"000"));
        vh.tv_chujia.setText(logs.getStore().getMarkups());
        vh.tv_jingpaijia.setText(logs.getAuctionlog().get(i).getBid_price());

        return view;
    }

    public  class ViewHolder {
        public View rootView;
        public TextView tv_username;
        public TextView tv_time;
        public TextView tv_chujia;
        public TextView tv_jingpaijia;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_username = (TextView) rootView.findViewById(R.id.tv_username);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.tv_chujia = (TextView) rootView.findViewById(R.id.tv_chujia);
            this.tv_jingpaijia = (TextView) rootView.findViewById(R.id.tv_jingpaijia);
        }

    }
}
