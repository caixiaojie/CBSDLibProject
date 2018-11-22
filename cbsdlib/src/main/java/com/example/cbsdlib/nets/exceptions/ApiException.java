package com.example.cbsdlib.nets.exceptions;

import android.util.Log;

/**
 * Created by Leo on 2016/5/4
 */
public class ApiException extends Exception {
    private final int code;
    private String msg;
    private String data;

    public static final int RE_LOGIN = 1000;
    public static final int PARSE_ERROR = 1001;
    public static final int UNKNOWN = 1002;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
        try {
            Log.e("ApiException", throwable.toString());
        }catch (Exception e){

        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

}