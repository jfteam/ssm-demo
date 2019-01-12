package org.jfteam.ssm.vo;

import org.jfteam.framework.base.BaseVO;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/20 17:26
 */
public class LookupClassifyVO extends BaseVO {

    private String classifyCode;
    private String classifyParentCode;
    private String name;
    private Integer status;
    private String classifyDesc;

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }

    public String getClassifyParentCode() {
        return classifyParentCode;
    }

    public void setClassifyParentCode(String classifyParentCode) {
        this.classifyParentCode = classifyParentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClassifyDesc() {
        return classifyDesc;
    }

    public void setClassifyDesc(String classifyDesc) {
        this.classifyDesc = classifyDesc;
    }
}
