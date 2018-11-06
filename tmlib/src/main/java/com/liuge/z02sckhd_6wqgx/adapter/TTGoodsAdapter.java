package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;

/**
 * Created by Administrator on 2018/8/22.
 */

public class TTGoodsAdapter extends BaseAdapter {
    Context mContext;

    public TTGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 6;
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
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_index_main_goods, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        return view;
    }

    public class ViewHolder {
        public View rootView;
        public ImageView iv_xianshi_img_1;
        public TextView tv_xianshi_name_1;
        public TextView tv_xianshi_detail_1;
        public TextView tv_xianshi_price_1;
        public TextView tv_pay_num_1;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_xianshi_img_1 = (ImageView) rootView.findViewById(R.id.iv_xianshi_img_1);
            this.tv_xianshi_name_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_name_1);
            this.tv_xianshi_detail_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_detail_1);
            this.tv_xianshi_price_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_price_1);
            this.tv_pay_num_1 = (TextView) rootView.findViewById(R.id.tv_pay_num_1);
        }

    }
}
