package org.jfteam.framework.exception;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018-12-15 18:31
 */
public abstract class SecurityException extends SystemException {

    public SecurityException(String errorCode) {
        super(errorCode);
    }
}
