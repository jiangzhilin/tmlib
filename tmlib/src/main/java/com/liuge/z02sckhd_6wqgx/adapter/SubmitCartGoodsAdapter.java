package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.SubmitCartEntity;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;

import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class SubmitCartGoodsAdapter extends BaseAdapter {
    Context mContext;

    public SubmitCartGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    List<SubmitCartEntity.DataBean.GoodsListBean.GoodsBean.ResultBean> mList;

    public void setmList(List<SubmitCartEntity.DataBean.GoodsListBean.GoodsBean.ResultBean> mList) {
        this.mList = mList;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_submit_goods_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get(position).getGoods_image()).into(vh.iv_goods_img);

        vh.tv_goods_name.setText(mList.get(position).getGoods_name());
        vh.tv_guige.setText("规格："+mList.get(position).getSpecification());
        vh.tv_goods_price.setText(SixGridContext.RMB+mList.get(position).getPrice());

        vh.tv_num.setText("x"+mList.get(position).getQuantity());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView iv_goods_img;
        public TextView tv_goods_name;
        public TextView tv_guige;
        public TextView tv_goods_price;
        public TextView tv_num;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_goods_img = (ImageView) rootView.findViewById(R.id.iv_goods_img);
            this.tv_goods_name = (TextView) rootView.findViewById(R.id.tv_goods_name);
            this.tv_guige = (TextView) rootView.findViewById(R.id.tv_guige);
            this.tv_goods_price = (TextView) rootView.findViewById(R.id.tv_goods_price);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
        }

    }
}
