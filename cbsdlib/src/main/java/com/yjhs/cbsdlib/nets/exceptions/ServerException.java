package com.yjhs.cbsdlib.nets.exceptions;

public class ServerException extends RuntimeException {
    public int code;
    public String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
