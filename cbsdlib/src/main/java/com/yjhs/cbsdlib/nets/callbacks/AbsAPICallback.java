package com.yjhs.cbsdlib.nets.callbacks;

import com.yjhs.cbsdlib.nets.exceptions.ApiException;

import io.reactivex.disposables.Disposable;

/**
 *
 *created by Damon on 2017/6/19 13:32
 *
 *description: 
 *
 */
public abstract class AbsAPICallback<T> extends ErrorSubscriber<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    protected void onError(ApiException ex) {

    }

    @Override
    public void onNext(T t) {

    }
}
