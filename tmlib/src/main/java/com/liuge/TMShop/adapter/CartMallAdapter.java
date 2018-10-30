package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.CartEntity;
import com.liuge.TMShop.fragment.CartFragment;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroListView;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CartMallAdapter extends BaseAdapter {
    Context mContext;

    CartEntity entity;

    private CheckBox all;

    private boolean isAll=false;

    private Map<Integer,Boolean>map=new HashMap<>();

    public interface choose{
        public void getPrice(double price);
    }

    choose choose;

    public void setEntity(CartEntity entity) {
        this.entity = entity;
        this.notifyDataSetChanged();
    }

    public CartMallAdapter(Context mContext,CheckBox all,choose choose) {
        this.mContext = mContext;
        this.all=all;
        this.choose=choose;
    }

    public void setAll(boolean isall){
        isAll=isall;
        map.clear();
        if(isAll){
            for(int x=0;x<getCount();x++){
                map.put(x,true);
            }
        }else{

        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return entity==null?0:entity.getData().getGoods().size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_cart, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        final CartMallGoodsAdpater adapter=new CartMallGoodsAdpater(mContext,vh.cb_mall,choose);
        vh.list.setAdapter(adapter);
        adapter.setmList(entity.getData().getGoods().get(i).getResult());

        vh.cb_mall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
//                if(all.isChecked()){
//                    adapter.setAll(true);
//                }
            }
        });

        if(map!=null&&map.containsKey(i)){
            vh.cb_mall.setChecked(true);
        }else{
            vh.cb_mall.setChecked(false);
            all.setChecked(false);
        }

        vh.cb_mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb=(CheckBox)v;
//                adapter.setAll(cb.isChecked());
                if(cb.isChecked()){
                    chooseAll(entity.getData().getGoods().get(i).getSid(),1);
                }else{
                    chooseAll(entity.getData().getGoods().get(i).getSid(),0);
                }
            }
        });

        vh.tv_mall_name.setText(entity.getData().getGoods().get(i).getShopname());
        return view;
    }

    private void chooseAll(String id,int status){
        LoadDialog.show(mContext);
        new ApiManager().chooseAll(id, status, new Callback.CommonCallback<String>() {
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
