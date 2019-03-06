package com.yjhs.cbsdlib.nets.callbacks;


import com.yjhs.cbsdlib.nets.exceptions.ApiException;

import io.reactivex.Observer;


//import rx.Observer;
//import rx.Subscriber;


public abstract  class ErrorSubscriber<T> implements Observer<T> {


    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            onError((ApiException)e);
        }else{
            onError(new ApiException(e,123));
        }
    }

    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);

}
