package com.lvtinger.exception;

public class LogicException extends RuntimeException {
    private int code;
    private String content;

    public LogicException(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public LogicException(Throwable cause, int code, String content) {
        super(cause);
        this.code = code;
        this.content = content;
    }
}