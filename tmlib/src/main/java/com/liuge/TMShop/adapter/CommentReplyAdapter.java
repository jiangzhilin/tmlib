package com.liuge.TMShop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.TMShop.R;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CommentReplyAdapter extends BaseAdapter {
    Context mContext;

    public CommentReplyAdapter(Context mContext) {
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
        ViewHolder vh=null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_comment_reply_txt, null);
            vh=new ViewHolder(view);
            view.setTag(vh);
        }else {
            vh= (ViewHolder) view.getTag();
        }

        return view;
    }

    public class ViewHolder {
        public View rootView;
        public TextView tv_context;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_context = (TextView) rootView.findViewById(R.id.tv_context);
        }

    }
}
