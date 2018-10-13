package com.liuge.TMShop.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.BannerEntity;
import com.liuge.TMShop.ui.GoodsDetailsActivity;
import com.liuge.TMShop.ui.GoodsMiaoshaActivity;
import com.liuge.TMShop.ui.PaimaiDetailsActivity;
import com.liuge.TMShop.ui.TuangouDetailsActivity;
import com.liuge.TMShop.view.NoScroGridView;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IndexListAdapter extends BaseAdapter {
    Context mContext;
    BannerEntity entity;

    public IndexListAdapter(Context mContext, BannerEntity entity) {
        this.mContext = mContext;
        this.entity = entity;
    }

    public IndexListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 4;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_index_goods, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        switch (i) {
            case 0:
                Log.d(TAG, "getView: entity.getData().getAuction().size==" + entity.getData().getAuction().size());
                Glide.with(mContext).load(R.mipmap.bg_paimai).into(vh.iv_head);
                PaimaiAdapter adapter=new PaimaiAdapter(mContext,entity.getData().getAuction());
                vh.gv_goods.setAdapter(adapter);
                vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,PaimaiDetailsActivity.class);
                        intent.putExtra("id",entity.getData().getAuction().get(i).getAct_id());
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 1:
//                vh.iv_head.setBackgroundResource(R.mipmap.bg_tuangou);
                Glide.with(mContext).load(R.mipmap.bg_tuangou).into(vh.iv_head);
                TuangouAdapter adapter2=new TuangouAdapter(mContext,entity.getData().getGroupbuy());
                vh.gv_goods.setAdapter(adapter2);
                vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,TuangouDetailsActivity.class);
                        intent.putExtra("id",entity.getData().getGroupbuy().get(i).getAct_id());
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 2:
//                vh.iv_head.setBackgroundResource(R.mipmap.bg_miaosha);
                Glide.with(mContext).load(R.mipmap.bg_miaosha).into(vh.iv_head);
                MiaoshaAdapter adapter3=new MiaoshaAdapter(mContext,entity.getData().getSpike());
                vh.gv_goods.setAdapter(adapter3);
                vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,GoodsMiaoshaActivity.class);
                        intent.putExtra("id",entity.getData().getSpike().get(i).getAct_id());
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 3:
//                vh.iv_head.setBackgroundResource(R.mipmap.bg_tuijian);
                Glide.with(mContext).load(R.mipmap.bg_tuijian).into(vh.iv_head);
                TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
                vh.gv_goods.setAdapter(adapter4);
                vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                        intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
                        mContext.startActivity(intent);
                    }
                });
                break;

        }

        return view;
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_head;
        public NoScroGridView gv_goods;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.gv_goods = (NoScroGridView) rootView.findViewById(R.id.gv_goods);
        }

    }
}
