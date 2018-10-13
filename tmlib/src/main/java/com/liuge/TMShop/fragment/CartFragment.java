package com.liuge.TMShop.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.CartMallAdapter;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.entity.CartEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.utils.StatusBarUtil;
import com.liuge.TMShop.view.LoadDialog;

import org.xutils.common.Callback;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/8/21.
 */

public class CartFragment extends BaseFragment {
    /**
     * 预加载标志，默认值为false，设置为true，表示已经预加载完成，可以加载数据
     */
    private boolean isPrepared;

    private View view;
    private ViewHolder vh;

    /**
     * Fragment生命周期方法，此view可改为自定义的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        vh=new ViewHolder(view);

        //获得状态栏高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(getActivity()));
        vh.ll_bar.setLayoutParams(params);

        //TODO 此处初始化view中各个控件
        isPrepared = true;
        setlazyLoad();
        return view;
    }

    /**
     * 加载数据的方法，只要保证isPrepared和isVisible都为true的时候才往下执行开始加载数据
     */
    @Override
    protected void setlazyLoad() {
        super.setlazyLoad();
        if (!isPrepared || !isVisible) {
            return;
        }
        //TODO 此处填充view中各个控件的数据
        initView();
    }

    private void initView() {

        CartMallAdapter mAdapter=new CartMallAdapter(getActivity());
        vh.listView.setAdapter(mAdapter);

        getCart();
    }

    private void getCart(){
        LoadDialog.show(getActivity());
        new ApiManager().getCart(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                CartEntity base= JSONObject.parseObject(result,CartEntity.class);
                NToast.shortToast(getActivity(),base.getMsg()+"商品数量为："+base.getData().getGoods()==null?0:base.getData().getGoods().size());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(getActivity());
            }
        });
    }

    public class ViewHolder {
        public View rootView;
        public ListView listView;
        public CheckBox cb_all;
        public LinearLayout ll_to_pay;
        public LinearLayout ll_bar;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.listView = (ListView) rootView.findViewById(R.id.listView);
            this.cb_all = (CheckBox) rootView.findViewById(R.id.cb_all);
            this.ll_to_pay = (LinearLayout) rootView.findViewById(R.id.ll_to_pay);
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
        }

    }
}
