package org.jfteam.framework.exception;

import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.web.HttpStatusProvider;
import org.springframework.http.HttpStatus;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/19 20:38
 */
public class ResourceNotFoundException extends SystemException implements HttpStatusProvider {

    public ResourceNotFoundException() {
        super(ConstantHolder.ResponseResultCodes.NOT_FOUND);
    }

    @Override
    public int getHttpCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
