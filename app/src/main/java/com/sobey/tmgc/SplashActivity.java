package com.sobey.tmgc;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tenma.ventures.api.callback.RxResultCallback;
import com.tenma.ventures.api.callback.RxStringCallback;
import com.tenma.ventures.base.TMActivity;
import com.tenma.ventures.config.TMConstant;
import com.tenma.ventures.model.TMConfig;
import com.tenma.ventures.widget.CountDownProgressView;

import java.io.File;
import java.io.FileOutputStream;

import okhttp3.ResponseBody;

/**
 * 启动页
 * Created by bin on 2018/1/3.
 */

public class SplashActivity extends TMActivity {

    private static final String TAG = "LauncherActivity";

    private CountDownProgressView mCountDownProgressView;
    private ImageView mSecondLauncherIv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mCountDownProgressView = (CountDownProgressView) findViewById(R.id.countdownProgressView);
        mSecondLauncherIv = (ImageView) findViewById(R.id.second_launcher_iv);

        TMConfig.getInstance(this).getConfig(new RxStringCallback() {
            @Override
            public void onNext(Object tag, String response) {
                File configFile = new File(getFilesDir(), TMConstant.Config.CONFIG_FILE_NAME);
                if (configFile.exists()) {
                    configFile.deleteOnExit();
                }
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput(TMConstant.Config.CONFIG_FILE_NAME, Context.MODE_PRIVATE);
                    outputStream.write(response.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                JsonObject configJson = gson.fromJson(response, JsonObject.class);
                String launchImageAndroid = configJson.get("config").getAsJsonObject().get("launchImageAndroid").getAsString();
                if (!TextUtils.isEmpty(launchImageAndroid)) {
                    Glide.with(SplashActivity.this).load(launchImageAndroid).into(mSecondLauncherIv);
                }

                showCountDownProgressView();
            }

            @Override
            public void onError(Object tag, Throwable e) {
                noNetWork();
            }

            @Override
            public void onCancel(Object tag, Throwable e) {

            }
        });
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.transparent);
    }

    private void showCountDownProgressView() {
        mCountDownProgressView.setProgressListener(new CountDownProgressView.OnProgressListener() {
            @Override
            public void onProgress(int progress) {
                if (progress == 0) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                }
            }
        });
        mCountDownProgressView.start();

        mCountDownProgressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                mCountDownProgressView.stop();
                finish();
            }
        });
    }

    /**
     * 没有网络
     */
    private void noNetWork() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("无可用网络").setMessage("网络好像有问题，现在去设置网络?");
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                try {
                    int sdkVersion = android.os.Build.VERSION.SDK_INT;
                    if (sdkVersion > 10) {
                        intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    } else {
                        intent = new Intent();
                        ComponentName comp = new ComponentName("com.android.settings",
                                "com.android.settings.WirelessSettings");
                        intent.setComponent(comp);
                        intent.setAction("android.intent.action.VIEW");
                    }
                    startActivity(intent);
                } catch (Exception e) {
                }
                finish();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
                System.exit(0);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
