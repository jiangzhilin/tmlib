package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.CollectMallEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.ui.CollectActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2018/10/18.
 */

public class CollectMallsAdapter extends BaseAdapter {

    Context mContext;

    CollectMallEntity goods;

    public void setGoods(CollectMallEntity goods) {
        this.goods = goods;
        this.notifyDataSetChanged();
    }

    public CollectMallsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return goods == null ? 0 : goods.getData().getResult().size();
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
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_layout_collect_mall, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(goods.getData().getResult().get(i).getBanner()).into(vh.iv_xianshi_img_1);
        vh.tv_xianshi_name_1.setText(goods.getData().getResult().get(i).getShopname());

//        vh.tv_haopin.setText(goods.getData().getResult().get(i)/);

        vh.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delCollect(goods.getData().getResult().get(i).getGoods_id());
            }
        });

        return view;
    }

    private void delCollect(String id) {
        LoadDialog.show(mContext);
        new ApiManager().delCollect(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base = JSONObject.parseObject(result, BaseEntity.class);
                NToast.shortToast(mContext, base.getMsg());
                CollectActivity.instance.MineCollect();
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

    class ViewHolder {
        public View rootView;
        public ImageView iv_xianshi_img_1;
        public TextView tv_xianshi_name_1;
        public TextView tv_haopin;
        public TextView tv_pay_num_1;
        public TextView tv_shengyu_1;
        public Button del;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_xianshi_img_1 = (ImageView) rootView.findViewById(R.id.iv_xianshi_img_1);
            this.tv_xianshi_name_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_name_1);
            this.tv_haopin = (TextView) rootView.findViewById(R.id.tv_haopin);
            this.tv_pay_num_1 = (TextView) rootView.findViewById(R.id.tv_pay_num_1);
            this.tv_shengyu_1 = (TextView) rootView.findViewById(R.id.tv_shengyu_1);
            this.del = (Button) rootView.findViewById(R.id.del);
        }

    }
}
