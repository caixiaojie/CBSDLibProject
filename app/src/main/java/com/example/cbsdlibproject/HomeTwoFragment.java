package com.example.cbsdlibproject;

import android.view.View;
import android.widget.Toast;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

/**
 * @author geyifeng
 * @date 2017/7/20
 */

public class HomeTwoFragment extends BaseFragment {


    @Override
    public void initImmersionBar() {
        super.initImmersionBar();


        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.colorPrimary)
                .keyboardEnable(false)
                .init();
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_two_home;
    }

    @Override
    public void init(View rootView) {

    }
}
