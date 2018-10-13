package com.liuge.TMShop;

import android.app.Application;

import com.tenma.ventures.app.TMApplication;

import org.xutils.x;

/**
 * Created by Administrator on 2018/9/18.
 */

public class AppAplication extends TMApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
