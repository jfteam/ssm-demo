package org.jfteam.framework.security.annotation;

/**
 * @description: 描述
 * @author: Administrator
 * @date: 2019/4/15 20:47
 */
public enum SecurityPolicy {

    required,//默认安全
    mandatory,//强制
    allSystemUser,//所有系统用户
    allLogonUser,//所有登录用户
    ignoreAll,//忽略所有
    internal//内部通信
}
