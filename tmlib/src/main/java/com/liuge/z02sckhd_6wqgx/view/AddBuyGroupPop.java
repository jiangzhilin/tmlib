package com.liuge.z02sckhd_6wqgx.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.ui.TuangouDetailsActivity;
import com.liuge.z02sckhd_6wqgx.utils.NToast;

import org.xutils.common.Callback;

/**
 * Created by jiang on 2018/2/22.
 */

public class AddBuyGroupPop extends PopupWindow {
    private static final String TAG = "AddBuyPop";
    static Activity mContext;
    public static AddBuyGroupPop dialog;
    static View view;
    static ChooseListener mListener;
    static int choose_position = 0;
    static ViewHolder vh;

    static int tags = 0;

    public interface ChooseListener {
        public void chooseClick(int position);
    }

    public AddBuyGroupPop(@NonNull Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.z02sckhd_6wqgx_pop_add_cart_buy, null);
        vh = new ViewHolder(view);

        this.setTouchable(true);
        this.setFocusable(true);
        // 设置PopupWindow的背景
        int w = mContext.getWindowManager().getDefaultDisplay().getWidth();
        int h = WindowManager.LayoutParams.WRAP_CONTENT;
//        int h = mContext.getWindowManager().getDefaultDisplay().getHeight();
        this.setWidth(w);
        this.setHeight(h);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
//        ColorDrawable dw = new ColorDrawable(0x99444444);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // 设置PopupWindow是否能响应外部点击事件
//        window.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        this.setAnimationStyle(R.style.ActionSheetDialogAnimation);
        // 显示PopupWindow，其中：
        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//        window.showAsDropDown(null, 0, 0);
        this.setContentView(view);
        this.update();

        vh.tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        vh.bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int num=Integer.valueOf(vh.ed_num.getText().toString());
                vh.ed_num.setText("" + (Integer.valueOf(vh.ed_num.getText().toString()) + 1));
            }
        });
        vh.bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.valueOf(vh.ed_num.getText().toString()) > 0) {
                    vh.ed_num.setText("" + (Integer.valueOf(vh.ed_num.getText().toString()) - 1));
                } else {
                    NToast.shortToast(mContext, "不能再减了");
                }
            }
        });
        vh.bt_cart.setVisibility(View.VISIBLE);
        vh.bt_buy.setVisibility(View.GONE);

        vh.ll_guige.setVisibility(View.GONE);
        vh.ll_head.setVisibility(View.GONE);

        vh.bt_cart.setText("提交订单");
        vh.bt_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCart(vh.ed_num.getText().toString());
            }
        });

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                lightoff(false);
            }
        });
    }

    private static void lightoff(boolean isoff) {
        WindowManager.LayoutParams lp = mContext.getWindow().getAttributes();
        if (isoff) {
            lp.alpha = 0.3f;
        } else {
            lp.alpha = 1f;
        }
        mContext.getWindow().setAttributes(lp);
        mContext.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public static void showDialog(Activity context, View parent) {
        mContext = context;

        lightoff(true);
        if (mContext != null) {
            if (dialog == null) {
                dialog = new AddBuyGroupPop(mContext);
                dialog.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            } else {
                dialog = null;
                dialog = new AddBuyGroupPop(mContext);
                dialog.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            }
            if (vh != null) {

            }
        }
    }

    public static void CancelDialog() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
                dialog = null;
                mContext = null;
            }
        }
    }

    private void addCart(String num) {
        LoadDialog.show(mContext);
        new ApiManager().tuangou_buy(TuangouDetailsActivity.instance.id,num, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base= JSONObject.parseObject(result,BaseEntity.class);
                NToast.shortToast(mContext,base.getMsg());
                CancelDialog();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                LoadDialog.dismiss(mContext);
            }
        });
    }

    //将dp转换为px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    class ViewHolder {
        public View rootView;
        public ImageView iv_img;
        public TextView tv_goods_name;
        public TextView tv_price;
        public LinearLayout ll_head;
        public RadioGroup rg_guige;
        public RadioGroup rg_shuliang;
        public LinearLayout ll_guige;
        public Button bt_sub;
        public TextView ed_num;
        public Button bt_add;
        public Button bt_cart;
        public Button bt_buy;
        public TextView tv_close;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.iv_img = (ImageView) rootView.findViewById(R.id.iv_img);
            this.tv_goods_name = (TextView) rootView.findViewById(R.id.tv_goods_name);
            this.tv_price = (TextView) rootView.findViewById(R.id.tv_price);
            this.ll_head = (LinearLayout) rootView.findViewById(R.id.ll_head);
            this.rg_guige = (RadioGroup) rootView.findViewById(R.id.rg_guige);
            this.rg_shuliang = (RadioGroup) rootView.findViewById(R.id.rg_shuliang);
            this.ll_guige = (LinearLayout) rootView.findViewById(R.id.ll_guige);
            this.bt_sub = (Button) rootView.findViewById(R.id.bt_sub);
            this.ed_num = (TextView) rootView.findViewById(R.id.ed_num);
            this.bt_add = (Button) rootView.findViewById(R.id.bt_add);
            this.bt_cart = (Button) rootView.findViewById(R.id.bt_cart);
            this.bt_buy = (Button) rootView.findViewById(R.id.bt_buy);
            this.tv_close = (TextView) rootView.findViewById(R.id.tv_close);
        }

    }
}
