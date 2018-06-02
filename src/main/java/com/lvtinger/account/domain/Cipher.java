package com.lvtinger.account.domain;

import java.io.Serializable;

/**
 * 密码
 *
 * @author qiuxu
 */
public class Cipher implements Serializable {
    private static final long serialVersionUID = -5995550957681473712L;
    /**
     * 用户id
     */
    private Long principalId;
    /**
     * 密码
     */
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
