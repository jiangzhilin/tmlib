package com.liuge.TMShop.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.CommentAdapter;
import com.liuge.TMShop.adapter.GoodsDetailsImgAdapter;
import com.liuge.TMShop.entity.GoodsComentEntity;
import com.liuge.TMShop.entity.GoodsDetailsEntity;
import com.liuge.TMShop.entity.MiaoshaEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.GlideImageLoader;
import com.liuge.TMShop.utils.StatusBarUtil;
import com.liuge.TMShop.view.AddBuyMiaoshaPop;
import com.liuge.TMShop.view.AddBuyPop;
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

public class GoodsMiaoshaActivity extends FragmentActivity {
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.transparent);
        StatusBarUtil.StatusBarLightMode(this);
        setContentView(R.layout.activity_goods_details);
        id=getIntent().getStringExtra("id");
        mContext=this;
        initView();
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
    }

    private void getGoods(){
        LoadDialog.show(this);
        new ApiManager().getMiaoshaDetails(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                final MiaoshaEntity entity= JSONObject.parseObject(result,MiaoshaEntity.class);
                if(entity.getStatus().equals("success")){

                    mBannerData = new ArrayList<>();
                    List<String>imgs=new ArrayList<String>();
                    for(MiaoshaEntity.DataBean.GoodsBean.ImagesBean img:entity.getData().getGoods().get_images()){
                        imgs.add(img.getThumb());
                        mBannerData.add(img.getThumb());
                    }
                    banner.setImages(mBannerData)
                            .setImageLoader(new GlideImageLoader())
                            .setIndicatorGravity(BannerConfig.RIGHT)
                            .setDelayTime(4000)
                            .start();
                    GoodsDetailsImgAdapter imgAdapter = new GoodsDetailsImgAdapter(GoodsMiaoshaActivity.this, imgs);
                    list_details.setAdapter(imgAdapter);

                    tv_goods_name.setText(entity.getData().getGoods().getGoods_name());
                    tv_goods_detail.setText(entity.getData().getGoods().getDescription());
                    tv_ac_num.setText("秒杀数量："+entity.getData().getGoods().getClick_count()+"件");
                    tv_shengyu_num.setText("剩余宝贝："+entity.getData().getGoods().getGoods_number()+"件");
                    tv_price.setText(entity.getData().getGoods().getPromote_price());
                    tv_yuanjia.setText("原价 "+entity.getData().getGoods().getMarket_price());

                    tv_add_cart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                addCart();
                            AddBuyMiaoshaPop.showDialog(GoodsMiaoshaActivity.this,entity,0,tv_add_cart);
                        }
                    });

                    tv_to_buy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AddBuyMiaoshaPop.showDialog(GoodsMiaoshaActivity.this,entity,1,tv_add_cart);
                        }
                    });

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
                LoadDialog.dismiss(GoodsMiaoshaActivity.this);
            }
        });
    }
    private void getComment(){
        LoadDialog.show(this);
        new ApiManager().getGoodsCom(id, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: "+result);
                GoodsComentEntity entity=JSONObject.parseObject(result,GoodsComentEntity.class);
                CommentAdapter mAdapter = new CommentAdapter(GoodsMiaoshaActivity.this,entity.getData().getResult());
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
                LoadDialog.dismiss(GoodsMiaoshaActivity.this);
            }
        });
    }


}
