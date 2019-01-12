package org.jfteam.framework.security.service;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:52
 */
public interface AuthorityService {
    /**
     * 检测权限
     *
     * @param authResourceCode  资源码
     * @param authOperationCode 权限码
     */
    void checkPermission(String authResourceCode, String authOperationCode);
}
