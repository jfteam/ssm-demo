package org.jfteam.framework.security.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jfteam.framework.security.annotation.AuthOperation;
import org.jfteam.framework.security.annotation.AuthResource;
import org.jfteam.framework.security.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 15:51
 */
@Aspect
@Component("authorityInterceptor")
@Order(100)
public class AuthorityInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityInterceptor.class);

    @Autowired
    private AuthorityService authorityService;

    @Pointcut("execution(* org.jfteam..controller.*.*(..)) && @annotation(org.jfteam.framework.security.annotation.AuthOperation)")
    public void authPointCut() {

    }

    @Before("authPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        LOGGER.info("begin check permission");
        final Class<?> aClass = joinPoint.getTarget().getClass();
        final AuthResource authResource = AnnotationUtils.findAnnotation(aClass, AuthResource.class);
        if (authResource != null) {
            final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            final AuthOperation authOperation = AnnotationUtils.findAnnotation(signature.getMethod(), AuthOperation.class);
            if (authOperation != null) {
                authorityService.checkPermission(authResource.code(), authOperation.code());
            }
        }
    }
}
