package org.jfteam.framework.security.annotation;

import java.lang.annotation.*;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:44
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthResource {

    /**
     * 资源码
     *
     * @return
     */
    String code();

    /**
     * 资源描述
     *
     * @return
     */
    String desc();
}
