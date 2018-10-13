package com.liuge.TMShop.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.ClassicAdapter;
import com.liuge.TMShop.adapter.IndexHotGoodsAdapter;
import com.liuge.TMShop.entity.GoodsClassEntity;
import com.liuge.TMShop.entity.GoodsListEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.view.LoadDialog;
import com.liuge.TMShop.view.NoScroGridView;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

import static android.content.ContentValues.TAG;

public class GoodsClassActivity extends BaseActivity {

    private GridView gv_child;
    private RadioButton rb_xinpin;
    private LinearLayout ll_line_1;
    private LinearLayout ll_xiaoliang;
    private RadioButton rb_xinpin_2;
    private LinearLayout ll_line_2;
    private LinearLayout ll_jiage;
    private NoScroGridView gv_Goods;
    private SmoothRefreshLayout refreshLayout;

    List<GoodsListEntity.DataBean.ResultBean>mList=new ArrayList<>();

    int p=1;

    String sort="s.sales";

    IndexHotGoodsAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_class);
        initView();
    }

    String pid = null;

    @Override
    protected void initData() {
        setTitle(getIntent().getStringExtra("title"));
        pid = getIntent().getStringExtra("pid");
        setBack();
        initView();
    }

    private void initView() {
        gv_child = (GridView) findViewById(R.id.gv_child);
        getGoosClass();
        rb_xinpin = (RadioButton) findViewById(R.id.rb_xinpin);
        ll_line_1 = (LinearLayout) findViewById(R.id.ll_line_1);
        ll_xiaoliang = (LinearLayout) findViewById(R.id.ll_xiaoliang);
        rb_xinpin_2 = (RadioButton) findViewById(R.id.rb_xinpin_2);
        ll_line_2 = (LinearLayout) findViewById(R.id.ll_line_2);
        ll_jiage = (LinearLayout) findViewById(R.id.ll_jiage);
        gv_Goods = (NoScroGridView) findViewById(R.id.gv_Goods);
        refreshLayout = (SmoothRefreshLayout) findViewById(R.id.smoothRefreshLayout);

        madapter = new IndexHotGoodsAdapter(mContext);
        gv_Goods.setAdapter(madapter);

        ll_xiaoliang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_xinpin.setChecked(true);
                ll_line_1.setVisibility(View.VISIBLE);
                rb_xinpin_2.setChecked(false);
                ll_line_2.setVisibility(View.INVISIBLE);
                sort="s.sales";
                getGoosList();
            }
        });
        ll_jiage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb_xinpin.setChecked(false);
                ll_line_1.setVisibility(View.INVISIBLE);
                rb_xinpin_2.setChecked(true);
                ll_line_2.setVisibility(View.VISIBLE);
                sort="s.price";
                getGoosList();
            }
        });

        refreshLayout.setMode(SmoothRefreshLayout.MODE_BOTH);
        refreshLayout.setHeaderView(new ClassicHeader(this));
        refreshLayout.setFooterView(new ClassicFooter(this));
        refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(refreshLayout.isRefreshing()){
                    p=1;
                    getGoosList();
                }
                if(refreshLayout.isLoadingMore()){
                    p++;
                    getGoosList();
                }
            }
        });

        gv_Goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                intent.putExtra("goods_id",mList.get(i).getGoods_id());
                mContext.startActivity(intent);
            }
        });

    }

    private void getGoosClass() {
        LoadDialog.show(mContext);
        new ApiManager().getGoodsClass(pid, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                GoodsClassEntity goods = JSONObject.parseObject(result, GoodsClassEntity.class);
                changeGridView(goods);
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

    private void getGoosList() {
        LoadDialog.show(mContext);
        new ApiManager().getGoodsList(pid,null,sort,null,""+p,null, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d(TAG, "onSuccess: " + result);
                GoodsListEntity entity=JSONObject.parseObject(result,GoodsListEntity.class);
                if(p==1){
                    mList.clear();
                    mList.addAll(entity.getData().getResult());
                }else{
                    mList.addAll(entity.getData().getResult());
                }
                madapter.setList(mList);
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
                if(refreshLayout.isLoadingMore()){
                    refreshLayout.refreshComplete();
                }
            }
        });
    }

    /**
     * 将GridView改成单行横向布局
     */
    private void changeGridView(final GoodsClassEntity goods) {
        // item宽度
        int itemWidth = dip2px(this, 60);
        // item之间的间隔
        int itemPaddingH = dip2px(this, 1);
        int size = goods.getData().size();
        // 计算GridView宽度
        int gridviewWidth = size * (itemWidth + itemPaddingH);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.MATCH_PARENT);
        gv_child.setLayoutParams(params);
        gv_child.setColumnWidth(itemWidth);
        gv_child.setHorizontalSpacing(itemPaddingH);
        gv_child.setStretchMode(GridView.NO_STRETCH);
        gv_child.setNumColumns(size);

        ClassicAdapter adapter = new ClassicAdapter(mContext, goods);
        gv_child.setAdapter(adapter);

        gv_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(mContext,GoodsClassActivity.class);
//                intent.putExtra("title",goods.getData().get(i).getName());
//                intent.putExtra("pid",goods.getData().get(i).getPid());
//                startActivity(intent);
                pid=goods.getData().get(i).getId();
                getGoosList();
            }
        });
        getGoosList();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context 上下文
     * @param dpValue dp值
     * @return px值
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
