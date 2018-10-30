package com.liuge.TMShop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.liuge.TMShop.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiang on 2018/3/13.
 */

public class AddimgAdapter extends BaseAdapter {
    Context mContext;
    List<String> path;
    delListener mdelListener;
    View.OnClickListener listener;

    public interface delListener {
        public void onDelListener(int position);
    }

    public void setMdelListener(delListener mdelListener) {
        this.mdelListener = mdelListener;
    }

    public AddimgAdapter(Context mContext, View.OnClickListener listener) {
        this.mContext = mContext;
        this.listener=listener;
    }

    public void setPath(List<String> path) {
        this.path = path;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return path == null ? 1 : (path.size() + 1);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_add_pic_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        if (path != null) {
            if (position < path.size()) {
                Glide.with(mContext).load(path.get(position)).into(vh.iv_pic);
                vh.ll_del.setVisibility(View.VISIBLE);
                if (mdelListener != null) {
                    vh.ll_del.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mdelListener.onDelListener(position);
                        }
                    });
                }
            } else {
                vh.iv_pic.setImageDrawable(null);
                vh.ll_del.setVisibility(View.GONE);
            }
            if(listener!=null){
                vh.rl_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setTag(position);
                        listener.onClick(v);
                    }
                });
            }
        }

        return view;
    }

    class ViewHolder {
        public View rootView;
        public ImageView iv_pic;
        public LinearLayout ll_del;
        public RelativeLayout rl_add;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_pic = (ImageView) rootView.findViewById(R.id.iv_pic);
            this.ll_del = (LinearLayout) rootView.findViewById(R.id.ll_del);
            this.rl_add = (RelativeLayout) rootView.findViewById(R.id.rl_add);
        }

    }
}
