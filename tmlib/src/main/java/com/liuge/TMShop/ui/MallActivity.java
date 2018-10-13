package com.liuge.TMShop.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.entity.BaseEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.utils.NToast;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroGridView;
import com.youth.banner.Banner;

import org.xutils.common.Callback;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

public class MallActivity extends BaseActivity {
    private static final String TAG = "MallActivity";
    String sid;
    private LinearLayout ll_bar;
    private ImageView iv_head;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        sid = getIntent().getStringExtra("sid");
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("店铺");
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
        getMallInfo();
    }

    private void getMallInfo() {
        LoadDialog.show(mContext);
        new ApiManager().mallInfo(sid, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
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
                LoadDialog.dismiss(mContext);
                if(refreshLayout.isRefreshing()){
                    refreshLayout.refreshComplete();
                }
            }
        });
    }

    private void initView() {
        ll_bar = (LinearLayout) findViewById(R.id.ll_bar);
        iv_head = (ImageView) findViewById(R.id.iv_head);
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
        refreshLayout = (SmoothRefreshLayout) findViewById(R.id.smoothRefreshLayout);
    }
}
