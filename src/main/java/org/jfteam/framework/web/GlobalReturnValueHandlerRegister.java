package org.jfteam.framework.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 返回值处理器注册类
 * @author: fengwenping
 * @date: 2018/12/19 19:18
 */
public class GlobalReturnValueHandlerRegister implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //判断如果是web容器
        if (applicationContext != null && applicationContext.getParent() != null) {
            synchronized (this) {
                final RequestMappingHandlerAdapter handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
                List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>();
                handlers.add(new GlobalHandlerMethodReturnValueHandler());
                handlers.addAll(handlerAdapter.getReturnValueHandlers());
                handlerAdapter.setReturnValueHandlers(handlers);
            }
        }
    }
}
