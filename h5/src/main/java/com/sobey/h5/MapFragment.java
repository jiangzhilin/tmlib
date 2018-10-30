package com.sobey.h5;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;

import org.apache.cordova.CordovaFragment;
import org.apache.cordova.CordovaWebViewEngine;
import org.apache.cordova.LOG;
import org.apache.cordova.engine.x5engine.X5WebChromeClient;
import org.apache.cordova.engine.x5engine.X5WebView;
import org.apache.cordova.engine.x5engine.X5WebViewClient;
import org.apache.cordova.engine.x5engine.X5WebViewEngine;

/**
 * 地图
 * Created by bin on 2017/12/20.
 */

public class MapFragment extends CordovaFragment {
    private X5WebView x5WebView;
    private X5WebViewEngine x5WebViewEngine;

    public static Fragment newInstance(Bundle bundle) {
        Fragment fragment = new MapFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LOG.setLogLevel(LOG.DEBUG);//设置日志级别

        x5WebView = new X5WebView(getActivity());
        x5WebView.getSettings().setJavaScriptEnabled(true);
        x5WebView.getSettings().setAllowFileAccessFromFileURLs(true);

//        ConfigXmlParser parser = new ConfigXmlParser();
//        parser.parse(this);//这里会解析res/xml/config.xml配置文件
        x5WebViewEngine = new X5WebViewEngine(x5WebView, preferences);
//        CordovaWebView cordovaWebView = new CordovaWebViewImpl(x5WebViewEngine);//创建一个cordovawebview
//        cordovaWebView.init(new CordovaInterfaceImpl(this), parser.getPluginEntries(), parser.getPreferences());//初始化
        x5WebView.setWebViewClient(new X5WebViewClient(x5WebViewEngine) {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        x5WebView.setWebChromeClient(new X5WebChromeClient(x5WebViewEngine) {
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathsCallback, FileChooserParams fileChooserParams) {
                return super.onShowFileChooser(webView, filePathsCallback, fileChooserParams);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String loadUrl = bundle.getString("loadUrl");
        loadUrl(loadUrl);
    }

    @Override
    protected CordovaWebViewEngine makeWebViewEngine() {
        return x5WebViewEngine;
    }

    @Override
    protected String getConfigXml() {
        return null;
    }
}
