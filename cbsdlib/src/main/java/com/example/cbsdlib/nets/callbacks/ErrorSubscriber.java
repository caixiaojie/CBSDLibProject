package com.example.cbsdlib.nets.callbacks;


import com.example.cbsdlib.nets.exceptions.ApiException;


import rx.Observer;
import rx.Subscriber;


public abstract  class ErrorSubscriber<T> extends Subscriber<T> {

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
