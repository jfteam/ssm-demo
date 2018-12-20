package org.jfteam.framework.web;

import org.jfteam.framework.base.ResponseResult;
import org.jfteam.framework.exception.ApplicationException;
import org.jfteam.framework.exception.ExceptionMessageManager;
import org.jfteam.framework.exception.SystemException;
import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.util.JSONUtils;
import org.jfteam.framework.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 统一异常处理组件
 * @author: fengwenping
 * @date: 2018/12/18 15:21
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception exp) {
        ResponseResult responseResult;
        String errorCode;
        String errorMessage;
        if (exp instanceof ApplicationException) {
            final ApplicationException applicationException = (ApplicationException) exp;
            errorCode = applicationException.getErrorCode();
            errorMessage = applicationException.getMessage();
        } else if (exp instanceof SystemException) {
            final SystemException systemException = (SystemException) exp;
            errorCode = systemException.getErrorCode();
            errorMessage = systemException.getMessage();
        } else {
            errorCode = ConstantHolder.ResponseResultCodes.FAILURE;
            errorMessage = ExceptionMessageManager.getMessage(exp);
        }
        if (!StringUtils.hasText(errorMessage)) {
            errorMessage = ExceptionMessageManager.getFailureMessage();
        }
        responseResult = new ResponseResult.Builder().success(Boolean.FALSE).errorCode(errorCode).errorMessage(errorMessage).build();
        if (exp instanceof HttpStatusProvider) {
            final int httpCode = ((HttpStatusProvider) exp).getHttpCode();
            httpServletResponse.setStatus(httpCode);
        } else {
            httpServletResponse.setStatus(HttpStatus.OK.value());
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("output json to client value: {}", JSONUtils.toJSONString(responseResult));
        }
        WebUtils.writeContent(httpServletRequest, httpServletResponse, responseResult);
        return null;
    }
}
