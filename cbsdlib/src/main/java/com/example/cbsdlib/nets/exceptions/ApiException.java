package com.example.cbsdlib.nets.exceptions;

import android.util.Log;

/**
 * Created by Leo on 2016/5/4
 */
public class ApiException extends Exception {


    public int code;
    public String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}