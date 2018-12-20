package org.jfteam.framework.exception;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:15
 */
public abstract class SystemException extends RuntimeException {

    private Object[] args;
    private String errorCode;
    private Throwable throwable;

    public SystemException() {
        super();
    }

    public SystemException(String errorCode) {
        this.errorCode = errorCode;
    }

    public SystemException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public SystemException(String errorCode, Throwable throwable) {
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public SystemException(String errorCode, Throwable throwable, Object... args) {
        this.errorCode = errorCode;
        this.throwable = throwable;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return ExceptionMessageManager.getMessage(errorCode, throwable, args);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
