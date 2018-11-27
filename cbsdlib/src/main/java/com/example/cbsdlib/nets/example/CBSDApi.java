package com.example.cbsdlib.nets.example;


import com.example.cbsdlib.nets.example.bean.DetailRespBean;
import com.example.cbsdlib.nets.example.bean.UserRequestBean;
import com.example.cbsdlib.nets.example.bean.UserRespBean;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author:Ariana Wong
 * Date: 2017-12-18
 * Desctiption:
 */

public interface CBSDApi {

    //  test:https://42.123.99.59:13000/   online:https://58.16.66.237:13000/
    //  test:https://42.123.99.59:13000/   online:https://58.16.66.237:13000/
    String baseUrl = "http://192.168.0.115:8080/guoxinapi/";

    @POST("com/m/had-login/fieldConf/add")
    Observable<UserRespBean> login(@Body UserRequestBean bean);

    @GET("com/m/had-login/work/getDetail")
    Observable<DetailRespBean> detail();

}
