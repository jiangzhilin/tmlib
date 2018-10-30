package com.tenma.ventures.test.app;

import com.liuge.TMShop.network.SixGridContext;
import com.tenma.ventures.app.TMApplication;

/**
 * Created by bin on 2018/3/27.
 */

public class TMTestApp extends TMApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        SixGridContext.init(this);
    }
}
