package com.example.cbsdlib.nets.callbacks;

import com.example.cbsdlib.nets.entities.ResultTVO;
import com.example.cbsdlib.nets.entities.ResultVO;
import com.example.cbsdlib.nets.exceptions.ServerException;

import java.util.ArrayList;

import rx.functions.Func1;

public class ServerResponseFunc2<T> implements Func1<ResultTVO<T>, ArrayList<T>> {
    @Override
    public ArrayList<T> call(ResultTVO<T> reponse) {
        //对返回码进行判断，如果不是1，则证明服务器端返回错误信息了，便根据跟服务器约定好的错误码去解析异常
        if (reponse.getCode() != 1) {
            //如果服务器端有错误信息返回，那么抛出异常，让下面的方法去捕获异常做统一处理
            throw new ServerException(reponse.getCode(),reponse.getMsg());
        }
        //服务器请求数据成功，返回里面的数据实体
        return reponse.getData();
    }
}
