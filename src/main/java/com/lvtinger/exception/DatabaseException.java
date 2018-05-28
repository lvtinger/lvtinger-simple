package com.lvtinger.exception;

public class DatabaseException extends LogicException {
    public DatabaseException(Throwable cause) {
        super(cause, 500, "数据库操作错误");
    }
}