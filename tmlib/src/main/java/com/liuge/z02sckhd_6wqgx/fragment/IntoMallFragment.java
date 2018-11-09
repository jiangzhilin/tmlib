package com.liuge.z02sckhd_6wqgx.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.PagerAdapter;
import com.liuge.z02sckhd_6wqgx.network.SixGridContext;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.utils.StatusBarUtil;
import com.liuge.z02sckhd_6wqgx.view.ControlScrollViewPager;
import com.tenma.ventures.base.TMFragment;
import com.tenma.ventures.bean.utils.TMSharedPUtil;
import com.tenma.ventures.tools.change_activity.TitleChange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/21.
 */

public class IntoMallFragment extends TMFragment {
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

        StatusBarUtil.setStatusBarColor(getActivity(),R.color.transparent);
        StatusBarUtil.StatusBarLightMode(getActivity());

        if(getActivity() instanceof TitleChange){
            ((TitleChange) getActivity()).hideTitle();
        }

        view = inflater.inflate(R.layout.z02sckhd_6wqgx_activity_new, container, false);
        vh = new ViewHolder(view);


        SixGridContext.init(getActivity());

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
        Drawable drawable_idnex = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_index);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_idnex.setBounds(0, 10, 65, 70);
        //设置图片在文字的哪个方向
        vh.rb_index.setCompoundDrawables(null, drawable_idnex, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_goods = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_goods);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_goods.setBounds(0, 10, 65, 70);
        //设置图片在文字的哪个方向
        vh.rb_goods.setCompoundDrawables(null, drawable_goods, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_cart = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_cart);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_cart.setBounds(0, 10, 65, 70);
        //设置图片在文字的哪个方向
        vh.rb_cart.setCompoundDrawables(null, drawable_cart, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_shouyi = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_shouyi);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_shouyi.setBounds(0, 10, 65, 70);
        //设置图片在文字的哪个方向
        vh.rb_shouyi.setCompoundDrawables(null, drawable_shouyi, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_mine = getResources().getDrawable(R.drawable.z02sckhd_6wqgx_radio_mine);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_mine.setBounds(0, 10, 65, 70);
        //设置图片在文字的哪个方向
        vh.rb_mine.setCompoundDrawables(null, drawable_mine, null, null);


        vh.rb_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vh.view_pager.setCurrentItem(0,false);
            }
        });
        vh.rb_goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vh.view_pager.setCurrentItem(1,false);
            }
        });
        vh.rb_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TMSharedPUtil.getTMUser(getActivity())==null){
                    NToast.shortToast(getActivity(),"请先登录");
                    return;
                }
                vh.view_pager.setCurrentItem(2,false);
            }
        });
        vh.rb_shouyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TMSharedPUtil.getTMUser(getActivity())==null){
                    NToast.shortToast(getActivity(),"请先登录");
                    return;
                }
                vh.view_pager.setCurrentItem(3,false);
            }
        });
        vh.rb_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TMSharedPUtil.getTMUser(getActivity())==null){
                    NToast.shortToast(getActivity(),"请先登录");
                    return;
                }
                vh.view_pager.setCurrentItem(4,false);
            }
        });

        setPager();
    }

    private void setPager(){
        vh.view_pager.setScanScroll(false);
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
        public ControlScrollViewPager view_pager;
        public RadioButton rb_index;
        public RadioButton rb_goods;
        public RadioButton rb_cart;
        public RadioButton rb_shouyi;
        public RadioButton rb_mine;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ll_bar = (LinearLayout) rootView.findViewById(R.id.ll_bar);
            this.view_pager = (ControlScrollViewPager) rootView.findViewById(R.id.view_pager);
            this.rb_index = (RadioButton) rootView.findViewById(R.id.rb_index);
            this.rb_goods = (RadioButton) rootView.findViewById(R.id.rb_goods);
            this.rb_cart = (RadioButton) rootView.findViewById(R.id.rb_cart);
            this.rb_shouyi = (RadioButton) rootView.findViewById(R.id.rb_shouyi);
            this.rb_mine = (RadioButton) rootView.findViewById(R.id.rb_mine);
        }

    }
}
