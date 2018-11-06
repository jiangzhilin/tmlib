package com.liuge.z02sckhd_6wqgx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2018/8/21.
 */

public class NoScroGridView extends GridView {

    public NoScroGridView(Context context) {
        super(context);
    }

    public NoScroGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScroGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
