package org.jfteam.framework.security.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:53
 */
@JsonIgnoreProperties(value = {"authorityResources"})
public class AuthorityOperationVO implements Serializable {

    private String code;
    private String desc;
    private AuthorityResourceVO authorityResources;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public AuthorityResourceVO getAuthorityResources() {
        return authorityResources;
    }

    public void setAuthorityResources(AuthorityResourceVO authorityResources) {
        this.authorityResources = authorityResources;
    }
}
