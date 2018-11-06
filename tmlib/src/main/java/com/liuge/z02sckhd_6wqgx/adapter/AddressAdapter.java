package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.AddressEntity;

/**
 * Created by Administrator on 2018/9/27.
 */

public class AddressAdapter extends BaseAdapter {

    Context mContext;
    AddressEntity add;
    del del;
    beDef beDef;
    edit edit;

    public void setBeDef(AddressAdapter.beDef beDef) {
        this.beDef = beDef;
    }

    public void setEdit(AddressAdapter.edit edit) {
        this.edit = edit;
    }

    public void setDel(AddressAdapter.del del) {
        this.del = del;
    }

    public void setAdd(AddressEntity add) {
        this.add = add;
        this.notifyDataSetChanged();
    }

    public AddressAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public interface del{
        public void del(int position);
    }

    public interface beDef{
        public void def(int position);
    }

    public interface edit{
        public void edit(int position);
    }

    @Override
    public int getCount() {
        return add==null?0:add.getData().size();
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
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_address_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        if(add.getData().get(i).getIs_default().equals("1")){
            vh.tv_moren.setVisibility(View.VISIBLE);
        }else{
            vh.tv_moren.setVisibility(View.INVISIBLE);
        }
        vh.tv_name.setText(add.getData().get(i).getConsignee());
        vh.tv_phone.setText(add.getData().get(i).getMobile());
        vh.tv_add.setText(add.getData().get(i).getAddress()+add.getData().get(i).getAddress_name());

        if(del!=null){
            vh.tv_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    del.del(i);
                }
            });
        }

        if(beDef!=null){
            vh.tv_be_moren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    beDef.def(i);
                }
            });
        }

        if(edit!=null){
            vh.tv_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    edit.edit(i);
                }
            });
        }

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_moren;
        public TextView tv_name;
        public TextView tv_phone;
        public TextView tv_add;
        public TextView tv_be_moren;
        public TextView tv_edit;
        public TextView tv_del;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_moren = (TextView) rootView.findViewById(R.id.tv_moren);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_phone = (TextView) rootView.findViewById(R.id.tv_phone);
            this.tv_add = (TextView) rootView.findViewById(R.id.tv_add);
            this.tv_be_moren = (TextView) rootView.findViewById(R.id.tv_be_moren);
            this.tv_edit = (TextView) rootView.findViewById(R.id.tv_edit);
            this.tv_del = (TextView) rootView.findViewById(R.id.tv_del);
        }

    }



}
