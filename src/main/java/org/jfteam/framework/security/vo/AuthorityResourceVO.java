package org.jfteam.framework.security.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2019/1/11 11:53
 */
public class AuthorityResourceVO implements Serializable {
    private String code;
    private String desc;

    private List<AuthorityOperationVO> authorityOperations;

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

    public List<AuthorityOperationVO> getAuthorityOperations() {
        return authorityOperations;
    }

    public void setAuthorityOperations(List<AuthorityOperationVO> authorityOperations) {
        this.authorityOperations = authorityOperations;
    }

    public AuthorityResourceVO cloneAttributes() {
        AuthorityResourceVO authorityResourceVO = new AuthorityResourceVO();
        authorityResourceVO.setCode(this.code);
        authorityResourceVO.setDesc(this.desc);
        if (this.authorityOperations != null && this.authorityOperations.size() > 0) {
            this.authorityOperations.forEach(authorityOperationVO -> {
                if (authorityResourceVO.getAuthorityOperations() == null) {
                    authorityResourceVO.setAuthorityOperations(new ArrayList<>());
                }
                authorityResourceVO.getAuthorityOperations().add(authorityOperationVO);
            });
        }
        return authorityResourceVO;
    }
}
