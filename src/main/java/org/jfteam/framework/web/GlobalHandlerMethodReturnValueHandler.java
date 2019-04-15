package org.jfteam.framework.web;

import org.jfteam.framework.base.ResponseResult;
import org.jfteam.framework.exception.ExceptionMessageManager;
import org.jfteam.framework.holder.ConstantHolder;
import org.jfteam.framework.util.JSONUtils;
import org.jfteam.framework.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 返回值处理器
 * @author: fengwenping
 * @date: 2018/12/19 16:15
 */
public class GlobalHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandlerMethodReturnValueHandler.class);

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        final Class<?> containingClass = returnType.getContainingClass();
        return containingClass.isAnnotationPresent(RestController.class)
                || containingClass.isAnnotationPresent(ResponseBody.class)
                || returnType.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) {
        LOGGER.debug("return value class: {}", returnValue.getClass().getName());
        //不再跳转到下一个方法返回值处理器
        mavContainer.setRequestHandled(false);
        ResponseResult responseResult;
        //判断是否是返回的ResponseResult
        if (returnValue instanceof ResponseResult) {
            responseResult = (ResponseResult) returnValue;
        } else {
            responseResult = new ResponseResult.Builder()
                    .success(true)
                    .errorCode(ConstantHolder.ResponseResultCodes.SUCCESS)
                    .errorMessage(ExceptionMessageManager.getSuccessMessage())
                    .data(returnValue)
                    .build();
        }
        LOGGER.debug("return value json: {}", JSONUtils.toJSONString(responseResult));
        final HttpServletResponse httpServletResponse = webRequest.getNativeResponse(HttpServletResponse.class);
        final HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        WebUtils.writeContent(httpServletRequest, httpServletResponse, responseResult);
    }
}
