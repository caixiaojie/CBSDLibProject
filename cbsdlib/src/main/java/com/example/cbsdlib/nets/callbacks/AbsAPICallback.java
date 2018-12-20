package com.example.cbsdlib.nets.callbacks;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.widget.Toast;

import com.example.cbsdlib.CBSDApplication;
import com.example.cbsdlib.nets.exceptions.ApiException;
import com.example.cbsdlib.nets.exceptions.ResultException;
import com.example.cbsdlib.utils.ActivityUtil;
import com.example.cbsdlib.utils.LogUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.SocketTimeoutException;

import io.reactivex.disposables.Disposable;
import rx.Subscriber;

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
