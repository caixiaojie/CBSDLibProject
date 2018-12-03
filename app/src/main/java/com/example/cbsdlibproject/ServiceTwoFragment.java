package com.example.cbsdlibproject;

import android.view.View;

import com.gyf.barlibrary.ImmersionBar;

/**
 * @author geyifeng
 * @date 2017/7/20
 */
public class ServiceTwoFragment extends BaseFragment {

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
//                .navigationBarColor(R.color.btn2)
//                .navigationBarDarkIcon(true)
                .keyboardEnable(false)
                .init();
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_two_service;
    }

    @Override
    public void init(View rootView) {

    }

    @Override
    protected void setListener() {
        super.setListener();
    }
}
