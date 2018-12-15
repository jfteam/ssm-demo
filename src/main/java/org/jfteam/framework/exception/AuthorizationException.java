package org.jfteam.framework.exception;

import org.jfteam.framework.web.HttpStatusProvider;
import org.springframework.http.HttpStatus;

/**
 * @description: 未登录异常,前端会返回403
 * @author: fengwenping
 * @date: 2018-12-15 18:33
 */
public class AuthorizationException extends SecurityException implements HttpStatusProvider {

    public AuthorizationException(){
        super();

    }

    public AuthorizationException(String errorCode) {
        super(errorCode);
    }

    @Override
    public int getHttpCode() {
        return HttpStatus.FORBIDDEN.value();
    }
}
