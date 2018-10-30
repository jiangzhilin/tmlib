package com.sobey.tmgc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sobey.tmgc.adapter.MainViewPagerAdapter;
import com.sobey.tmgc.bean.ModuleBean;
import com.tenma.ventures.base.TMFragment;
import com.tenma.ventures.config.TMConstant;

import com.tenma.ventures.base.TMActivity;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板基类
 * Created by bin on 2017/12/26.
 */

public class HomeActivity extends TMActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private LinearLayout tab_item_ll;

    private TextView bg_bar;

    private List<TextView> tabTextViews;
    private List<View> tabLineViews;

    private List<ModuleBean> moduleBeen;


    private ViewPager mainViewPager;

    /**
     * Fragment集合
     */
    private List<Fragment> mMainFragments;

    /**
     * 适配器
     */
    private MainViewPagerAdapter mMainViewPagerAdapter;

    private String tabBgColor;
    private String tabSelTextColor;
    private String tabUnSelTextColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    private void initView() {

        tabTextViews = new ArrayList<>();
        tabLineViews = new ArrayList<>();
        mMainFragments = new ArrayList<>();
        moduleBeen = new ArrayList<>();

        tab_item_ll = (LinearLayout) findViewById(R.id.tab_item_ll);
        bg_bar = (TextView) findViewById(R.id.bg_bar);
        mainViewPager = (ViewPager) findViewById(R.id.viewPager);

        try {
            FileInputStream is = openFileInput(TMConstant.Config.CONFIG_FILE_NAME);
            int size = is.available();
            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            // Convert the buffer into a string.
            String text = new String(buffer, "utf-8");
            // Finally stick the string into the text view.

            Gson gson = new Gson();
            JsonObject moduleJson = gson.fromJson(text, JsonObject.class);

            JsonObject configJson = moduleJson.getAsJsonObject("config");
            tabBgColor = configJson.get("androidTabBgColor").getAsString();
            tabSelTextColor = configJson.get("androidContentSelColor").getAsString();
            tabUnSelTextColor = configJson.get("androidContentColor").getAsString();
            bg_bar.setBackgroundColor(Color.parseColor(tabBgColor));

            tab_item_ll.removeAllViews();
            JsonArray contentArray = moduleJson.getAsJsonArray("content");
            for (int i = 0; i < contentArray.size(); i++) {
                ModuleBean moduleBean = gson.fromJson(contentArray.get(i).getAsJsonObject(), ModuleBean.class);
                moduleBeen.add(moduleBean);
                LinearLayout tabItem = (LinearLayout) getLayoutInflater().inflate(R.layout.item_tab, null);
                TextView tabTitle = tabItem.findViewById(R.id.tab_title);
                View tabLine = tabItem.findViewById(R.id.line_tab);

                tabTitle.setTag(moduleBean.getKey());
                tabLine.setTag(moduleBean.getKey());
                tabTitle.setText(moduleBean.getTitle());
                tabTitle.setOnClickListener(this);
                tabTextViews.add(tabTitle);
                tabLineViews.add(tabLine);

                LinearLayout.LayoutParams tabItemParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                tabItem.setLayoutParams(tabItemParams);
                tab_item_ll.addView(tabItem);

                if (moduleBean.isNativeX()) {
                    Fragment nativeFragment = Fragment.instantiate(this, moduleBean.getAndroidSrc());
                    mMainFragments.add(nativeFragment);
                } else {
                    Bundle tmBundle = new Bundle();
                    tmBundle.putString(TMConstant.BundleParams.LOAD_URL, TMConstant.TM_HTML_FOLDER + moduleBean.getWwwFolderAndroid() + moduleBean.getAndroidSrc());
                    tmBundle.putString(TMConstant.BundleParams.CONFIG_XML, "comp01_config");
                    Fragment h5Fragment = TMFragment.newInstance(tmBundle);
                    mMainFragments.add(h5Fragment);
                }
            }

            String firstTag = null != moduleBeen && moduleBeen.size() > 0 ? moduleBeen.get(0).getKey() : "";
            setTabBackgroundAndColor(firstTag);
            switchFragment(firstTag);
        } catch (IOException e) {
        }

        mMainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), mMainFragments);
        mainViewPager.setAdapter(mMainViewPagerAdapter);
        mainViewPager.setCurrentItem(0);

        mainViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_title:
                setTabBackgroundAndColor((String) v.getTag());
                switchFragment((String) v.getTag());
                break;
        }
    }

    private void switchFragment(String tag) {
        for (int i = 0; i < tabTextViews.size(); i++) {
            TextView textView = tabTextViews.get(i);
            if (tag.equals(textView.getTag())) {
                mainViewPager.setCurrentItem(i);
            }
        }
    }

    public void setTabBackgroundAndColor(String tag) {
        for (TextView textView : tabTextViews) {
            textView.setTextColor(tag.equals(textView.getTag()) ? Color.parseColor(tabSelTextColor) : Color.parseColor(tabUnSelTextColor));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tag.equals(textView.getTag()) ? 18 : 16);
        }
        for (View view : tabLineViews) {
            view.setVisibility(tag.equals(view.getTag()) ? View.VISIBLE : View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setTabBackgroundAndColor((String) tabTextViews.get(position).getTag());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
