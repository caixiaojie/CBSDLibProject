package com.yjhs.cbsdlib.nets.example;


import com.yjhs.cbsdlib.nets.callbacks.HttpResponseFunc;
import com.yjhs.cbsdlib.nets.callbacks.ServerResponseFunc;
import com.yjhs.cbsdlib.nets.example.bean.DetailRespBean;
import com.yjhs.cbsdlib.nets.example.bean.UserRequestBean;
import com.yjhs.cbsdlib.nets.example.bean.UserRespBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

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
        return mNet.getApi().login(req)
                .map(new ServerResponseFunc<UserRespBean>())
                .onErrorResumeNext(new HttpResponseFunc<UserRespBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //详细
    public Observable<DetailRespBean> detail() {
        return mNet.getApi().detail()
                .map(new ServerResponseFunc<DetailRespBean>())
                .onErrorResumeNext(new HttpResponseFunc<DetailRespBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
