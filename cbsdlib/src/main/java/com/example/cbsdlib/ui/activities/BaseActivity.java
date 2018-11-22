package com.example.cbsdlib.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.cbsdlib.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;

/**
 *
 *created by Damon on 2017/5/27 11:35
 *
 *description: 
 *
 */

public abstract class BaseActivity extends AppCompatActivity implements BGASwipeBackHelper.Delegate{

    private ProgressDialog progressDialog;
    protected BGASwipeBackHelper mSwipeBackHelper;
    protected Toolbar mToolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSwipeBackFinish();
        setContentView(getContentView());
        ButterKnife.bind(this);
        init(savedInstanceState);
//        setSwipeBackEnable(false);
    }

    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(isSupportSwipeBack());
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper.setIsNavigationBarOverlap(false);
    }

    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {
    }

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {
    }

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        mSwipeBackHelper.swipeBackward();
    }

    protected void setStatusBarColor(@ColorInt int color) {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary),  0);
    }

    protected void setStatusBarColor(@ColorInt int color,@IntRange(from = 0, to = 255) int statusBarAlpha) {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary),  statusBarAlpha);
    }


    protected abstract int getContentView();

    protected abstract void init(Bundle saveInstanceState);

    public void showLoadingMsg(String message){
        if (progressDialog != null) {
            progressDialog.setMessage(message != null ? message : "处理中...");
        } else {
            progressDialog = new ProgressDialog(BaseActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage(message != null ? message : "处理中...");
        }
        progressDialog.show();
    }

    public void hideLoadingMsg(){
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
