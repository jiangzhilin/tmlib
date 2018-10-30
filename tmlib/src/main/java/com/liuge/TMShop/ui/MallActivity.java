package com.liuge.TMShop.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.IndexHotGoodsAdapter;
import com.liuge.TMShop.adapter.MallTuiJianAdapter;
import com.liuge.TMShop.adapter.TuiJianAdapter;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.entity.GoodsListEntity;
import com.liuge.TMShop.entity.MallDetailsEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.GlideImageLoader;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroGridView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

public class MallActivity extends BaseActivity {
    private static final String TAG = "MallActivity";
    String sid;
    private LinearLayout ll_bar;
    private ImageView iv_head;
    private ImageView iv_head_img;
    private TextView tv_nickname;
    private TextView to_collect;
    private TabLayout tab;
    private Banner banner;
    private NoScroGridView gv_goods;
    private RadioButton rb_xinpin;
    private LinearLayout ll_line_1;
    private LinearLayout ll_xinpin;
    private RadioButton rb_xinpin_2;
    private LinearLayout ll_line_2;
    private LinearLayout ll_rexiao;
    private NoScroGridView new_goods;
    private SmoothRefreshLayout refreshLayout;
    private ScrollView scrollView;

    MallDetailsEntity base;

    private String cat_id=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("店铺");
        sid = getIntent().getStringExtra("sid");
        initView();
        refreshLayout.setMode(SmoothRefreshLayout.MODE_REFRESH);
        refreshLayout.setHeaderView(new ClassicHeader(this));
//        refreshLayout.setFooterView(new ClassicFooter(this));
        refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(refreshLayout.isRefreshing()){
                    getMallInfo();
                }
            }
        });

        Log.d(TAG, "initData: y轴数据："+ll_xinpin.getScrollY());

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                cat_id=base.getData().getCategory().get(tab.getPosition()).getId();
                getClaGoods(0);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        int[] location = new int[2];
                        ll_xinpin.getLocationOnScreen(location);
                        int x = location[0];
                        int y = location[1];
                        scrollView.smoothScrollTo(0,  y-dip2px(mContext,65));
                    }
                });
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ll_xinpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_xinpin.setChecked(true);
                ll_line_1.setVisibility(View.VISIBLE);
                rb_xinpin_2.setChecked(false);
                ll_line_2.setVisibility(View.INVISIBLE);

                getClaGoods(0);
            }
        });
        ll_rexiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_xinpin.setChecked(false);
                ll_line_1.setVisibility(View.INVISIBLE);
                rb_xinpin_2.setChecked(true);
                ll_line_2.setVisibility(View.VISIBLE);

                getClaGoods(1);
            }
        });
        
        getMallInfo();

    }

    private void getMallInfo() {
        LoadDialog.show(mContext);
        new ApiManager().mallInfo(sid, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                base= JSONObject.parseObject(result,MallDetailsEntity.class);
                if(base.getStatus().equals("success")){
                    setData(base);
                }else{
                    NToast.shortToast(mContext,base.getMsg());
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
                if(refreshLayout.isRefreshing()){
                    refreshLayout.refreshComplete();
                }
            }
        });
    }

    private void setData(final MallDetailsEntity entity){
        tab.removeAllTabs();
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
        tab.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));

        List<String >mBanner=new ArrayList<>();
        for(int x=0;x<entity.getData().getCategory().size();x++){
            tab.addTab(tab.newTab().setText(entity.getData().getCategory().get(x).getName()),x);
        }

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(this).load(entity.getData().getSeller().getLogo()).apply(requestOptions).into(iv_head);
        tv_nickname.setText(entity.getData().getSeller().getShopname());

        to_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toCollect(entity.getData().getSeller().getId());
            }
        });

        mBanner.add(entity.getData().getSeller().getBanner());
        banner.setImages(mBanner)
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setDelayTime(4000)
                .start();

        cat_id=base.getData().getCategory().get(0).getId();

        Glide.with(mContext).load(R.mipmap.bg_tuijian).into(iv_head_img);
        MallTuiJianAdapter adapter4=new MallTuiJianAdapter(mContext,entity.getData().getIsbest());
        gv_goods.setAdapter(adapter4);
        gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                intent.putExtra("goods_id",entity.getData().getIsbest().get(i).getGoods_id());
                mContext.startActivity(intent);
            }
        });

        getClaGoods(0);

    }

    private void toCollect(String id){
        LoadDialog.show(mContext);
        new ApiManager().collect(id, "2", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void getClaGoods(int type){
        LoadDialog.show(mContext);
        new ApiManager().getGoodsList(cat_id, sid, null, null, null, type==0?null:"1", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                final GoodsListEntity goodsList=JSONObject.parseObject(result,GoodsListEntity.class);
                IndexHotGoodsAdapter adapter=new IndexHotGoodsAdapter(mContext);
                new_goods.setAdapter(adapter);
                adapter.setList(goodsList.getData().getResult());

                new_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                        intent.putExtra("goods_id",goodsList.getData().getResult().get(position).getGoods_id());
                        startActivity(intent);
                    }
                });
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
        ll_bar = (LinearLayout) findViewById(R.id.ll_bar);
        iv_head = (ImageView) findViewById(R.id.iv_head_user);
        iv_head_img = (ImageView) findViewById(R.id.iv_head);
        tv_nickname = (TextView) findViewById(R.id.tv_nickname);
        to_collect = (TextView) findViewById(R.id.to_collect);
        tab = (TabLayout) findViewById(R.id.tab);
        banner = (Banner) findViewById(R.id.banner);
        gv_goods = (NoScroGridView) findViewById(R.id.gv_goods);
        rb_xinpin = (RadioButton) findViewById(R.id.rb_xinpin);
        ll_line_1 = (LinearLayout) findViewById(R.id.ll_line_1);
        ll_xinpin = (LinearLayout) findViewById(R.id.ll_xinpin);
        rb_xinpin_2 = (RadioButton) findViewById(R.id.rb_xinpin_2);
        ll_line_2 = (LinearLayout) findViewById(R.id.ll_line_2);
        ll_rexiao = (LinearLayout) findViewById(R.id.ll_rexiao);
        new_goods = (NoScroGridView) findViewById(R.id.new_goods);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        refreshLayout = (SmoothRefreshLayout) findViewById(R.id.smoothRefreshLayout);
    }

    //将dp转换为px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
