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
import com.liuge.TMShop.entity.GoodsListEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class IndexHotGoodsAdapter extends BaseAdapter {
    Context mContext;

    List<GoodsListEntity.DataBean.ResultBean>mList;

    public IndexHotGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(List<GoodsListEntity.DataBean.ResultBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
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

        ViewHolder vh= null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_index_main_goods, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get(i).getDefault_image()).into(vh.iv_xianshi_img_1);
        vh.tv_xianshi_name_1.setText(mList.get(i).getGoods_name());
        vh.tv_xianshi_detail_1.setText(mList.get(i).getDescription());
        vh.tv_xianshi_detail_1.setVisibility(View.GONE);
        vh.tv_xianshi_price_1.setText(mList.get(i).getPrice());
        vh.tv_pay_num_1.setText(mList.get(i).getGoods_number()+"人付款");
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
