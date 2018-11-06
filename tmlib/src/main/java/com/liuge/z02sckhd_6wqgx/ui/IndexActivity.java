package com.liuge.z02sckhd_6wqgx.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.PagerAdapter;
import com.liuge.z02sckhd_6wqgx.fragment.CartFragment;
import com.liuge.z02sckhd_6wqgx.fragment.GoodsFragment;
import com.liuge.z02sckhd_6wqgx.fragment.IndexFragment;
import com.liuge.z02sckhd_6wqgx.fragment.MineFragment;
import com.liuge.z02sckhd_6wqgx.fragment.ShouyiFragment;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.ControlScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IndexActivity extends FragmentActivity {

    private ControlScrollViewPager pager;
    private RadioButton rb_index;
    private RadioButton rb_goods;
    private RadioButton rb_cart;
    private RadioButton rb_shouyi;
    private RadioButton rb_mine;

    private List<Fragment> mFragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBarColor(this,R.color.transparent);
        StatusBarUtil.StatusBarLightMode(this);
        setContentView(R.layout.z02sckhd_6wqgx_activity_new);
        SixGridContext.init(this);
        initView();
    }

    private void initView() {

        pager = (ControlScrollViewPager) findViewById(R.id.view_pager);
        rb_index = (RadioButton) findViewById(R.id.rb_index);
        rb_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(0,false);
            }
        });
        rb_goods = (RadioButton) findViewById(R.id.rb_goods);
        rb_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(1,false);
            }
        });
        rb_cart = (RadioButton) findViewById(R.id.rb_cart);
        rb_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(2,false);
            }
        });
        rb_shouyi = (RadioButton) findViewById(R.id.rb_shouyi);
        rb_shouyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(3,false);
            }
        });
        rb_mine = (RadioButton) findViewById(R.id.rb_mine);
        rb_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(4,false);
            }
        });

        pager.setScanScroll(false);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        rb_index.setChecked(true);
                        break;
                    case 1:
                        rb_goods.setChecked(true);
                        break;
                    case 2:
                        rb_cart.setChecked(true);
                        break;
                    case 3:
                        rb_shouyi.setChecked(true);
                        break;
                    case 4:
                        rb_mine.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        //定义底部标签图片大小和位置
        Drawable drawable_idnex = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_index);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_idnex.setBounds(0, 10, 60, 70);
        //设置图片在文字的哪个方向
        rb_index.setCompoundDrawables(null, drawable_idnex, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_goods = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_goods);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_goods.setBounds(0, 10, 60, 70);
        //设置图片在文字的哪个方向
        rb_goods.setCompoundDrawables(null, drawable_goods, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_cart = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_cart);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_cart.setBounds(0, 10, 60,70);
        //设置图片在文字的哪个方向
        rb_cart.setCompoundDrawables(null, drawable_cart, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_shouyi = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_shouyi);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_shouyi.setBounds(0, 10, 60,70);
        //设置图片在文字的哪个方向
        rb_shouyi.setCompoundDrawables(null, drawable_shouyi, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_mine = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_mine);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_mine.setBounds(0, 10, 60,70);
        //设置图片在文字的哪个方向
        rb_mine.setCompoundDrawables(null, drawable_mine, null, null);

        setPager();
    }
    
    private void setPager(){
        pager.setAdapter(new PagerAdapter(this.getSupportFragmentManager(),getFragment()));
        pager.setCurrentItem(0);
    }

    private List<Fragment> getFragment (){
        if (mFragmentList != null) {
            mFragmentList.clear();
        }else{
            mFragmentList=new ArrayList<>();
        }
        mFragmentList.add(new IndexFragment());
        mFragmentList.add(new GoodsFragment());
        mFragmentList.add(new CartFragment());
        mFragmentList.add(new ShouyiFragment());
        mFragmentList.add(new MineFragment());
        return mFragmentList;
    }
}
