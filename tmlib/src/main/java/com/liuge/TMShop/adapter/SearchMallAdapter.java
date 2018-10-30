package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.BannerEntity;
import com.liuge.TMShop.entity.MallEntity;

/**
 * Created by Administrator on 2018/8/22.
 */

public class SearchMallAdapter extends BaseAdapter {
    Context mContext;
    MallEntity entity;

    public SearchMallAdapter(Context mContext, MallEntity entity) {
        this.mContext = mContext;
        this.entity = entity;
    }

    public SearchMallAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return entity==null?0:(entity.getData().getResult()==null?0:entity.getData().getResult().size());
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_index_hot_mall, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(entity.getData().getResult().get(i).getBanner()).into(vh.iv_xianshi_img_1);
        vh.tv_pay_num_1.setText("销量："+entity.getData().getResult().get(i).getSales()+"件");
        vh.tv_shengyu_1.setText("剩余："+entity.getData().getResult().get(i).getTotal()+"件");
        vh.tv_xianshi_name_1.setText(entity.getData().getResult().get(i).getShopname());
        return view;
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_xianshi_img_1;
        public TextView tv_xianshi_name_1;
        public TextView tv_haopin;
        public TextView tv_pay_num_1;
        public TextView tv_shengyu_1;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_xianshi_img_1 = (ImageView) rootView.findViewById(R.id.iv_xianshi_img_1);
            this.tv_xianshi_name_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_name_1);
            this.tv_haopin = (TextView) rootView.findViewById(R.id.tv_haopin);
            this.tv_pay_num_1 = (TextView) rootView.findViewById(R.id.tv_pay_num_1);
            this.tv_shengyu_1 = (TextView) rootView.findViewById(R.id.tv_shengyu_1);
        }

    }
}
