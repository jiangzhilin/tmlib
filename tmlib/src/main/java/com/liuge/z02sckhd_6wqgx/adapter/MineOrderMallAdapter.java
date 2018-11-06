package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.MineOrderEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.ui.MineOrderActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import org.xutils.common.Callback;

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
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_order_mall_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tv_mall_name.setText(mList.get_orders().get(position).getShopname());
        vh.bt_Receive.setVisibility(View.GONE);
        vh.bt_Wuliu.setVisibility(View.GONE);
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
                vh.bt_Receive.setVisibility(View.VISIBLE);
                vh.bt_Receive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goodsReceive(mList.get_orders().get(position).getOrder_id());
                    }
                });
                vh.bt_Wuliu.setVisibility(View.VISIBLE);
                vh.bt_Wuliu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
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


    private void goodsReceive(String id){
        LoadDialog.show(mContext);
        new ApiManager().orderRecive(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                if(MineOrderActivity.instence!=null){
                    MineOrderActivity.instence.mineOrer();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_mall_name;
        public TextView tv_status;
        public NoScroListView goods;
        public Button bt_Receive;
        public Button bt_Wuliu;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_mall_name = (TextView) rootView.findViewById(R.id.tv_mall_name);
            this.tv_status = (TextView) rootView.findViewById(R.id.tv_status);
            this.goods = (NoScroListView) rootView.findViewById(R.id.goods);
            this.bt_Receive = (Button) rootView.findViewById(R.id.bt_receive);
            this.bt_Wuliu = (Button) rootView.findViewById(R.id.bt_wuliu);
        }

    }
}
