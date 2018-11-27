package com.example.cbsdlibproject;

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
import com.example.cbsdlib.utils.WechantSign;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observer;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    private UserRequestBean userRequestBean;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle saveInstanceState) {
        userRequestBean = new UserRequestBean();
        userRequestBean.setAa("123456");
        userRequestBean.setAA("111");
        userRequestBean.setBb("111");
        userRequestBean.setBB("111");
        userRequestBean.setCc("111");
        userRequestBean.setCC("111");
        userRequestBean.setSort("1");
    }
    @OnClick({R.id.btn,R.id.btn1})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn:
                CBSDService.getInstance().userLogin(userRequestBean).subscribe(new AbsAPICallback<UserRespBean>() {
                    @Override
                    public void onNext(UserRespBean userRespBean) {

                    }

                    @Override
                    protected void onResultError(ApiException ex) {

                    }
                });
                break;
            case R.id.btn1:
                CBSDService.getInstance().detail().subscribe(new AbsAPICallback<DetailRespBean>() {
                    @Override
                    public void onNext(DetailRespBean userRespBean) {

                    }

                    @Override
                    protected void onResultError(ApiException ex) {

                    }
                });
                break;
        }

    }
}
