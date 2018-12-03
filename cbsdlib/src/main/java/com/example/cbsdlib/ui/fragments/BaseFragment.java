package com.example.cbsdlib.ui.fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cbsdlib.R;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.ImmersionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 *
 *created by Damon on 2017/6/2 10:04
 *
 *description: 
 *
 */
public abstract class BaseFragment extends ImmersionFragment {

//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    protected Activity mActivity;
    private View rootView;//缓存Fragment view

    private ProgressDialog progressDialog;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ImmersionBar.setTitleBar(mActivity, toolbar);
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).keyboardEnable(true).init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView==null){
            rootView=inflater.inflate(getFragmentView(),container,false);
            unbinder = ButterKnife.bind(this,rootView);
            init(rootView);
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        setListener();
        return rootView;
    }

    public abstract @LayoutRes
    int getFragmentView();

    public abstract void init(View rootView);

    /**
     * 设置监听
     */
    protected void setListener() {

    }

    public void hideView(View view){
        if(view!=null){
            view.setVisibility(View.GONE);
        }
    }

    public void showView(View view){
        if(view!=null){
            view.setVisibility(View.VISIBLE);
        }
    }

    protected void showLoadingMsg(String message){
        if (progressDialog != null) {
            progressDialog.setMessage(message != null ? message : "处理中...");
        } else {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setMessage(message != null ? message : "处理中...");
        }
        progressDialog.show();
    }

    protected void hideLoadingMsg(){
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
