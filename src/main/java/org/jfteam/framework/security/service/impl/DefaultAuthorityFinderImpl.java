package org.jfteam.framework.security.service.impl;

import org.jfteam.framework.security.annotation.AuthOperation;
import org.jfteam.framework.security.annotation.AuthResource;
import org.jfteam.framework.security.service.AuthorityFinder;
import org.jfteam.framework.security.vo.AuthorityOperationVO;
import org.jfteam.framework.security.vo.AuthorityResourceVO;
import org.jfteam.framework.util.ScanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/12 16:02
 */
@Service("defaultAuthorityFinder")
public class DefaultAuthorityFinderImpl implements AuthorityFinder {

    @Value("authority.scanPackageName")
    private String scanPackageName;

    @Override
    public List<AuthorityResourceVO> findAuthorityResources() {
        List<AuthorityResourceVO> authorityResourceVOS = new ArrayList<>();
        final List<Class<?>> classes = ScanUtils.getClasses(this.getScanPackageName());
        if (classes != null && classes.size() > 0) {
            classes.forEach(aClass -> {
                final AuthorityResourceVO authorityResourceVO = this.buildAuthorityResource(aClass);
                if (authorityResourceVO != null) {
                    authorityResourceVOS.add(authorityResourceVO);
                }
            });
        }
        return null;
    }

    private AuthorityResourceVO buildAuthorityResource(Class<?> authorityResourceClass) {
        final AuthResource authResource = AnnotationUtils.findAnnotation(authorityResourceClass, AuthResource.class);
        if (authResource != null) {
            final Method[] methods = authorityResourceClass.getDeclaredMethods();
            if (methods != null && methods.length > 0) {
                AuthorityResourceVO authorityResourceVO = new AuthorityResourceVO();
                authorityResourceVO.setCode(authResource.code());
                authorityResourceVO.setDesc(authResource.desc());
                Arrays.stream(methods).map(method -> AnnotationUtils.findAnnotation(method, AuthOperation.class)).filter(Objects::nonNull).forEach(authOperation -> {
                    if (authorityResourceVO.getAuthorityOperations() == null) {
                        authorityResourceVO.setAuthorityOperations(new ArrayList<>());
                    }
                    AuthorityOperationVO authorityOperationVO = new AuthorityOperationVO();
                    authorityOperationVO.setCode(authOperation.code());
                    authorityOperationVO.setDesc(authOperation.desc());
                    authorityOperationVO.setAuthorityResources(authorityResourceVO);
                    authorityResourceVO.getAuthorityOperations().add(authorityOperationVO);
                });
                return authorityResourceVO;
            }
        }
        return null;
    }

    @Override
    public String getScanPackageName() {
        return this.scanPackageName;
    }
}
