package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.liuge.TMShop.R;
import com.liuge.TMShop.view.NoScroListView;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CartMallAdapter extends BaseAdapter {
    Context mContext;

    public CartMallAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 5;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_cart, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        CartMallGoodsAdpater adapter=new CartMallGoodsAdpater(mContext,i+1);
        vh.list.setAdapter(adapter);
        return view;
    }

    public class ViewHolder {
        public View rootView;
        public CheckBox cb_mall;
        public TextView tv_mall_name;
        public NoScroListView list;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.cb_mall = (CheckBox) rootView.findViewById(R.id.cb_mall);
            this.tv_mall_name = (TextView) rootView.findViewById(R.id.tv_mall_name);
            this.list = (NoScroListView) rootView.findViewById(R.id.listView);
        }

    }
}
