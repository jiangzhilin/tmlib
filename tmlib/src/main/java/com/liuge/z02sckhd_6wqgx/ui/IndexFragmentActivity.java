package com.liuge.z02sckhd_6wqgx.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.fragment.IntoMallFragment;

public class IndexFragmentActivity extends FragmentActivity {

    private FrameLayout frame;

    private FragmentManager supportFragmentManager;
    private FragmentTransaction fragmentTransaction;

    IntoMallFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_index_fragment);
        initView();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        //获取管理者
        supportFragmentManager = this.getSupportFragmentManager();
        //开启事务
        fragmentTransaction = supportFragmentManager.beginTransaction();

        mFragment=new IntoMallFragment();

        fragmentTransaction.add(R.id.frame, mFragment).commit();
    }
}
