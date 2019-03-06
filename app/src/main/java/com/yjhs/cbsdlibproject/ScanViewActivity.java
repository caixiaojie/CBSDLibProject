package com.yjhs.cbsdlibproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yjhs.cbsdlib.ui.activities.BaseActivity;
import com.yjhs.cbsdlibproject.view.ScanView;

import butterknife.BindView;
import butterknife.OnClick;

public class ScanViewActivity extends BaseActivity {
    @BindView(R.id.scan_view)
    ScanView scan_view;
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_end)
    Button btnEnd;
    @Override
    protected int getContentView() {
        return R.layout.scanview_activity;
    }

    @Override
    protected void init(Bundle saveInstanceState) {

    }
    @OnClick({R.id.btn_start,R.id.btn_end})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                scan_view.start();
                break;
            case R.id.btn_end:
                scan_view.stop();
                break;
        }
    }
}
