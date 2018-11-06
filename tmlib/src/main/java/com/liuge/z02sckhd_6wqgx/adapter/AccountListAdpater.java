package com.liuge.z02sckhd_6wqgx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.AccountEntity;

/**
 * Created by jiang on 2018/10/28.
 */

public class AccountListAdpater extends BaseAdapter {
    Context mContext;

    public AccountListAdpater(Context mContext) {
        this.mContext = mContext;
    }

    AccountEntity account;

    public void setAccount(AccountEntity account) {
        this.account = account;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return account == null ? 0 : (account.getData()==null?0:account.getData().getResult().size());
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
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.z02sckhd_6wqgx_item_account_layout, null);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        switch(Integer.valueOf(account.getData().getResult().get(position).getType())){
            case 1:
                vh.tv_type.setText("支付宝");
            break;
            case 2:
                vh.tv_type.setText("微信");
            break;
            case 3:
                vh.tv_type.setText("银联");
            break;
        }
        vh.tv_account.setText(account.getData().getResult().get(position).getNumber());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView tv_type;
        public TextView tv_account;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tv_type = (TextView) rootView.findViewById(R.id.tv_type);
            this.tv_account = (TextView) rootView.findViewById(R.id.tv_account);
        }

    }
}
