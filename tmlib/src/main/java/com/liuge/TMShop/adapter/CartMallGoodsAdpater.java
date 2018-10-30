package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.CartEntity;
import com.liuge.TMShop.fragment.CartFragment;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.network.SixGridContext;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.LoadDialog;

import org.xutils.common.Callback;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CartMallGoodsAdpater extends BaseAdapter {
    Context mContext;
    List<CartEntity.DataBean.GoodsBean.ResultBean> mList;

    private CheckBox all;

    private boolean isAll=false;

    private Map<Integer,Boolean> map=new HashMap<>();
    CartMallAdapter.choose choose;
    double price=0;

    public void setmList(List<CartEntity.DataBean.GoodsBean.ResultBean> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public CartMallGoodsAdpater(Context mContext,CheckBox all,CartMallAdapter.choose choose) {
        this.mContext = mContext;
        this.all=all;
        this.choose=choose;
    }

    public void setAll(boolean isall){
        isAll=isall;
        map.clear();
        if(isAll){
            price=0;
            for(int x=0;x<getCount();x++){
                map.put(x,true);
                price=(new BigDecimal(price).add((new BigDecimal(mList.get(x).getPrice()))).multiply(new BigDecimal(mList.get(x).getQuantity()))).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }else{
            price=0;
        }
        choose.getPrice(price);
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
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder vh= null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_cart_goods, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        vh.cb_goods.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    map.put(i,true);
                }else{
                    all.setChecked(false);
                    map.remove(i);
                }
                if(map.size()==getCount()){
                    all.setChecked(true);
                }else{
                    all.setChecked(false);
                }
            }
        });

        if(map!=null&&map.containsKey(i)){
            vh.cb_goods.setChecked(true);
        }else{
            vh.cb_goods.setChecked(false);
            all.setChecked(false);
        }

        vh.cb_goods.setChecked(mList.get(i).getIs_shipping().equals("1"));

        final CheckBox cb=vh.cb_goods;
        vh.cb_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb.isChecked()){
//                    price=((new BigDecimal(price).add((new BigDecimal(mList.get(i).getPrice()))).multiply(new BigDecimal(mList.get(i).getQuantity())))).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//                    System.out.println("价格jia:"+price);
                    Choose(mList.get(i).getRec_id(),1);
                }else{
//                    price=((new BigDecimal(price).subtract((new BigDecimal(mList.get(i).getPrice()))).multiply(new BigDecimal(mList.get(i).getQuantity())))).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//                    System.out.println("价格jian:"+price);
                    Choose(mList.get(i).getRec_id(),0);
                }
//                choose.getPrice(price);
            }
        });

        Glide.with(mContext).load(mList.get(i).getGoods_image()).into(vh.iv_goods_img);
        vh.tv_goods_name.setText(mList.get(i).getGoods_name());
        vh.tv_guige.setText("规格："+mList.get(i).getSpecification());
        vh.tv_color.setVisibility(View.GONE);
        vh.tv_price.setText(SixGridContext.RMB+mList.get(i).getPrice());
        vh.tv_num.setText(mList.get(i).getQuantity());

        vh.tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upNum(mList.get(i).getSpec_id(),Integer.valueOf(mList.get(i).getQuantity())+1);
            }
        });
        vh.tv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upNum(mList.get(i).getSpec_id(),Integer.valueOf(mList.get(i).getQuantity())-1);
            }
        });

        return view;
    }

    private void Choose(String id, int status){
        LoadDialog.show(mContext);
        new ApiManager().chooseOne(id, status, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                CartFragment.instance.getCart();
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
        public TextView tv_price;

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
            this.tv_price = (TextView) rootView.findViewById(R.id.tv_price);
        }

    }

    private void upNum(String id,int num){
        LoadDialog.show(mContext);
        new ApiManager().cart_update(id, "" + num, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                CartFragment.instance.getCart();
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

}
