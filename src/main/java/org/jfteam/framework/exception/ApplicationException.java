package org.jfteam.framework.exception;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/5 21:15
 */
public class ApplicationException extends Exception {

    private Object[] args;
    private String errorCode;

    public ApplicationException(String errorCode){

    }
}
