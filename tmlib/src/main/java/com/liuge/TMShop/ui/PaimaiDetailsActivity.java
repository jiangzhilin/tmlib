package com.liuge.TMShop.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.CommentAdapter;
import com.liuge.TMShop.adapter.GoodsDetailsImgAdapter;
import com.liuge.TMShop.adapter.JingpaiAdapter;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.entity.GoodsComentEntity;
import com.liuge.TMShop.entity.PaimaiDetailsEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.GlideImageLoader;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.utils.StatusBarUtil;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroListView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class PaimaiDetailsActivity extends FragmentActivity {
    private static final String TAG = "PaimaiDetailsActivity";
    private List<String> mBannerData;
    private Banner banner;
    private LinearLayout ll_title_bar;
    private ImageView iv_back;
    private ImageView iv_share;
    private TextView tv_goods_name;
    private TextView tv_goods_detail;
    private TextView tv_tips;
    private LinearLayout ll_tips;
    private TextView tv_qipaijia;
    private TextView tv_jiajia;
    private TextView tv_xianjia;
    private TextView tv_price_detail;
    private TextView tv_price;
    private TextView tv_end_paimai;
    private TextView tv_peo_num;
    private NoScroListView list_jingpai_jilu;
    private TextView tv_show_all;
    private ImageView iv_all;
    private NoScroListView list_pinglun;
    private NoScroListView list_details;
    private TextView tv_msg;
    private TextView tv_to_buy;

    String id;

    Context mContext;

    PaimaiDetailsEntity entity;
    private EditText tv_paimai;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.transparent);
        StatusBarUtil.StatusBarLightMode(this);
        setContentView(R.layout.activity_paimai_details);

        id = getIntent().getStringExtra("id");
        mContext = this;
        initData();
    }

    protected void initData() {
//        setNoTitle();
        initView();

        //获得状态栏高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(this));
        ll_title_bar.setLayoutParams(params);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getDetails();
        getComment();
        tv_to_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPaimai(tv_paimai.getText().toString());
            }
        });
    }

    private void getDetails() {
        LoadDialog.show(mContext);
        new ApiManager().getPaiMaiDetails(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                entity = JSONObject.parseObject(result, PaimaiDetailsEntity.class);
                mBannerData = new ArrayList<>();
                List<String> img = new ArrayList<>();
                for (int x = 0; x < entity.getData().getGoods().get_images().size(); x++) {
                    mBannerData.add(entity.getData().getGoods().get_images().get(x).getThumb());
                    img.add(entity.getData().getGoods().get_images().get(x).getThumb());
                }

                banner.setImages(mBannerData)
                        .setImageLoader(new GlideImageLoader())
                        .setIndicatorGravity(BannerConfig.RIGHT)
                        .setDelayTime(4000)
                        .start();

                GoodsDetailsImgAdapter imgAdapter = new GoodsDetailsImgAdapter(mContext, img);
                list_details.setAdapter(imgAdapter);

                JingpaiAdapter jinpai = new JingpaiAdapter(mContext, entity.getData().getAuctionlog());
                list_jingpai_jilu.setAdapter(jinpai);

                tv_goods_name.setText(entity.getData().getGoods().getGoods_name());
                tv_goods_detail.setText(entity.getData().getGoods().getDescription());
                tv_tips.setText(entity.getData().getGoods().getCate_name());
                tv_price.setText(entity.getData().getGoods().getPrice());
                tv_peo_num.setText(entity.getData().getAuctionlog().size() + "人");
                tv_msg.setText(entity.getData().getGoods().getIntegral());
                tv_qipaijia.setText("起拍价" + entity.getData().getGoods().getPromote_price());
                tv_jiajia.setText("加价" + entity.getData().getGoods().getCost_price());
                tv_xianjia.setText("限价" + entity.getData().getGoods().getMarket_price());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    private void getComment() {
        LoadDialog.show(this);
        new ApiManager().getGoodsCom(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                GoodsComentEntity entity = JSONObject.parseObject(result, GoodsComentEntity.class);
                CommentAdapter mAdapter = new CommentAdapter(mContext, entity.getData().getResult());
                list_pinglun.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    private void toPaimai(String monney) {
        LoadDialog.show(mContext);
        new ApiManager().toPaimai(id,monney, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base = JSONObject.parseObject(result, BaseEntity.class);
                NToast.shortToast(mContext, base.getMsg());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        ll_title_bar = (LinearLayout) findViewById(R.id.ll_title_bar);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        tv_goods_name = (TextView) findViewById(R.id.tv_goods_name);
        tv_goods_detail = (TextView) findViewById(R.id.tv_goods_detail);
        tv_tips = (TextView) findViewById(R.id.tv_tips);
        ll_tips = (LinearLayout) findViewById(R.id.ll_tips);
        tv_qipaijia = (TextView) findViewById(R.id.tv_qipaijia);
        tv_jiajia = (TextView) findViewById(R.id.tv_jiajia);
        tv_xianjia = (TextView) findViewById(R.id.tv_xianjia);
        tv_price_detail = (TextView) findViewById(R.id.tv_price_detail);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_end_paimai = (TextView) findViewById(R.id.tv_end_paimai);
        tv_peo_num = (TextView) findViewById(R.id.tv_peo_num);
        list_jingpai_jilu = (NoScroListView) findViewById(R.id.list_jingpai_jilu);
        tv_show_all = (TextView) findViewById(R.id.tv_show_all);
        iv_all = (ImageView) findViewById(R.id.iv_all);
        list_pinglun = (NoScroListView) findViewById(R.id.list_pinglun);
        list_details = (NoScroListView) findViewById(R.id.list_details);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_to_buy = (TextView) findViewById(R.id.tv_to_buy);
        tv_paimai = (EditText) findViewById(R.id.tv_paimai);
    }
}
