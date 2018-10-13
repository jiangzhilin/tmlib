package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.liuge.TMShop.R;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CartMallGoodsAdpater extends BaseAdapter {
    Context mContext;
    int size;

    public CartMallGoodsAdpater(Context mContext, int size) {
        this.mContext = mContext;
        this.size = size;
    }

    @Override
    public int getCount() {
        return size;
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

        ViewHolder vh= null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_cart_goods, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        return view;
    }

    public class ViewHolder {
        public View rootView;
        public CheckBox cb_goods;
        public ImageView iv_goods_img;
        public TextView tv_goods_name;
        public TextView tv_guige;
        public TextView tv_color;
        public TextView tv_sub;
        public TextView tv_num;
        public TextView tv_add;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.cb_goods = (CheckBox) rootView.findViewById(R.id.cb_goods);
            this.iv_goods_img = (ImageView) rootView.findViewById(R.id.iv_goods_img);
            this.tv_goods_name = (TextView) rootView.findViewById(R.id.tv_goods_name);
            this.tv_guige = (TextView) rootView.findViewById(R.id.tv_guige);
            this.tv_color = (TextView) rootView.findViewById(R.id.tv_color);
            this.tv_sub = (TextView) rootView.findViewById(R.id.tv_sub);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
            this.tv_add = (TextView) rootView.findViewById(R.id.tv_add);
        }

    }
}
