package com.tenma.ventures.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.tenma.ventures.base.TMActivity;
import com.tenma.ventures.config.TMConstant;
import com.tenma.ventures.xiamen.R;

/**
 * Created by bin on 2018/3/27.
 */

public class NativeActivity extends TMActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            String param = bundle.getString(TMConstant.BundleParams.MULTI_WINDOW_ARGUMENTS);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("提示");
            alertDialog.setMessage("传递过来的参数是：" + param);
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }
}
