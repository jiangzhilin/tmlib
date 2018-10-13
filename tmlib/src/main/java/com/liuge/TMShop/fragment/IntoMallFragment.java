package com.liuge.TMShop.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.alibaba.fastjson.JSONObject;
import com.liuge.TMShop.R;
import com.liuge.TMShop.adapter.IndexClassicAdapter;
import com.liuge.TMShop.adapter.IndexHotGoodsAdapter;
import com.liuge.TMShop.adapter.IndexHotMallAdapter;
import com.liuge.TMShop.adapter.IndexListAdapter;
import com.liuge.TMShop.adapter.PagerAdapter;
import com.liuge.TMShop.entity.BannerEntity;
import com.liuge.TMShop.network.ApiManager;
import com.liuge.TMShop.ui.GoodsClassActivity;
import com.liuge.TMShop.ui.MallActivity;
import com.liuge.TMShop.utils.GlideImageLoader;
import com.liuge.TMShop.utils.StatusBarUtil;
import com.liuge.TMShop.view.LoadDialog;
import com.youth.banner.BannerConfig;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IntoMallFragment extends Fragment {
    /**
     * 预加载标志，默认值为false，设置为true，表示已经预加载完成，可以加载数据
     */
    private boolean isPrepared;

    private ViewHolder vh;
    private View view;

    private List<Fragment> mFragmentList;

    /**
     * Fragment生命周期方法，此view可改为自定义的布局
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_new, container, false);
        vh = new ViewHolder(view);

//        //获得状态栏高度
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtil.getStatusBarHeight(getActivity()));
//        vh.ll_bar.setLayoutParams(params);
        //TODO 此处初始化view中各个控件
        isPrepared = true;
//        setlazyLoad();
        initView();
        return view;
    }

    /**
     * 加载数据的方法，只要保证isPrepared和isVisible都为true的时候才往下执行开始加载数据
     */
//    @Override
//    protected void setlazyLoad() {
//        super.setlazyLoad();
//        if (!isPrepared || !isVisible) {
//            return;
//        }
//        //TODO 此处填充view中各个控件的数据
//        initView();
//    }

    private void initView() {


        vh.view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        vh.rb_index.setChecked(true);
                        break;
                    case 1:
                        vh.rb_goods.setChecked(true);
                        break;
                    case 2:
                        vh.rb_cart.setChecked(true);
                        break;
                    case 3:
                        vh.rb_shouyi.setChecked(true);
                        break;
                    case 4:
                        vh.rb_mine.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        //定义底部标签图片大小和位置
        Drawable drawable_idnex = getResources().getDrawable(R.drawable.radio_index);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_idnex.setBounds(0, 10, 75, 80);
        //设置图片在文字的哪个方向
        vh.rb_index.setCompoundDrawables(null, drawable_idnex, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_goods = getResources().getDrawable(R.drawable.radio_goods);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_goods.setBounds(0, 10, 75, 80);
        //设置图片在文字的哪个方向
        vh.rb_goods.setCompoundDrawables(null, drawable_goods, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_cart = getResources().getDrawable(R.drawable.radio_cart);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_cart.setBounds(0, 10, 75, 80);
        //设置图片在文字的哪个方向
        vh.rb_cart.setCompoundDrawables(null, drawable_cart, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_shouyi = getResources().getDrawable(R.drawable.radio_shouyi);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_shouyi.setBounds(0, 10, 75, 80);
        //设置图片在文字的哪个方向
        vh.rb_shouyi.setCompoundDrawables(null, drawable_shouyi, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_mine = getResources().getDrawable(R.drawable.radio_mine);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_mine.setBounds(0, 10, 75, 80);
        //设置图片在文字的哪个方向
        vh.rb_mine.setCompoundDrawables(null, drawable_mine, null, null);

        setPager();
    }

    private void setPager(){
        vh.view_pager.setAdapter(new PagerAdapter(this.getFragmentManager(),getFragment()));
        vh.view_pager.setCurrentItem(0);
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

    class ViewHolder {
        public View rootView;
        public LinearLayout ll_bar;
        public ViewPager view_pager;
        public RadioButton rb_index;
        public RadioButton rb_goods;
        public RadioButton rb_cart;
        public RadioButton rb_shouyi;
        public RadioButton rb_mine;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
            this.view_pager = (ViewPager) rootView.findViewById(R.id.view_pager);
            this.rb_index = (RadioButton) rootView.findViewById(R.id.rb_index);
            this.rb_goods = (RadioButton) rootView.findViewById(R.id.rb_goods);
            this.rb_cart = (RadioButton) rootView.findViewById(R.id.rb_cart);
            this.rb_shouyi = (RadioButton) rootView.findViewById(R.id.rb_shouyi);
            this.rb_mine = (RadioButton) rootView.findViewById(R.id.rb_mine);
        }

    }
}
