package org.jfteam.framework.security.service.impl;

import org.jfteam.framework.security.service.AuthorityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 16:37
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
    @Override
    public void checkPermission(String authResourceCode, String authOperationCode) {
        Assert.notNull(authResourceCode, "authority resource code must can not be null.");
        Assert.notNull(authOperationCode, "authority operation code must can not be null.");
        new RuntimeException(HttpStatus.FORBIDDEN.getReasonPhrase());
    }
}
