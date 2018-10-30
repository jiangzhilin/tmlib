package com.sobey.tmgc.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sobey.tmgc.R;
import com.sobey.tmgc.adapter.TAdapter;
import com.sobey.tmgc.bean.TBean;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tenma.ventures.base.TMFragment;

import org.apache.cordova.CordovaFragment;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.LOG;
import org.apache.cordova.engine.x5engine.X5WebChromeClient;
import org.apache.cordova.engine.x5engine.X5WebView;
import org.apache.cordova.engine.x5engine.X5WebViewClient;
import org.apache.cordova.engine.x5engine.X5WebViewEngine;

import java.util.ArrayList;
import java.util.List;


/**
 * 首页
 * Created by bin on 2017/12/15.
 */

public class HomeFragment extends Fragment {

    private List<TBean> tBeen;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int pageSize = 20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        tBeen = new ArrayList<>();

        for (int i = 0; i < pageSize; i++) {
            TBean tBean = new TBean();
            tBean.setId(i + 1);
            tBean.setName("name" + (i + 1));
            tBeen.add(tBean);
        }

        final TAdapter tAdapter = new TAdapter(getActivity(), tBeen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(tAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                int size = tBeen.size();
                for (int i = size; i < size + pageSize; i++) {
                    TBean tBean = new TBean();
                    tBean.setId(i + 1);
                    tBean.setName("name" + (i + 1));
                    tBeen.add(0, tBean);
                }
                tAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
