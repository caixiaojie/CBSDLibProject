package com.yjhs.cbsdlib.nets.example;


import com.yjhs.cbsdlib.nets.entities.ResultVO;
import com.yjhs.cbsdlib.nets.example.bean.DetailRespBean;
import com.yjhs.cbsdlib.nets.example.bean.UserRequestBean;
import com.yjhs.cbsdlib.nets.example.bean.UserRespBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
    Observable<ResultVO<UserRespBean>> login(@Body UserRequestBean bean);

    @GET("com/m/had-login/work/getDetail")
    Observable<ResultVO<DetailRespBean>> detail();

}
