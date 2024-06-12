package com.zh.exception;

/**
 * 运行时异常
 */
public class OperationFailureException extends RuntimeException{
    public OperationFailureException() {
    }

    public OperationFailureException(String message) {
        super(message);
    }
}
