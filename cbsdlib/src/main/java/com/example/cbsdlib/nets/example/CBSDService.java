package com.example.cbsdlib.nets.example;


import com.example.cbsdlib.nets.example.bean.DetailRespBean;
import com.example.cbsdlib.nets.example.bean.UserRequestBean;
import com.example.cbsdlib.nets.example.bean.UserRespBean;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:Ariana Wong
 * Date: 2017-12-18
 * Desctiption:
 */

public class CBSDService {
    private static CBSDService sInstance;
    private CBSDNets mNet;

    private CBSDService() {
        mNet =  CBSDNets.getInstance();
    }

    public static CBSDService getInstance() {
        if (sInstance == null) {
            sInstance = new CBSDService();
        }
        return sInstance;
    }

    //登录
    public Observable<UserRespBean> userLogin(UserRequestBean req) {
        return mNet.getApi().login(req).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //详细
    public Observable<DetailRespBean> detail() {
        return mNet.getApi().detail().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
