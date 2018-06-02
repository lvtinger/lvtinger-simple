package com.lvtinger.account.domain;

import java.io.Serializable;

/**
 * 密码找回
 */
public class Missing implements Serializable {
    private static final long serialVersionUID = -1881392076068004576L;
    /**
     * 找回账户
     */
    private Long principalId;
    /**
     * 验证码
     */
    private String validateCode;
    /**
     * 混码
     */
    private String mixedCode;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getMixedCode() {
        return mixedCode;
    }

    public void setMixedCode(String mixedCode) {
        this.mixedCode = mixedCode;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
