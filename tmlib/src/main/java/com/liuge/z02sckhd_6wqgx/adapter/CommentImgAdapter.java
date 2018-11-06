package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.GoodsComentEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CommentImgAdapter extends BaseAdapter {
    Context mContext;
    List<GoodsComentEntity.DataBean.imgBean> img;

    public CommentImgAdapter(Context mContext, List<GoodsComentEntity.DataBean.imgBean> img) {
        this.mContext = mContext;
        this.img = img;
    }

    public CommentImgAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return img==null?0:img.size();
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

        ViewHolder vh=null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_comment_img, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh=(ViewHolder) view.getTag();
        }
        Glide.with(mContext).load(img.get(i).getPath()).into(vh.iv_img);
        return view;
    }

    public  class ViewHolder {
        public View rootView;
        public ImageView iv_img;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
        }

    }
}
