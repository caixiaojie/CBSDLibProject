package com.example.cbsdlib.nets.example;


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

//    //登录
//    public Observable<UserRespBean> userLogin(String name,String pwd) {
//        return mNet.getApi().login(name,pwd).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

}
