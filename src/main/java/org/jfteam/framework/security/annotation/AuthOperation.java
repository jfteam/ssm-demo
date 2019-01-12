package org.jfteam.framework.security.annotation;

import java.lang.annotation.*;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:48
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthOperation {

    /**
     * 权限码
     *
     * @return
     */
    String code();

    /**
     * 权限描述
     *
     * @return
     */
    String desc();
}
