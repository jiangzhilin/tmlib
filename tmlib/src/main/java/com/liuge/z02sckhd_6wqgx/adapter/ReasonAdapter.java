package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;

import com.liuge.z02sckhd_6wqgx.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2018/10/29.
 */

public class ReasonAdapter extends BaseAdapter {
    Context mContext;

    public interface Choose{
        public void choose(List<String>list);
    }

    public ReasonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    Choose listener;

    public void setListener(Choose listener) {
        this.listener = listener;
    }

    List<String>choose=new ArrayList<>();

    List<String> reason;

    public void setReason(List<String> reason) {
        this.reason = reason;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return reason == null ? 0 : reason.size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_check_reason_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.cb.setText(reason.get(position));
        vh.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if(!choose.contains(reason.get(position))){
                        choose.add(reason.get(position));
                    }
                }else{
                    if(choose.contains(reason.get(position))){
                        choose.remove(reason.get(position));
                    }
                }
                if(listener!=null){
                    listener.choose(choose);
                }
            }
        });
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public AppCompatCheckBox cb;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.cb = (AppCompatCheckBox) rootView.findViewById(R.id.cb);
        }

    }
}
