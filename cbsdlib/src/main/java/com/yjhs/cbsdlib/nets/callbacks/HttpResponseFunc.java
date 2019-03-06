package com.yjhs.cbsdlib.nets.callbacks;

import com.yjhs.cbsdlib.nets.exceptions.ExceptionEngine;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
//import rx.Observable;


public class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
//    @Override
//    public Observable<T> call(Throwable throwable) {
//        //ExceptionEngine为处理异常的驱动器
//        return Observable.error(ExceptionEngine.handleException(throwable));
//    }

    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        //ExceptionEngine为处理异常的驱动器
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
