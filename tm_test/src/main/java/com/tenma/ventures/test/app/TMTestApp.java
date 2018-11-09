package com.tenma.ventures.test.app;

import com.tenma.ventures.app.TMApplication;

import org.xutils.x;

/**
 * Created by bin on 2018/3/27.
 */

public class TMTestApp extends TMApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
