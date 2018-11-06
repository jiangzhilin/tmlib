package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.GoodsComentEntity;
import com.liuge.z02sckhd_6wqgx.view.NoScroGridView;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CommentAdapter extends BaseAdapter {
    Context mContext;

    List<GoodsComentEntity.DataBean.ResultBean>mList;

    public CommentAdapter(Context mContext, List<GoodsComentEntity.DataBean.ResultBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public CommentAdapter(Context mContext) {
        this.mContext = mContext;
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder vh= null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_comment_layout, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else{
            vh=(ViewHolder) view.getTag();
        }

        CommentImgAdapter img=new CommentImgAdapter(mContext,mList.get(i).getImages());
        vh.gvImg.setAdapter(img);

        vh.tvUserName.setText(mList.get(i).getMember_name());
        vh.tvDate.setText(mList.get(i).getAdd_time());
        vh.tvMsg.setText(mList.get(i).getComment());

        CommentReplyAdapter reply=new CommentReplyAdapter(mContext);
        vh.listReply.setAdapter(reply);

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(mContext).load(mList.get(i).getHead_pic()).apply(requestOptions).into(vh.ivHead);

        return view;
    }

    public class ViewHolder {
        public View rootView;
        public ImageView ivHead;
        public TextView tvUserName;
        public TextView tvDate;
        public TextView tvMsg;
        public NoScroGridView gvImg;
        public NoScroListView listReply;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ivHead = (ImageView) rootView.findViewById(R.id.iv_head);
            this.tvUserName = (TextView) rootView.findViewById(R.id.tv_user_name);
            this.tvDate = (TextView) rootView.findViewById(R.id.tv_date);
            this.tvMsg = (TextView) rootView.findViewById(R.id.tv_msg);
            this.gvImg = (NoScroGridView) rootView.findViewById(R.id.gv_img);
            this.listReply = (NoScroListView) rootView.findViewById(R.id.list_reply);
        }

    }
}
