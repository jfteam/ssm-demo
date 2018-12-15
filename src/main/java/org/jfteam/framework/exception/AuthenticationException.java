package org.jfteam.framework.exception;

import org.jfteam.framework.web.HttpStatusProvider;
import org.springframework.http.HttpStatus;

/**
 * @description: 未授权异常, 前端会返回401
 * @author: fengwenping
 * @date: 2018-12-15 18:35
 */
public class AuthenticationException extends SecurityException implements HttpStatusProvider {


    public AuthenticationException(String errorCode) {
        super(errorCode);
    }

    @Override
    public int getHttpCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
