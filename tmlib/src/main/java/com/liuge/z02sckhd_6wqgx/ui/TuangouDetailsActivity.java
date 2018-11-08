package com.liuge.z02sckhd_6wqgx.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.CommentAdapter;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.GoodsComentEntity;
import com.liuge.z02sckhd_6wqgx.entity.GoodsDetailsEntity;
import com.liuge.z02sckhd_6wqgx.entity.TuangouEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.utils.GlideImageLoader;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.AddBuyGroupPop;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tenma.ventures.share.bean.TMTextShare;
import com.tenma.ventures.share.util.TMShareUtil;
import com.tenma.ventures.tools.TMApp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */

public class TuangouDetailsActivity extends FragmentActivity {
    private static final String TAG = "TuangouDetailsActivity";

    private List<String> mBannerData;

    public String id;
    private Banner banner;
    private LinearLayout ll_title_bar;
    private ImageView iv_back;
    private ImageView iv_share;
    private TextView tv_goods_name;
    private TextView tv_goods_detail;
    private TextView tv_ac_num;
    private TextView tv_shengyu_num;
    private TextView tv_price_detail;
    private TextView tv_price;
    private TextView tv_yuanjia;
    private TextView tv_xianshi_time_h_1;
    private TextView tv_xianshi_time_m_1;
    private TextView tv_xianshi_time_s_1;
    private TextView tv_jifen_num;
    private TextView tv_shiyongjifen_num;
    private TextView tv_show_all;
    private ImageView iv_all;
    private NoScroListView list_pinglun;
    private NoScroListView list_details;
    private LinearLayout ll_into_mall;
    private LinearLayout ll_into_kefu;
    private ImageView iv_collect;
    private TextView tv_collect;
    private LinearLayout ll_collect;
    private TextView tv_add_cart;
    private TextView tv_to_buy;
    private TextView tv_peo;

    Context mContext;
    private TextView tv_time;

    public static TuangouDetailsActivity instance;
    private WebView web;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.transparent);
        StatusBarUtil.StatusBarLightMode(this);
        setContentView(R.layout.z02sckhd_6wqgx_activity_tuangou_details);
        mContext = this;
        instance = this;
        initView();
        id = getIntent().getStringExtra("id");
        initData();
    }

    protected void initData() {

        //获得状态栏高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(this));
        ll_title_bar.setLayoutParams(params);

        getGoods();
        getComment();


        tv_to_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toTuangou();
            }
        });

        ll_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCollect(id);
            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMTextShare share = new TMTextShare();
                share.setContent("分享信息");
                TMShareUtil.getInstance(mContext).shareText(share);
            }
        });

        tv_to_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBuyGroupPop.showDialog(TuangouDetailsActivity.this, tv_to_buy);
            }
        });

    }

    private void getGoods() {
        LoadDialog.show(this);
        new ApiManager().getGoodsTuangou(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
//                GoodsDetailsEntity entity = JSONObject.parseObject(result, GoodsDetailsEntity.class);
                final TuangouEntity entity = JSONObject.parseObject(result, TuangouEntity.class);
                if (entity.getStatus().equals("success")) {

                    mBannerData = new ArrayList<>();

                    for (TuangouEntity.DataBean.GoodsBean.ImagesBean img : entity.getData().getGoods().get_images()) {
//                        imgs.add(img.getThumb());
                        mBannerData.add(img.getThumb());
                    }
                    banner.setImages(mBannerData)
                            .setImageLoader(new GlideImageLoader())
                            .setIndicatorGravity(BannerConfig.RIGHT)
                            .setDelayTime(4000)
                            .start();

                    tv_goods_name.setText(entity.getData().getGoods().getGoods_name());
                    tv_goods_detail.setText(entity.getData().getGoods().getDescription());
                    tv_goods_detail.setVisibility(View.GONE);
                    tv_ac_num.setText("团购人数：" + entity.getData().getStore().getNum() + "人");
                    tv_shengyu_num.setText("满团人数：" + entity.getData().getStore().getMaxprice() + "人");
                    tv_shengyu_num.setVisibility(View.GONE);
                    tv_price.setText(entity.getData().getStore().getPrice());
                    tv_yuanjia.setText("原价 " + entity.getData().getGoods().getPrice());
                    tv_add_cart.setText(entity.getData().getStore().getPrice());
                    tv_peo.setText("已有" + entity.getData().getOnum() + "人参团");
                    tv_time.setText("结束时间：" + entity.getData().getStore().getEnd_time());

                    ll_into_kefu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TMApp.call(mContext, entity.getData().getPhone());
                        }
                    });

                    ll_into_mall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(mContext,MallActivity.class);
                            intent.putExtra("sid",entity.getData().getGoods().getSid());
                            startActivity(intent);
                        }
                    });

                    getDetails(entity.getData().getGoods().getGoods_id());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(TuangouDetailsActivity.this);
            }
        });
    }

    private void toCollect(String id) {
        LoadDialog.show(mContext);
        new ApiManager().collect(id, "1", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base = JSONObject.parseObject(result, BaseEntity.class);
                if (base.getStatus().equals("success")) {
                    NToast.shortToast(mContext, base.getMsg());
                } else {
                    NToast.shortToast(mContext, base.getMsg());
                }
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

    private void toTuangou() {
        LoadDialog.show(mContext);
        new ApiManager().toTuangou(id, new Callback.CommonCallback<String>() {
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

    private void getComment() {
        LoadDialog.show(this);
        new ApiManager().getGoodsCom(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                GoodsComentEntity entity = JSONObject.parseObject(result, GoodsComentEntity.class);
                CommentAdapter mAdapter = new CommentAdapter(TuangouDetailsActivity.this, entity.getData().getResult());
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
                LoadDialog.dismiss(TuangouDetailsActivity.this);
            }
        });
    }

    private void getDetails(String ids) {
        LoadDialog.show(mContext);
        new ApiManager().getGoodsDetails(ids, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "详情onSuccess: " + result);
                GoodsDetailsEntity details = JSONObject.parseObject(result, GoodsDetailsEntity.class);
                if (details.getStatus().equals("success")) {
                    web.loadDataWithBaseURL(SixGridContext.HOST, details.getData().getDescription(), "text/html", "UTF-8", null);
                }
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
        tv_ac_num = (TextView) findViewById(R.id.tv_ac_num);
        tv_shengyu_num = (TextView) findViewById(R.id.tv_shengyu_num);
        tv_price_detail = (TextView) findViewById(R.id.tv_price_detail);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_yuanjia = (TextView) findViewById(R.id.tv_yuanjia);
        tv_xianshi_time_h_1 = (TextView) findViewById(R.id.tv_xianshi_time_h_1);
        tv_xianshi_time_m_1 = (TextView) findViewById(R.id.tv_xianshi_time_m_1);
        tv_xianshi_time_s_1 = (TextView) findViewById(R.id.tv_xianshi_time_s_1);
        tv_jifen_num = (TextView) findViewById(R.id.tv_jifen_num);
        tv_shiyongjifen_num = (TextView) findViewById(R.id.tv_shiyongjifen_num);
        tv_show_all = (TextView) findViewById(R.id.tv_show_all);
        iv_all = (ImageView) findViewById(R.id.iv_all);
        list_pinglun = (NoScroListView) findViewById(R.id.list_pinglun);
        list_details = (NoScroListView) findViewById(R.id.list_details);
        ll_into_mall = (LinearLayout) findViewById(R.id.ll_into_mall);
        ll_into_kefu = (LinearLayout) findViewById(R.id.ll_into_kefu);
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
        tv_collect = (TextView) findViewById(R.id.tv_collect);
        ll_collect = (LinearLayout) findViewById(R.id.ll_collect);
        tv_add_cart = (TextView) findViewById(R.id.tv_add_cart);
        tv_to_buy = (TextView) findViewById(R.id.tv_to_buy);
        tv_peo = (TextView) findViewById(R.id.tv_peo);
        tv_time = (TextView) findViewById(R.id.tv_time);
        web = (WebView) findViewById(R.id.web);

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // User settings

        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);//关键点
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setBuiltInZoomControls(true); // 设置显示缩放按钮
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setTextSize(WebSettings.TextSize.LARGER);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int mDensity = metrics.densityDpi;
//        Log.d("maomao", "densityDpi = " + mDensity);
//        if (mDensity == 240) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        } else if (mDensity == 160) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//        } else if(mDensity == 120) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
//        }else if(mDensity == DisplayMetrics.DENSITY_XHIGH){
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        }else if (mDensity == DisplayMetrics.DENSITY_TV){
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        }else{
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//        }
        /**
         * 用WebView显示图片，可使用这个参数 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：
         * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }
}
