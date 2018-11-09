package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BannerEntity;
import com.liuge.z02sckhd_6wqgx.ui.GoodsDetailsActivity;
import com.liuge.z02sckhd_6wqgx.ui.GoodsMiaoshaActivity;
import com.liuge.z02sckhd_6wqgx.ui.PaimaiDetailsActivity;
import com.liuge.z02sckhd_6wqgx.ui.TuangouDetailsActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.NoScroGridView;
import com.tenma.ventures.bean.utils.TMSharedPUtil;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IndexListAdapter extends BaseAdapter {
    Context mContext;
    BannerEntity entity;
    BannerEntity back_entity;
    int size=4;
    List<String>tag=new ArrayList<>();

    public IndexListAdapter(Context mContext, BannerEntity entity) {
        this.mContext = mContext;
        this.entity = entity;
        back_entity=entity;

        tag.add(""+0);
        tag.add(""+1);
        tag.add(""+2);
        tag.add(""+3);

//        for(int x=0;x<4;x++){
        if(this.entity.getData().getAuction().size()==0){
            tag.remove("0");
            size=size-1;
        }
        if(this.entity.getData().getGroupbuy().size()==0){
            size=size-1;
            tag.remove("1");
        }
        if(this.entity.getData().getSpike().size()==0){
            size=size-1;
            tag.remove("2");
        }
        if(this.entity.getData().getIsbest().size()==0){
            size=size-1;
            tag.remove("3");
        }
//        }
    }

    public IndexListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return size;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_index_goods, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

//        switch (i) {
//            case 0:
//                if(tag.get(i).equals("1")) {
//                    Log.d(TAG, "getView: entity.getData().getAuction().size==" + entity.getData().getAuction().size());
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_paimai).into(vh.iv_head);
//                    PaimaiAdapter adapter = new PaimaiAdapter(mContext, entity.getData().getAuction());
//                    vh.gv_goods.setAdapter(adapter);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent = new Intent(mContext, PaimaiDetailsActivity.class);
//                            intent.putExtra("id", entity.getData().getAuction().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("2")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuangou).into(vh.iv_head);
//                    TuangouAdapter adapter2=new TuangouAdapter(mContext,entity.getData().getGroupbuy());
//                    vh.gv_goods.setAdapter(adapter2);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,TuangouDetailsActivity.class);
//                            intent.putExtra("id",entity.getData().getGroupbuy().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("3")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_miaosha).into(vh.iv_head);
//                    MiaoshaAdapter adapter3=new MiaoshaAdapter(mContext,entity.getData().getSpike());
//                    vh.gv_goods.setAdapter(adapter3);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsMiaoshaActivity.class);
//                            intent.putExtra("id",entity.getData().getSpike().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("4")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuijian).into(vh.iv_head);
//                    TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
//                    vh.gv_goods.setAdapter(adapter4);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
//                            intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }
//                break;
//            case 1:
////                vh.iv_head.setBackgroundResource(R.mipmap.z02sckhd_6wqgx_bg_tuangou);
//                if(tag.get(i).equals("2")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuangou).into(vh.iv_head);
//                    TuangouAdapter adapter2=new TuangouAdapter(mContext,entity.getData().getGroupbuy());
//                    vh.gv_goods.setAdapter(adapter2);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,TuangouDetailsActivity.class);
//                            intent.putExtra("id",entity.getData().getGroupbuy().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("3")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_miaosha).into(vh.iv_head);
//                    MiaoshaAdapter adapter3=new MiaoshaAdapter(mContext,entity.getData().getSpike());
//                    vh.gv_goods.setAdapter(adapter3);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsMiaoshaActivity.class);
//                            intent.putExtra("id",entity.getData().getSpike().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("4")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuijian).into(vh.iv_head);
//                    TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
//                    vh.gv_goods.setAdapter(adapter4);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
//                            intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }
//                break;
//            case 2:
//                if(tag.get(i).equals("3")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_miaosha).into(vh.iv_head);
//                    MiaoshaAdapter adapter3=new MiaoshaAdapter(mContext,entity.getData().getSpike());
//                    vh.gv_goods.setAdapter(adapter3);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsMiaoshaActivity.class);
//                            intent.putExtra("id",entity.getData().getSpike().get(i).getAct_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }else if(tag.get(i).equals("4")){
//                    Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuijian).into(vh.iv_head);
//                    TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
//                    vh.gv_goods.setAdapter(adapter4);
//                    vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                            Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
//                            intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
//                            mContext.startActivity(intent);
//                        }
//                    });
//                }
//                break;
//            case 3:
////                vh.iv_head.setBackgroundResource(R.mipmap.z02sckhd_6wqgx_bg_tuijian);
//                Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuijian).into(vh.iv_head);
//                TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
//                vh.gv_goods.setAdapter(adapter4);
//                vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
//                        intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
//                        mContext.startActivity(intent);
//                    }
//                });
//                break;
//
//        }

        if(tag.get(i).equals("0")) {
            Log.d(TAG, "getView: 拍卖");
            Log.d(TAG, "getView: entity.getData().getAuction().size==" + entity.getData().getAuction().size());
            Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_paimai).into(vh.iv_head);
            PaimaiAdapter adapter = new PaimaiAdapter(mContext, entity.getData().getAuction());
            vh.gv_goods.setAdapter(adapter);
            vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(TMSharedPUtil.getTMUser(mContext)==null){
                        NToast.shortToast(mContext,"请先登录");
                        return;
                    }
                    Intent intent = new Intent(mContext, PaimaiDetailsActivity.class);
                    intent.putExtra("id", entity.getData().getAuction().get(i).getAct_id());
                    mContext.startActivity(intent);
                }
            });
        }else if(tag.get(i).equals("1")){
            Log.d(TAG, "getView: 团购");
            Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuangou).into(vh.iv_head);
            TuangouAdapter adapter2=new TuangouAdapter(mContext,entity.getData().getGroupbuy());
            vh.gv_goods.setAdapter(adapter2);
            vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(TMSharedPUtil.getTMUser(mContext)==null){
                        NToast.shortToast(mContext,"请先登录");
                        return;
                    }
                    Intent intent=new Intent(mContext,TuangouDetailsActivity.class);
                    intent.putExtra("id",entity.getData().getGroupbuy().get(i).getAct_id());
                    mContext.startActivity(intent);
                }
            });
        }else if(tag.get(i).equals("2")){
            Log.d(TAG, "getView: 秒杀");
            Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_miaosha).into(vh.iv_head);
            MiaoshaAdapter adapter3=new MiaoshaAdapter(mContext,entity.getData().getSpike());
            vh.gv_goods.setAdapter(adapter3);
            vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(TMSharedPUtil.getTMUser(mContext)==null){
                        NToast.shortToast(mContext,"请先登录");
                        return;
                    }
                    Intent intent=new Intent(mContext,GoodsMiaoshaActivity.class);
                    intent.putExtra("id",entity.getData().getSpike().get(i).getAct_id());
                    mContext.startActivity(intent);
                }
            });
        }else if(tag.get(i).equals("3")){
            Log.d(TAG, "getView: 推荐");
            Glide.with(mContext).load(R.mipmap.z02sckhd_6wqgx_bg_tuijian).into(vh.iv_head);
            TuiJianAdapter adapter4=new TuiJianAdapter(mContext,entity.getData().getIsbest());
            vh.gv_goods.setAdapter(adapter4);
            vh.gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(TMSharedPUtil.getTMUser(mContext)==null){
                        NToast.shortToast(mContext,"请先登录");
                        return;
                    }
                    Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                    intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
                    mContext.startActivity(intent);
                }
            });
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
