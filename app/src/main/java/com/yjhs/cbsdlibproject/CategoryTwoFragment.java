package com.yjhs.cbsdlibproject;

import android.view.View;
import com.gyf.barlibrary.ImmersionBar;


/**
 * @author geyifeng
 * @date 2017/7/20
 */

public class CategoryTwoFragment extends BaseFragment {

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.btn1)
                .init();
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_two_category;
    }

    @Override
    public void init(View rootView) {

    }
}
