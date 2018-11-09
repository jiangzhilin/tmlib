package com.liuge.z02sckhd_6wqgx.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.CommentAdapter;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.GoodsComentEntity;
import com.liuge.z02sckhd_6wqgx.entity.GoodsDetailsEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.utils.GlideImageLoader;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.AddBuyPop;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroGridView;
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

public class GoodsDetailsActivity extends FragmentActivity {
    private static final String TAG = "GoodsDetailsActivity";
    private Banner banner;
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
    private LinearLayout ll_title_bar;

    private List<String> mBannerData;

    private Context mContext;

    String id;
    private TextView tv_time;
    private LinearLayout ll_time;
    private WebView web;
    private NoScroGridView nogrid;
    private LinearLayout ll_jifen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this, R.color.transparent);
        StatusBarUtil.StatusBarLightMode(this);
        setContentView(R.layout.z02sckhd_6wqgx_activity_goods_details);
        initView();
        id = getIntent().getStringExtra("goods_id");
        mContext = this;
        initData();
    }

    protected void initData() {
//        setNoTitle();
        initView();

        //获得状态栏高度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(this));
        ll_title_bar.setLayoutParams(params);

        getGoods();
        getComment();

        ll_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
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
//        ll_into_mall.setOnClickListener(this);
        ll_into_kefu = (LinearLayout) findViewById(R.id.ll_into_kefu);
//        ll_into_kefu.setOnClickListener(this);
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
//        iv_collect.setOnClickListener(this);
        tv_collect = (TextView) findViewById(R.id.tv_collect);
//        tv_collect.setOnClickListener(this);
        ll_collect = (LinearLayout) findViewById(R.id.ll_collect);
//        ll_collect.setOnClickListener(this);
        tv_add_cart = (TextView) findViewById(R.id.tv_add_cart);
//        tv_add_cart.setOnClickListener(this);
        tv_to_buy = (TextView) findViewById(R.id.tv_to_buy);
//        tv_to_buy.setOnClickListener(this);
        ll_title_bar = (LinearLayout) findViewById(R.id.ll_title_bar);


        tv_time = (TextView) findViewById(R.id.tv_time);
        ll_time = (LinearLayout) findViewById(R.id.ll_time);
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
//        } else if (mDensity == 120) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
//        } else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        } else if (mDensity == DisplayMetrics.DENSITY_TV) {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
//        } else {
//            webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//        }
        /**
         * 用WebView显示图片，可使用这个参数 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：
         * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        nogrid = (NoScroGridView) findViewById(R.id.nogrid);
        ll_jifen = (LinearLayout) findViewById(R.id.ll_jifen);
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


    private void getGoods() {
        LoadDialog.show(this);
        new ApiManager().getGoodsDetails(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                final GoodsDetailsEntity entity = JSONObject.parseObject(result, GoodsDetailsEntity.class);
                if (entity.getStatus().equals("success")) {

                    mBannerData = new ArrayList<>();
                    List<String> imgs = new ArrayList<String>();
                    for (GoodsDetailsEntity.DataBean.ImagesBean img : entity.getData().get_images()) {
                        imgs.add(img.getThumb());
                        mBannerData.add(img.getThumb());
                    }
                    banner.setImages(mBannerData)
                            .setImageLoader(new GlideImageLoader())
                            .setIndicatorGravity(BannerConfig.RIGHT)
                            .setDelayTime(4000)
                            .start();
//                    GoodsDetailsImgAdapter imgAdapter = new GoodsDetailsImgAdapter(GoodsDetailsActivity.this, imgs);
//                    list_details.setAdapter(imgAdapter);

                    tv_goods_name.setText(entity.getData().getGoods_name());
                    tv_goods_detail.setText(entity.getData().getDescription());
                    tv_goods_detail.setVisibility(View.GONE);

                    tv_ac_num.setText("销量：" + entity.getData().getSales() + "件");
                    tv_shengyu_num.setText("剩余宝贝：" + entity.getData().getGoods_number() + "件");
                    tv_price_detail.setText("价格");
                    tv_price.setText(entity.getData().getPrice());
                    tv_yuanjia.setText("原价 " + entity.getData().getPrice());
                    tv_yuanjia.setVisibility(View.GONE);

                    tv_jifen_num.setText(entity.getData().getGive_integral());
                    tv_shiyongjifen_num.setText(entity.getData().getIntegral());

                    tv_add_cart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                addCart();
                            AddBuyPop.showDialog(GoodsDetailsActivity.this, entity, 0, tv_add_cart);
                        }
                    });

                    tv_to_buy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AddBuyPop.showDialog(GoodsDetailsActivity.this, entity, 1, tv_add_cart);
                        }
                    });

                    ll_into_mall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, MallActivity.class);
                            intent.putExtra("sid", entity.getData().getSid());
                            startActivity(intent);
                        }
                    });

                    ll_into_kefu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            TMApp.call(mContext, entity.getData().getPhone());
                        }
                    });

                    web.loadDataWithBaseURL(SixGridContext.HOST, entity.getData().getDescription(), "text/html", "UTF-8", null);

                    if(entity.getData().getAttr()!=null) {
                        nogrid.setVisibility(View.VISIBLE);
                        List<String>date=new ArrayList<String>();
                        for (int x = 0; x < entity.getData().getAttr().size(); x++) {
                            date.add(entity.getData().getAttr().get(x).getAttr_name()+":"+entity.getData().getAttr().get(x).getValue());
                        }
//                        SimpleAdapter simple = new SimpleAdapter(mContext,date,android.R.layout.simple_list_item_1)
                        ArrayAdapter adapter=new ArrayAdapter(mContext,R.layout.z02sckhd_6wqgx_item_attr_layout,date);
                        nogrid.setAdapter(adapter);
                    }else{
                        nogrid.setVisibility(View.GONE);
                    }
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
                LoadDialog.dismiss(GoodsDetailsActivity.this);
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
                CommentAdapter mAdapter = new CommentAdapter(GoodsDetailsActivity.this, entity.getData().getResult());
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
                LoadDialog.dismiss(GoodsDetailsActivity.this);
            }
        });
    }


}
