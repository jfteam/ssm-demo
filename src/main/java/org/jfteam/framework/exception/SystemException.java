package org.jfteam.framework.exception;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:15
 */
public class SystemException extends RuntimeException {

    private Object[] args;
    private String errorCode;

    public SystemException(String errorCode) {
        this.errorCode = errorCode;
    }
}
