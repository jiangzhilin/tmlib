package com.liuge.TMShop.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.MineOrderEntity;
import com.liuge.TMShop.ui.OrderPayActivity;
import com.liuge.TMShop.utils.TimeUtils;
import com.liuge.TMShop.view.NoScroListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class MineOrderMallAdapter extends BaseAdapter {
    Context mContext;

    public static MineOrderMallAdapter instance;

    public MineOrderMallAdapter(Context mContext) {
        this.mContext = mContext;
        instance=this;
    }

    public MineOrderEntity.DataBean.ResultBean mList;
    int p=0;

    public void setmList(MineOrderEntity.DataBean.ResultBean mList) {
        this.mList = mList;

        this.notifyDataSetChanged();
    }
    public void setmList(MineOrderEntity.DataBean.ResultBean mList,int p) {
        this.mList = mList;
        this.p=p;

        if(p==3) {
            for(int y=0;y<mList.get_orders().size();y++) {
                MineOrderEntity.DataBean.ResultBean.OrdersBean mPingjiaOrder = new MineOrderEntity.DataBean.ResultBean.OrdersBean();

                mPingjiaOrder = mList.get_orders().get(y);

                for (int x = 0; x < mPingjiaOrder.get_goods().size(); x++) {
                    if (mPingjiaOrder.get_goods().get(x).getEvaluation_status().equals("1")) {
                        mPingjiaOrder.get_goods().remove(x);
                    }
                }
                if(mPingjiaOrder.get_goods().size()==0){
                    mList.get_orders().remove(y);
                }
//                adapter.setmList(mPingjiaOrder, "pinglun");
            }
        }else{
//            adapter.setmList(mList.get(position));
        }

        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.get_orders().size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_order_mall_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tv_mall_name.setText(mList.get_orders().get(position).getShopname());

        switch (Integer.valueOf(mList.get_orders().get(position).getOrder_status())) {
            case 11:
                vh.tv_status.setText("待支付");
                vh.tv_status.setTextColor(Color.parseColor("#ff5500"));

                break;
            case 20:
                vh.tv_status.setText("已支付");
                vh.tv_status.setTextColor(Color.parseColor("#0055ff"));

                break;
            case 30:
                vh.tv_status.setText("已发货");
                vh.tv_status.setTextColor(Color.parseColor("#00ff55"));

                break;
            case 40:
                vh.tv_status.setText("已完成");
                vh.tv_status.setTextColor(Color.parseColor("#00ffff"));
                break;
            case -1:
                vh.tv_status.setText("已取消");
                vh.tv_status.setTextColor(Color.parseColor("#ff0000"));
                break;
        }

        MineOrderGoodsAdapter adapter = new MineOrderGoodsAdapter(mContext);
        vh.goods.setAdapter(adapter);
        if(p==3) {
            MineOrderEntity.DataBean.ResultBean.OrdersBean mPingjiaOrder=new MineOrderEntity.DataBean.ResultBean.OrdersBean();

            mPingjiaOrder=mList.get_orders().get(position);

            for(int x=0;x<mPingjiaOrder.get_goods().size();x++){
                if(mPingjiaOrder.get_goods().get(x).getEvaluation_status().equals("1")){
                    mPingjiaOrder.get_goods().remove(x);
                }
            }
            adapter.setmList(mPingjiaOrder,"pinglun");
        }else{
            adapter.setmList(mList.get_orders().get(position));
        }

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_mall_name;
        public TextView tv_status;
        public NoScroListView goods;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_mall_name = (TextView) rootView.findViewById(R.id.tv_mall_name);
            this.tv_status = (TextView) rootView.findViewById(R.id.tv_status);
            this.goods = (NoScroListView) rootView.findViewById(R.id.goods);
        }

    }
}
