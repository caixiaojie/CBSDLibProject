package com.example.cbsdlibproject;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cbsdlib.nets.callbacks.AbsAPICallback;
import com.example.cbsdlib.nets.example.CBSDService;
import com.example.cbsdlib.nets.example.bean.DetailRespBean;
import com.example.cbsdlib.nets.example.bean.UserRequestBean;
import com.example.cbsdlib.nets.example.bean.UserRespBean;
import com.example.cbsdlib.nets.exceptions.ApiException;
import com.example.cbsdlib.ui.activities.BaseActivity;
import com.example.cbsdlib.utils.IOSPopupDialog;
import com.example.cbsdlib.utils.ToastUtil;
import com.example.cbsdlib.utils.WechantSign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;
import rx.Observer;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.dialog1)
    Button dialog1;
    @BindView(R.id.dialog2)
    Button dialog2;
    @BindView(R.id.dialog3)
    Button dialog3;
    private UserRequestBean userRequestBean;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle saveInstanceState) {
        userRequestBean = new UserRequestBean();
        List<String> strs = new ArrayList<>();
        strs.add("11q");
        strs.add("12z");
        strs.add("13c");
        userRequestBean.setAa("123456");
        userRequestBean.setAA("111");
        userRequestBean.setStrs(strs);
        userRequestBean.setSort("1");
    }
    @OnClick({R.id.btn,R.id.btn1,R.id.dialog1,R.id.dialog2,R.id.dialog3})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn:
                IOSPopupDialog.create(MainActivity.this, "提示", "你是煞笔吗?", "是", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }, "否", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                },true,true,false).show();
                CBSDService.getInstance().userLogin(userRequestBean).subscribe(new AbsAPICallback<UserRespBean>() {

                    @Override
                    public void onNext(UserRespBean userRespBean) {

                    }

                    @Override
                    protected void onError(ApiException ex) {
                        ToastUtil.showShort(ex.getMessage());
                    }
                });
                break;
            case R.id.btn1:
                IOSPopupDialog.create(MainActivity.this, "提示", "你是煞笔吗?", "是", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }, "否", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                },true,true,true).show();
                CBSDService.getInstance().detail().subscribe(new AbsAPICallback<DetailRespBean>() {

                    @Override
                    public void onNext(DetailRespBean userRespBean) {

                    }

                    @Override
                    protected void onError(ApiException ex) {
                        ToastUtil.showShort(ex.getMessage());
                    }
                });
                break;
            case R.id.dialog1:
                IOSPopupDialog.create(MainActivity.this, 0, R.string.msg, R.string.confirm, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }, R.string.cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                },true,true,false).show();
                break;
            case R.id.dialog2:
                IOSPopupDialog.create(MainActivity.this, 0, R.string.msg, R.string.confirm, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }, 0, null,true,true,false).show();
                break;
            case R.id.dialog3:
                IOSPopupDialog.create(MainActivity.this, 0, R.string.msg, 0, null, 0, null, true, true, false, new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                }).show();
                break;
        }

    }
}
