package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.SubmitCartEntity;
import com.liuge.TMShop.network.SixGridContext;
import com.liuge.TMShop.view.NoScroListView;

import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class SubmitMallAdapter extends BaseAdapter {
    Context mContext;

    public SubmitMallAdapter(Context mContext) {
        this.mContext = mContext;
    }
    SubmitCartEntity entity;
//    List<SubmitCartEntity.DataBean.GoodsListBean.GoodsBean> mList;

    public void setmList(SubmitCartEntity entity) {
        this.entity = entity;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return entity == null ? 0 : entity.getData().getGoods_list().getGoods().size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_submit_mall_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tv_mall_name.setText(entity.getData().getGoods_list().getGoods().get(position).getShopname());
        vh.tv_num.setText("共"+entity.getData().getGoods_list().getQuantity()+"件商品");
        vh.tv_price.setText(SixGridContext.RMB+entity.getData().getGoods_list().getAmount());

        SubmitCartGoodsAdapter adapter=new SubmitCartGoodsAdapter(mContext);
        vh.goods.setAdapter(adapter);
        adapter.setmList(entity.getData().getGoods_list().getGoods().get(position).getResult());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_mall_name;
        public NoScroListView goods;
        public TextView tv_type;
        public TextView tv_sms_price;
        public TextView tv_price;
        public EditText ed_liuyan;
        public TextView tv_num;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_mall_name = (TextView) rootView.findViewById(R.id.tv_mall_name);
            this.goods = (NoScroListView) rootView.findViewById(R.id.goods);
            this.tv_type = (TextView) rootView.findViewById(R.id.tv_type);
            this.tv_sms_price = (TextView) rootView.findViewById(R.id.tv_sms_price);
            this.tv_price = (TextView) rootView.findViewById(R.id.tv_price);
            this.ed_liuyan = (EditText) rootView.findViewById(R.id.ed_liuyan);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
        }

    }
}
