package com.liuge.TMShop.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.GoodsClassEntity;

/**
 * Created by Administrator on 2018/8/21.
 */

public class ClassicAdapter extends BaseAdapter {
    Context mContext;
    int[]icons;
    String[]names;
    GoodsClassEntity entity;

    public ClassicAdapter(Context mContext, GoodsClassEntity entity) {
        this.mContext = mContext;
        this.entity=entity;
    }

    @Override
    public int getCount() {
        return entity==null?0:entity.getData().size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_index_classic, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(entity.getData().get(i).getImage()).into(vh.iv_icon);
        vh.tv_name.setText(entity.getData().get(i).getName());

        return view;
    }

    public class ViewHolder{
        public View rootView;
        public ImageView iv_icon;
        public TextView tv_name;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_icon = (ImageView) rootView.findViewById(R.id.iv_icon);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
        }

    }
}
