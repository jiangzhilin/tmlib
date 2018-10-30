package com.liuge.TMShop.utils;

import android.app.Activity;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.yancy.gallerypick.inter.ImageLoader;
import com.yancy.gallerypick.widget.GalleryImageView;

/**
 * Created by jiang on 2018/10/30.
 */

public class ChooseGlideImageLoader implements ImageLoader {
    @Override
    public void displayImage(Activity activity, Context context, String s, GalleryImageView galleryImageView, int i, int i1) {
        Glide.with(context)
                .load(s)
                .into(galleryImageView);
    }

    @Override
    public void clearMemoryCache() {

    }
}
