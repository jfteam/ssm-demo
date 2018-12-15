package org.jfteam.framework.exception;

import org.jfteam.framework.web.HttpStatusProvider;
import org.springframework.http.HttpStatus;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018-12-15 18:44
 */
public class BusinessException extends SystemException implements HttpStatusProvider {

    @Override
    public int getHttpCode() {
        return HttpStatus.OK.value();
    }
}
