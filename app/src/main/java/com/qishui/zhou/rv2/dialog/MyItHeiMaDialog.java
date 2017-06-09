package com.qishui.zhou.rv2.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qishui.zhou.rv2.R;

/**
 * 作者：Created by zhou on 2017/6/9 21:00
 * 邮箱：qishuichixi@126.com
 * 版本：V 1.0
 * 描述：
 */

public class MyItHeiMaDialog extends DialogFragment {

    public Object[] mImages;
    private ViewPager.PageTransformer mPageTransformer;
    public static MyItHeiMaDialog instance = null;
    private boolean mIsCancel;
    private boolean mIsTransparent;
    private int roundSize=10;

    public MyItHeiMaDialog() {}
    public static MyItHeiMaDialog getInstance() {
        if (instance == null) {
            instance = new MyItHeiMaDialog();
        }
        return instance;
    }

    public MyItHeiMaDialog setImages(Object...images) {
        mImages = images;
        return this;
    }

    public MyItHeiMaDialog setRoundSize(int roundSize ) {

        this.roundSize = roundSize;
        return this;
    }

    public MyItHeiMaDialog setPageTransformer(ViewPager.PageTransformer pageTransformer) {
        mPageTransformer = pageTransformer;
        return this;
    }

    public MyItHeiMaDialog show(FragmentManager fragmentManager) {
        if (instance != null) {
           instance.show(fragmentManager, "QiShuiFragmentManager");
        }
        return this;
    }

    /**
     * 点击四周是否取消dialog,默认取消
     * @param isCancel
     * @return
     */
    public MyItHeiMaDialog setCanceledOnTouchOutside(boolean isCancel) {
        mIsCancel = isCancel;
        return this;
    }
    /**
     * 设置背景四周是否透明,调用时需要放到show方法后面
     * @param isTransparent
     * @return
     */
    public MyItHeiMaDialog setOutsideIsTransparent(boolean isTransparent) {
        mIsTransparent = isTransparent;
        return this;
    }

    public MyItHeiMaDialog dissmiss() {
        getDialog().dismiss();
        return this;
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if (mIsCancel) {
            getDialog().setCanceledOnTouchOutside(mIsCancel);
        }
        View view = inflater.inflate(R.layout.fragment_dialog, container);
        MyViewPager viewPager = (MyViewPager) view.findViewById(R.id.viewpager);
        CircleIndicatorView indicator = (CircleIndicatorView) view.findViewById(R.id.indicator);
        viewPager.setPageTransformer(true, mPageTransformer);
        viewPager.setAdapter(new QiShuiPagerAdapter());
        indicator.setUpWithViewPager(viewPager);
        indicator.setEnableClickSwitch(false);
        // 设置指示器间距
        indicator.setSpace(indicator.dpToPx(10));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mIsTransparent) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams windowParams = window.getAttributes();
            windowParams.dimAmount = 0.0f;
            window.setAttributes(windowParams);
        }
    }



    class QiShuiPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View inflate = View.inflate(container.getContext(),R.layout.guide_pager_img, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_item_guide_img);
            Glide.with(container.getContext()).load(mImages[position]).error(R.mipmap.ic_launcher).placeholder(R.mipmap.defaultimg).transform(new GlideRoundTransform(container.getContext(),roundSize)).into(imageView);

            container.addView(inflate);
            return inflate;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }




    }
}

