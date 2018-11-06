package com.liuge.z02sckhd_6wqgx.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.Glide;
import com.liuge.z02sckhd_6wqgx.R;
import com.liuge.z02sckhd_6wqgx.adapter.AddimgAdapter;
import com.liuge.z02sckhd_6wqgx.entity.BaseEntity;
import com.liuge.z02sckhd_6wqgx.entity.ImgEntity;
import com.liuge.z02sckhd_6wqgx.entity.MineOrderEntity;
import com.liuge.z02sckhd_6wqgx.network.ApiManager;
import com.liuge.z02sckhd_6wqgx.utils.ChooseGlideImageLoader;
import com.liuge.z02sckhd_6wqgx.utils.NToast;
import com.liuge.z02sckhd_6wqgx.view.LoadDialog;
import com.liuge.z02sckhd_6wqgx.view.NoScroGridView;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends BaseActivity {

    private static final String TAG = "CommentActivity";
    private ImageView goods_img;
    private TextView tv_goods;
    private EditText ed_comment;
    private NoScroGridView gv_img;
    private RatingBar ratingBar;

    private double scro=5;
    List<String >ids=new ArrayList<>();

    private AddimgAdapter mAdapter;

    private List<String> path=new ArrayList<>();

    private MineOrderEntity.DataBean.ResultBean.OrdersBean.GoodsBean goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z02sckhd_6wqgx_activity_comment);
    }

    @Override
    protected void initData() {
        setBack();
        setTitle("立即评价");
        setRight("提交", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        goods= (MineOrderEntity.DataBean.ResultBean.OrdersBean.GoodsBean) getIntent().getSerializableExtra("goods");
        initView();
    }

    private void initView() {
        goods_img = (ImageView) findViewById(R.id.goods_img);
        tv_goods = (TextView) findViewById(R.id.tv_goods);
        ed_comment = (EditText) findViewById(R.id.ed_comment);
        gv_img = (NoScroGridView) findViewById(R.id.gv_img);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Glide.with(mContext).load(goods.getGoods_image()).into(goods_img);
        tv_goods.setText(goods.getGoods_name());

        mAdapter=new AddimgAdapter(mContext, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("增加图片1");
                int position= ((int) v.getTag())+1;
                if(position>path.size()){
                    System.out.println("增加图片2");
                    getPermission();
                }
            }
        });
        mAdapter.setMdelListener(new AddimgAdapter.delListener() {
            @Override
            public void onDelListener(int position) {
                path.remove(position);
                ids.remove(position);
                mAdapter.setPath(path);
            }
        });

        gv_img.setAdapter(mAdapter);
        mAdapter.setPath(path);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                scro=rating;
            }
        });

    }

    private void getPermission(){
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(CommentActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                // 提示用户如果想要正常使用，要手动去设置中授权。
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(CommentActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 121);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
            // 进行正常操作
            choose();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == 121) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "同意授权");
                // 进行正常操作。
                choose();
            } else {
                Log.i(TAG, "拒绝授权");
            }
        }
    }

    private void choose(){
        GalleryConfig galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new ChooseGlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.liuge.TMShop.utils.MyProvider")   // provider (必填)
                .pathList(path)                         // 记录已选的图片
                .multiSelect(true, 9)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .crop(false)
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery/Pictures")          // 图片存放路径
                .build();
        GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(CommentActivity.this);
    }

    IHandlerCallBack iHandlerCallBack = new IHandlerCallBack() {
        @Override
        public void onStart() {
            Log.i(TAG, "onStart: 开启");
        }

        @Override
        public void onSuccess(List<String> photoList) {
            Log.i(TAG, "onSuccess: 返回数据"+photoList.size());
//            for (String s : photoList) {
//                Log.i(TAG, s);
//            }
            path.clear();
            path.addAll(photoList);
            ids.clear();
            mAdapter.setPath(path);
            for(String p:path){
                upImg(p);
            }
        }

        @Override
        public void onCancel() {
            Log.i(TAG, "onCancel: 取消");
        }

        @Override
        public void onFinish() {
            Log.i(TAG, "onFinish: 结束");
        }

        @Override
        public void onError() {
            Log.i(TAG, "onError: 出错");
        }
    };

    private void Comment(String com){
        LoadDialog.show(mContext);
        new ApiManager().orderComment(goods.getRec_id(), com, "" + scro, ids, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                BaseEntity base=JSONObject.parseObject(result,BaseEntity.class);
                if(base.getStatus().equals("success")){
                    NToast.shortToast(mContext,base.getMsg());
                    finish();
                }else{
                    NToast.shortToast(mContext,base.getMsg());
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void upImg(String p){
        LoadDialog.show(mContext);
        new ApiManager().uploadImg(p, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("s航船结果："+result);
                ImgEntity img= JSONObject.parseObject(result,ImgEntity.class);
                ids.add(img.getData().getId());
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

    private void submit() {
        // validate
        String comment = ed_comment.getText().toString().trim();
        if (TextUtils.isEmpty(comment)) {
            Toast.makeText(this, "请输入商品评论", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        Comment(comment);
    }
}
