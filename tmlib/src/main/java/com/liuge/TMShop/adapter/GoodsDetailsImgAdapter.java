package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class GoodsDetailsImgAdapter extends BaseAdapter {
    Context mContext;
//    String[] img;
    List<String> img;

    public GoodsDetailsImgAdapter(Context mContext, List<String> img) {
        this.mContext = mContext;
        this.img = img;
    }

    @Override
    public int getCount() {
        return img == null ? 0 : img.size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_goods_details_layout, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(img.get(i)).into(vh.iv_img);

        return view;
    }

    public  class ViewHolder {
        public View rootView;
        public ImageView iv_img;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }
}
