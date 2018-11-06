package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class CommentReplyAdapter extends BaseAdapter {
    Context mContext;
    List<String>mList;

    public void setmList(List<String> mList) {
        this.mList = mList;
        this.notifyDataSetChanged();
    }

    public CommentReplyAdapter(Context mContext) {
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
        ViewHolder vh=null;
        if(view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_comment_reply_txt, null);
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
