package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.PaimaiDetailsEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/23.
 */

public class JingpaiAdapter extends BaseAdapter {
    Context mContext;
    List<String> logs;

    public JingpaiAdapter(Context mContext, List<String> logs) {
        this.mContext = mContext;
        this.logs = logs;
    }

    public JingpaiAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return logs==null?0:logs.size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_jilu_jingpai, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
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
