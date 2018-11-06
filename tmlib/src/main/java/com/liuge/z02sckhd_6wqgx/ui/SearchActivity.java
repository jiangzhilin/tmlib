package com.liuge.z02sckhd_6wqgx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.IndexHotGoodsAdapter;
import com.liuge.z02sckhd_6wqgx.adapter.SearchMallAdapter;
import com.liuge.z02sckhd_6wqgx.entity.GoodsListEntity;
import com.liuge.z02sckhd_6wqgx.entity.MallEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity {

    private EditText ed_search;
    private GridView gv_goods;
    private Button bt_search;
    private TabLayout tab;

    private int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_search);
        initView();
    }

    @Override
    protected void initData() {
        setTitle("搜索");
        setBack();
    }

    private void initView() {
        ed_search = (EditText) findViewById(R.id.ed_search);
        gv_goods = (GridView) findViewById(R.id.gv_goods);


        bt_search = (Button) findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("商品"),0);
        tab.addTab(tab.newTab().setText("商家"),1);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position=tab.getPosition();
                ed_search.setText("");
                gv_goods.setAdapter(null);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void submit() {
        // validate
        String search = ed_search.getText().toString().trim();
        if (TextUtils.isEmpty(search)) {
            Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if(position==1) {
            Search(search);
        }else{
            getGoods(search);
        }

    }

    private void Search(String key) {
        LoadDialog.show(mContext);
        new ApiManager().getSearch(key, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("Search", "onSuccess: " + result);
                final MallEntity mall=JSONObject.parseObject(result,MallEntity.class);
                SearchMallAdapter mallAdapter=new SearchMallAdapter(mContext,mall);
                gv_goods.setAdapter(mallAdapter);
                gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,MallActivity.class);
                        intent.putExtra("sid",mall.getData().getResult().get(i).getId());
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

    private void getGoods(String key){
        LoadDialog.show(mContext);
        new ApiManager().getGoodsSearch(key, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("Search", "onSuccess: " + result);
                IndexHotGoodsAdapter madapter2 = new IndexHotGoodsAdapter(mContext);
                gv_goods.setAdapter(madapter2);
                GoodsListEntity entity= JSONObject.parseObject(result,GoodsListEntity.class);
                final List<GoodsListEntity.DataBean.ResultBean> mList=new ArrayList<>();
                mList.clear();
                mList.addAll(entity.getData().getResult());
                madapter2.setList(mList);

                gv_goods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent=new Intent(mContext,GoodsDetailsActivity.class);
                        intent.putExtra("goods_id",mList.get(i).getGoods_id());
                        mContext.startActivity(intent);
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
}
