package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.MineOrderEntity;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.ui.MineOrderActivity;
import com.liuge.z02sckhd_6wqgx.ui.OrderDetailsActivity;
import com.liuge.z02sckhd_6wqgx.ui.OrderPayActivity;
import com.liuge.z02sckhd_6wqgx.utils.TimeUtils;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

/**
 * Created by jiang on 2018/10/25.
 */

public class MineOrderAdapter extends BaseAdapter {
    Context mContext;

    int p = 0;

    public MineOrderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    MineOrderEntity entity;

    public void setEntity(MineOrderEntity entity, int p) {
        this.entity = entity;
        this.p = p;

        if (p == 3) {
            if (entity != null && entity.getData() != null) {
                for (int y = 0; y < entity.getData().getResult().size(); y++) {
                    for (int i = 0; i < entity.getData().getResult().get(y).get_orders().size(); i++) {
                        MineOrderEntity.DataBean.ResultBean.OrdersBean mPingjiaOrder = new MineOrderEntity.DataBean.ResultBean.OrdersBean();
                        mPingjiaOrder = entity.getData().getResult().get(y).get_orders().get(i);

                        for (int x = 0; x < mPingjiaOrder.get_goods().size(); x++) {
                            if (mPingjiaOrder.get_goods().get(x).getEvaluation_status().equals("1")) {
                                mPingjiaOrder.get_goods().remove(x);
                            }
                        }
                        if (mPingjiaOrder.get_goods().size() == 0) {
                            entity.getData().getResult().get(y).get_orders().remove(i);
                        }
                    }
                    if (entity.getData().getResult().get(y).get_orders().size() == 0) {
                        entity.getData().getResult().remove(y);
                    }
                }
            }
        } else {
//            adapter.setmList(mList.get(position));
        }

        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return entity == null ? 0 : (entity.getData() == null ? 0 : entity.getData().getResult().size());
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_mine_order_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.tv_sn.setText("订单编号：" + entity.getData().getResult().get(position).getOrder_sn());
        vh.tv_time.setText("创建时间" + TimeUtils.getStrTime(entity.getData().getResult().get(position).getAdd_time() + "000"));
//        vh.tv_mall_name.setText(entity.getData().getResult().get(0).get_orders().get(position).getShopname());
        vh.tv_num.setText("共" + entity.getData().getResult().get(position).get_orders().get(0).get_goods().get(0).getGoods_numbers() + "件商品");
        vh.tv_price.setText(SixGridContext.RMB + entity.getData().getResult().get(position).getOrder_amount());
        switch (Integer.valueOf(entity.getData().getResult().get(position).get_orders().get(0).getOrder_status())) {
            case 11:
//                vh.tv_status.setText("待支付");
//                vh.tv_status.setTextColor(Color.parseColor("#ff5500"));

                vh.ll_bottom.setVisibility(View.VISIBLE);
                vh.bt_1.setText("立即付款");
                vh.bt_2.setVisibility(View.VISIBLE);
                vh.bt_2.setText("取消订单");
                vh.bt_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //去支付
                        Intent intent = new Intent(mContext, OrderPayActivity.class);
                        intent.putExtra("sn", entity.getData().getResult().get(position).getOrder_sn());
                        intent.putExtra("time", TimeUtils.getStrTime(entity.getData().getResult().get(position).getAdd_time() + "000"));
                        intent.putExtra("price", entity.getData().getResult().get(position).getOrder_amount());
                        intent.putExtra("mid", entity.getData().getResult().get(position).getMid());
                        mContext.startActivity(intent);
                    }
                });
                vh.bt_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消订单
                        if (MineOrderActivity.instence != null) {
                            MineOrderActivity.instence.cancal(entity.getData().getResult().get(position).getMid());
                        }
                    }
                });

                break;
            case 20:
//                vh.tv_status.setText("已支付");
//                vh.tv_status.setTextColor(Color.parseColor("#0055ff"));

//                vh.ll_bottom.setVisibility(View.GONE);
//                vh.bt_1.setText("立即付款");
//                vh.bt_2.setText("取消订单");
//                vh.bt_1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //去支付
//                    }
//                });
//                vh.bt_2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //取消订单
//                    }
//                });
                vh.ll_bottom.setVisibility(View.VISIBLE);
                vh.bt_1.setVisibility(View.GONE);
                vh.bt_2.setVisibility(View.GONE);

                break;
            case 30:
//                vh.tv_status.setText("已发货");
//                vh.tv_status.setTextColor(Color.parseColor("#00ff55"));

                vh.ll_bottom.setVisibility(View.VISIBLE);
                vh.bt_1.setVisibility(View.GONE);
                vh.bt_1.setText("确认收货");
                vh.bt_2.setVisibility(View.GONE);
                vh.bt_2.setText("查看物流");
                vh.bt_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //确认收货
//                        goodsReceive(entity.getData().getResult().get(position).getOrder_sn());
                    }
                });
                vh.bt_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取查看物流
                    }
                });

                break;
            case 40:
//                vh.tv_status.setText("已完成");
//                vh.tv_status.setTextColor(Color.parseColor("#00ffff"));

//                vh.ll_bottom.setVisibility(View.GONE);
//                vh.bt_1.setText("退换货");
//                vh.bt_1.setVisibility(View.GONE);
////                if (!entity.getData().getResult().get(position).get_orders().get(0).getEvaluation_status().equals("1")) {
////                    vh.bt_2.setText("评价");
////                    vh.bt_2.setVisibility(View.VISIBLE);
////                } else {
//                    vh.bt_2.setVisibility(View.GONE);
////                }
//                vh.bt_1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //去支付
//                    }
//                });
//                vh.bt_2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //取消订单
//                    }
//                });

                vh.ll_bottom.setVisibility(View.VISIBLE);
                vh.bt_1.setVisibility(View.GONE);
                vh.bt_2.setVisibility(View.GONE);

                break;
            case -1:
//                vh.tv_status.setText("已取消");
//                vh.tv_status.setTextColor(Color.parseColor("#ff0000"));

                vh.ll_bottom.setVisibility(View.VISIBLE);
                vh.bt_1.setVisibility(View.GONE);
                vh.bt_2.setVisibility(View.GONE);
                vh.bt_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //去支付
                    }
                });
                vh.bt_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消订单
                    }
                });

                break;
        }

        MineOrderMallAdapter adapter = new MineOrderMallAdapter(mContext);
        vh.mall_list.setAdapter(adapter);
        adapter.setmList(entity.getData().getResult().get(position), p);

        vh.bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                intent.putExtra("order", entity.getData().getResult().get(position));
                mContext.startActivity(intent);
            }
        });

        vh.tv_yunfei.setText(entity.getData().getResult().get(position).get_orders().get(0).getPay_fee());

        return view;
    }

    class ViewHolder {
        public View rootView;
        public TextView tv_sn;
        public TextView tv_time;
        public NoScroListView mall_list;
        public TextView tv_num;
        public TextView tv_yunfei;
        public TextView tv_price;
        public Button bt_1;
        public Button bt_2;
        public Button bt_3;
        public LinearLayout ll_bottom;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_sn = (TextView) rootView.findViewById(R.id.tv_sn);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
            this.mall_list = (NoScroListView) rootView.findViewById(R.id.mall_list);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
            this.tv_yunfei = (TextView) rootView.findViewById(R.id.tv_yunfei);
            this.tv_price = (TextView) rootView.findViewById(R.id.tv_price);
            this.bt_1 = (Button) rootView.findViewById(R.id.bt_1);
            this.bt_2 = (Button) rootView.findViewById(R.id.bt_2);
            this.bt_3 = (Button) rootView.findViewById(R.id.bt_3);
            this.ll_bottom = (LinearLayout) rootView.findViewById(R.id.ll_bottom);
        }

    }
}
