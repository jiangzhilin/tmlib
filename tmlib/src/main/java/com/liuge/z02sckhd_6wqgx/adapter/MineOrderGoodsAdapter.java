package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.MineOrderEntity;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.ui.CommentActivity;
import com.liuge.z02sckhd_6wqgx.ui.TuiHuanHuoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2018/10/25.
 */

public class MineOrderGoodsAdapter extends BaseAdapter {
    Context mContext;

    String pinglun=null;

    public MineOrderGoodsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    MineOrderEntity.DataBean.ResultBean.OrdersBean mList;

    public void setmList(MineOrderEntity.DataBean.ResultBean.OrdersBean mList) {
        this.mList = mList;
    }

    public void setmList(MineOrderEntity.DataBean.ResultBean.OrdersBean mList,String pinglun) {
        this.mList = mList;
        this.pinglun=pinglun;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.get_goods().size();
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
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_submit_goods_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get_goods().get(position).getGoods_image()).into(vh.iv_goods_img);


        System.out.println("上坪状态L:"+mList.get_goods().get(position).getGoods_status());

        if (mList.getOrder_status().equals("40")) {
            if(pinglun!=null) {
                vh.ll_complete.setVisibility(View.VISIBLE);
                vh.bt_pingjia.setVisibility(View.VISIBLE);
                vh.bt_tuihuan.setVisibility(View.GONE);
                vh.bt_pingjia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(mContext,CommentActivity.class);
                        intent.putExtra("goods",mList.get_goods().get(position));
                        mContext.startActivity(intent);
                    }
                });
            }else{
                if(mList.get_goods().get(position).getGoods_status().equals("0")) {
                    vh.ll_complete.setVisibility(View.VISIBLE);
                    vh.bt_pingjia.setVisibility(View.GONE);
                    vh.bt_tuihuan.setVisibility(View.VISIBLE);
                    vh.bt_tuihuan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(MineOrderMallAdapter.instance!=null){
                                MineOrderEntity.DataBean.ResultBean order=new MineOrderEntity.DataBean.ResultBean();
                                order.setAdd_time(MineOrderMallAdapter.instance.mList.getAdd_time());
                                order.setOrder_sn(MineOrderMallAdapter.instance.mList.getOrder_sn());
                                List<MineOrderEntity.DataBean.ResultBean.OrdersBean>orders=new ArrayList<MineOrderEntity.DataBean.ResultBean.OrdersBean>();
                                List<MineOrderEntity.DataBean.ResultBean.OrdersBean.GoodsBean>goods=new ArrayList<MineOrderEntity.DataBean.ResultBean.OrdersBean.GoodsBean>();
                                goods.add(mList.get_goods().get(position));
                                mList.set_goods(goods);
                                orders.add(mList);
                                order.set_orders(orders);
                                Intent intent=new Intent(mContext,TuiHuanHuoActivity.class);
                                intent.putExtra("order",order);
                                mContext.startActivity(intent);
                            }
                        }
                    });
                }else{
                    vh.ll_complete.setVisibility(View.GONE);
                }
            }
        } else {
            vh.ll_complete.setVisibility(View.GONE);

        }

        vh.tv_goods_name.setText(mList.get_goods().get(position).getGoods_name());
        vh.tv_guige.setText("规格：" + mList.get_goods().get(position).getGoods_attr());
        vh.tv_goods_price.setText(SixGridContext.RMB + mList.get_goods().get(position).getGoods_price());

        vh.tv_num.setText("x" + mList.get_goods().get(position).getGoods_numbers());

        return view;
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_goods_img;
        public TextView tv_goods_name;
        public TextView tv_guige;
        public TextView tv_goods_price;
        public TextView tv_num;
        public Button bt_tuihuan;
        public Button bt_pingjia;
        public LinearLayout ll_complete;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_goods_img = (ImageView) rootView.findViewById(R.id.iv_goods_img);
            this.tv_goods_name = (TextView) rootView.findViewById(R.id.tv_goods_name);
            this.tv_guige = (TextView) rootView.findViewById(R.id.tv_guige);
            this.tv_goods_price = (TextView) rootView.findViewById(R.id.tv_goods_price);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
            this.bt_tuihuan = (Button) rootView.findViewById(R.id.bt_tuihuan);
            this.bt_pingjia = (Button) rootView.findViewById(R.id.bt_pingjia);
            this.ll_complete = (LinearLayout) rootView.findViewById(R.id.ll_complete);
        }

    }
}
