package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BannerEntity;
import com.liuge.z02sckhd_6wqgx.utils.TimeUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/9/18.
 */

public class MiaoshaAdapter extends BaseAdapter {
    Context mContext;
    List<BannerEntity.DataBean.SpikeBean> mList;

    public MiaoshaAdapter(Context mContext, List<BannerEntity.DataBean.SpikeBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_index_layout_goods, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        Glide.with(mContext).load(mList.get(i).getDefault_image()).into(vh.iv_xianshi_img_1);
        vh.tv_xianshi_name_1.setText(mList.get(i).getGoods_name());
        vh.tv_jingpai_num_1.setText(mList.get(i).getOnum() + "人秒杀");
//        vh.ll_jingpai.setVisibility(View.GONE);
        vh.tv_xianshi_detail_1.setText(mList.get(i).getTotal());
        vh.tv_xianshi_detail_1.setVisibility(View.GONE);
        vh.tv_price_txt.setText("秒杀价");
        vh.tv_xianshi_price_1.setText(mList.get(i).getPrice());
        vh.ll_time.setVisibility(View.GONE);
        vh.tv_data.setVisibility(View.VISIBLE);
        TimeUtils.getReturnTime(mList.get(i).getEnd_time(),vh.tv_data);
        vh.tv_pay_num_1.setText(mList.get(i).getOnum() + "人付款");
        vh.tv_shengyu_1.setText("剩余宝贝" + mList.get(i).getOnum() + "件");
        vh.rl_bottom.setVisibility(View.GONE);
        return view;
    }


    class ViewHolder {
        public View rootView;
        public ImageView iv_xianshi_img_1;
        public TextView tv_jingpai_num_1;
        public LinearLayout ll_jingpai;
        public TextView tv_xianshi_name_1;
        public TextView tv_xianshi_detail_1;
        public TextView tv_price_txt;
        public TextView tv_xianshi_price_1;
        public TextView tv_xianshi_time_h_1;
        public TextView tv_xianshi_time_m_1;
        public TextView tv_xianshi_time_s_1;
        public LinearLayout ll_time;
        public TextView tv_data;
        public TextView tv_pay_num_1;
        public TextView tv_shengyu_1;
        public RelativeLayout rl_bottom;
        public LinearLayout ll_goods_1;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_xianshi_img_1 = (ImageView) rootView.findViewById(R.id.iv_xianshi_img_1);
            this.tv_jingpai_num_1 = (TextView) rootView.findViewById(R.id.tv_jingpai_num_1);
            this.ll_jingpai = (LinearLayout) rootView.findViewById(R.id.ll_jingpai);
            this.tv_xianshi_name_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_name_1);
            this.tv_xianshi_detail_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_detail_1);
            this.tv_price_txt = (TextView) rootView.findViewById(R.id.tv_price_txt);
            this.tv_xianshi_price_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_price_1);
            this.tv_xianshi_time_h_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_time_h_1);
            this.tv_xianshi_time_m_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_time_m_1);
            this.tv_xianshi_time_s_1 = (TextView) rootView.findViewById(R.id.tv_xianshi_time_s_1);
            this.ll_time = (LinearLayout) rootView.findViewById(R.id.ll_time);
            this.tv_data = (TextView) rootView.findViewById(R.id.tv_data);
            this.tv_pay_num_1 = (TextView) rootView.findViewById(R.id.tv_pay_num_1);
            this.tv_shengyu_1 = (TextView) rootView.findViewById(R.id.tv_shengyu_1);
            this.rl_bottom = (RelativeLayout) rootView.findViewById(R.id.rl_bottom);
            this.ll_goods_1 = (LinearLayout) rootView.findViewById(R.id.ll_goods_1);
        }

    }
}
