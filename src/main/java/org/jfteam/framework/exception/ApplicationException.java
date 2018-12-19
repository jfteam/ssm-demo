package org.jfteam.framework.exception;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:15
 */
public abstract class ApplicationException extends Exception {

    private Object[] args;
    private String errorCode;
    private Throwable throwable;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String errorCode) {
        this.errorCode = errorCode;
    }

    public ApplicationException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    public ApplicationException(String errorCode, Throwable throwable, Object... args) {
        this.errorCode = errorCode;
        this.throwable = throwable;
        this.args = args;
    }

    public ApplicationException(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String getMessage() {
        return this.errorCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
