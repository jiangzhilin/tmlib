package com.liuge.z02sckhd_6wqgx.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.IndexClassicAdapter;
import com.liuge.z02sckhd_6wqgx.adapter.IndexHotGoodsAdapter;
import com.liuge.z02sckhd_6wqgx.adapter.IndexHotMallAdapter;
import com.liuge.z02sckhd_6wqgx.adapter.IndexListAdapter;
import com.liuge.z02sckhd_6wqgx.entity.BannerEntity;
import com.liuge.z02sckhd_6wqgx.entity.GoodsListEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.ui.GoodsClassActivity;
import com.liuge.z02sckhd_6wqgx.ui.GoodsDetailsActivity;
import com.liuge.z02sckhd_6wqgx.ui.MallActivity;
import com.liuge.z02sckhd_6wqgx.ui.SearchActivity;
import com.liuge.z02sckhd_6wqgx.utils.GlideImageLoader;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroGridView;
import com.liuge.z02sckhd_6wqgx.view.NoScroListView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

import me.dkzwm.smoothrefreshlayout.RefreshingListenerAdapter;
import me.dkzwm.smoothrefreshlayout.SmoothRefreshLayout;
import me.dkzwm.smoothrefreshlayout.extra.footer.ClassicFooter;
import me.dkzwm.smoothrefreshlayout.extra.header.ClassicHeader;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IndexFragment extends BaseFragment {
    /**
     * 预加载标志，默认值为false，设置为true，表示已经预加载完成，可以加载数据
     */
    private boolean isPrepared;

    private ViewHolder vh;
    private View view;

    private List<String> mBannerData;

    private int[] icons = new int[]{R.mipmap.z02sckhd_6wqgx_icon_nvzhuang, R.mipmap.z02sckhd_6wqgx_icon_xiemao, R.mipmap.z02sckhd_6wqgx_icon_tongzhuang, R.mipmap.z02sckhd_6wqgx_icon_meizhuang, R.mipmap.z02sckhd_6wqgx_icon_shippin, R.mipmap.z02sckhd_6wqgx_icon_baihuo, R.mipmap.z02sckhd_6wqgx_icon_jiadian, R.mipmap.z02sckhd_6wqgx_icon_more};

    private String[] names = new String[]{"女装", "鞋帽", "童装", "美妆", "食品", "百货", "家电", "更多"};

    private int choose_position=0;

    /**
     * Fragment生命周期方法，此view可改为自定义的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.z02sckhd_6wqgx_fragment_index, container, false);
        vh = new ViewHolder(view);

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


        IndexHotGoodsAdapter madapter = new IndexHotGoodsAdapter(getActivity());
        vh.new_goods.setAdapter(madapter);

        vh.ll_xinpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vh.rb_xinpin.setChecked(true);
                vh.ll_line_1.setVisibility(View.VISIBLE);
                vh.rb_xinpin_2.setChecked(false);
                vh.ll_line_2.setVisibility(View.INVISIBLE);
                choose_position=0;
                getClaGoods(choose_position);
            }
        });
        vh.ll_rexiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vh.rb_xinpin.setChecked(false);
                vh.ll_line_1.setVisibility(View.INVISIBLE);
                vh.rb_xinpin_2.setChecked(true);
                vh.ll_line_2.setVisibility(View.VISIBLE);
                choose_position=1;
                getClaGoods(choose_position);
            }
        });

        vh.ed_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        getClaGoods(0);
        getBanner();

        vh.refreshLayout.setMode(SmoothRefreshLayout.MODE_REFRESH);
        vh.refreshLayout.setHeaderView(new ClassicHeader(getActivity()));
        vh.refreshLayout.setOnRefreshListener(new RefreshingListenerAdapter() {
            @Override
            public void onRefreshBegin(boolean isRefresh) {

                if(vh.refreshLayout.isRefreshing()){
                    getBanner();
                    getClaGoods(choose_position);
                }
            }
        });
    }

    private void getBanner() {
        LoadDialog.show(getActivity());
        new ApiManager().getBanner(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.d(TAG, "onSuccess: " + result);

                final BannerEntity entity = JSONObject.parseObject(result, BannerEntity.class);

                mBannerData = new ArrayList<>();
                for (int x = 0; x < entity.getData().getBanner().size(); x++) {
                    mBannerData.add(entity.getData().getBanner().get(x).getLitpic());
                }
                vh.banner.setImages(mBannerData)
                        .setImageLoader(new GlideImageLoader())
                        .setIndicatorGravity(BannerConfig.RIGHT)
                        .setDelayTime(4000)
                        .start();

                IndexClassicAdapter adapter = new IndexClassicAdapter(getActivity(), entity);
                vh.rcy_classic.setAdapter(adapter);
                vh.rcy_classic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), GoodsClassActivity.class);
                        intent.putExtra("title", entity.getData().getCategory().get(i).getName());
                        intent.putExtra("pid", entity.getData().getCategory().get(i).getId());
                        startActivity(intent);
                    }
                });

                IndexListAdapter listAdapter = new IndexListAdapter(getActivity(), entity);
                vh.listView.setAdapter(listAdapter);

                IndexHotMallAdapter mallAdapter = new IndexHotMallAdapter(getActivity(), entity);
                vh.gv_jinping.setAdapter(mallAdapter);
                vh.gv_jinping.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getActivity(), MallActivity.class);
                        intent.putExtra("sid", entity.getData().getBestshop().get(i).getId());
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
                LoadDialog.dismiss(getActivity());
                if(vh.refreshLayout.isRefreshing()){
                    vh.refreshLayout.refreshComplete();
                }
            }
        });
    }

    private void getClaGoods(int type) {
        LoadDialog.show(getActivity());
        new ApiManager().getGoodsList(null, null, null, null, null, type == 0 ? null : "1", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                final GoodsListEntity goodsList = JSONObject.parseObject(result, GoodsListEntity.class);
                IndexHotGoodsAdapter adapter = new IndexHotGoodsAdapter(getActivity());
                vh.new_goods.setAdapter(adapter);
                adapter.setList(goodsList.getData().getResult());

                vh.new_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getActivity(), GoodsDetailsActivity.class);
                        intent.putExtra("goods_id", goodsList.getData().getResult().get(position).getGoods_id());
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
                LoadDialog.dismiss(getActivity());
                if(vh.refreshLayout.isRefreshing()){
                    vh.refreshLayout.refreshComplete();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getClaGoods(0);
        getBanner();
    }

    class ViewHolder {
        public View rootView;
        public Banner banner;
        public LinearLayout ll_bar;
        public ImageView iv_search;
        public EditText ed_search;
        public ImageView iv_del;
        public NoScroGridView rcy_classic;
        public NoScroListView listView;
        public RadioButton rb_xinpin;
        public LinearLayout ll_line_1;
        public LinearLayout ll_xinpin;
        public RadioButton rb_xinpin_2;
        public LinearLayout ll_line_2;
        public LinearLayout ll_rexiao;
        public NoScroGridView new_goods;
        public ImageView iv_head;
        public NoScroGridView gv_jinping;
        public SmoothRefreshLayout refreshLayout;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
            this.iv_search = (ImageView) rootView.findViewById(R.id.iv_search);
            this.ed_search = (EditText) rootView.findViewById(R.id.ed_search);
            this.iv_del = (ImageView) rootView.findViewById(R.id.iv_del);
            this.rcy_classic = (NoScroGridView) rootView.findViewById(R.id.rcy_classic);
            this.listView = (NoScroListView) rootView.findViewById(R.id.listView);
            this.rb_xinpin = (RadioButton) rootView.findViewById(R.id.rb_xinpin);
            this.ll_line_1 = (LinearLayout) rootView.findViewById(R.id.ll_line_1);
            this.ll_xinpin = (LinearLayout) rootView.findViewById(R.id.ll_xinpin);
            this.rb_xinpin_2 = (RadioButton) rootView.findViewById(R.id.rb_xinpin_2);
            this.ll_line_2 = (LinearLayout) rootView.findViewById(R.id.ll_line_2);
            this.ll_rexiao = (LinearLayout) rootView.findViewById(R.id.ll_rexiao);
            this.new_goods = (NoScroGridView) rootView.findViewById(R.id.new_goods);
            this.iv_head = (ImageView) rootView.findViewById(R.id.iv_head);
            this.gv_jinping = (NoScroGridView) rootView.findViewById(R.id.gv_jinping);
            this.refreshLayout = (SmoothRefreshLayout) rootView.findViewById(R.id.smoothRefreshLayout);
        }

    }
}
