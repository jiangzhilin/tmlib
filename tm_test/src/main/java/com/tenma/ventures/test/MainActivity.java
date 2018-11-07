package com.tenma.ventures.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.liuge.z02sckhd_6wqgx.ui.IndexFragmentActivity;
import com.tenma.ventures.api.callback.TMUserCallback;
import com.tenma.ventures.base.TMWebActivity;
import com.tenma.ventures.bean.TMUser;
import com.tenma.ventures.bean.utils.TMSharedPUtil;
import com.tenma.ventures.config.TMConstant;
import com.tenma.ventures.config.TMServerConfig;
import com.tenma.ventures.model.TMModelManager;
import com.tenma.ventures.xiamen.R;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {


    private TMModelManager tmModelManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TMServerConfig.BASE_URL = "http://shop.dktoo.com/z02sckhd_6wqgx";

        Button htmlBtn = findViewById(R.id.html_btn);
        htmlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TMWebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(TMConstant.BundleParams.LOAD_URL, "file:///android_asset/pages/comp01/index.html");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Button loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginByPassword();
            }
        });

        Button userBtn = findViewById(R.id.user_btn);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMUser tmUser = TMSharedPUtil.getTMUser(MainActivity.this);
                String userJsonStr = "";
                if (null != tmUser) {
                    Gson gson = new Gson();
                    userJsonStr = gson.toJson(tmUser);
                }
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("提示");
                alertDialog.setMessage(userJsonStr);
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        Button pluginBtn = findViewById(R.id.plugin_btn);
        pluginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, TMWebActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString(TMConstant.BundleParams.LOAD_URL, "file:///android_asset/pages/comp01/plugin_index.html");
//                intent.putExtras(bundle);
//                startActivity(intent);

                Intent intent=new Intent(MainActivity.this, IndexFragmentActivity.class);
                startActivity(intent);
            }
        });

        tmModelManager = TMModelManager.getInstance(this);
    }

    /**
     * 通过密码登录
     */
    private void loginByPassword() {
        String mobile = "13908064279";
        String password = "123456";

        JsonObject loginJson = new JsonObject();
        loginJson.addProperty("mobile", mobile);
        loginJson.addProperty("state", 2);
        loginJson.addProperty("site_code", "00000000000000000000000000000000");
        loginJson.addProperty("code", "");
        loginJson.addProperty("password", password);
        tmModelManager.login(loginJson.toString(), new TMUserCallback<TMUser>() {
            @Override
            public void onNext(Object tag, int code, String message, TMUser response) {
                if (code != 200) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                JPushInterface.setAlias(MainActivity.this, 1, response.getMember_code());
            }

            @Override
            public void onError(Object tag, Throwable e) {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel(Object tag, Throwable e) {

            }
        });
    }
}
