package com.sobey.tmgc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sobey.tmgc.R;
import com.sobey.tmgc.bean.TBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bin on 2017/12/27.
 */

public class TAdapter extends RecyclerView.Adapter<TAdapter.TViewHolder> {

    private Context mContext;
    private List<TBean> tBeen;

    public TAdapter(Context context, List<TBean> tBeen) {
        this.mContext = context;
        this.tBeen = tBeen;
    }

    @Override
    public TAdapter.TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TViewHolder tViewHolder = new TViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.t_item, parent,
                false));
        return tViewHolder;

    }

    @Override
    public void onBindViewHolder(TAdapter.TViewHolder holder, int position) {
        TBean tBean = tBeen.get(position);
        holder.nameTv.setText(tBean.getName());
    }

    @Override
    public int getItemCount() {
        return tBeen.size();
    }

    class TViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTv;

        public TViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
        }
    }
}
