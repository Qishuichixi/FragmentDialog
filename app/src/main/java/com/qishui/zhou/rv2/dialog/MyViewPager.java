package com.qishui.zhou.rv2.dialog;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 作者：Created by zhou on 2017/6/9 23:51
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            Log.e("Tag","onInterceptTouchEvent");
            return false;
        }
    }
}
