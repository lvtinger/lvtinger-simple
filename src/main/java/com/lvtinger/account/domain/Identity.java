package com.lvtinger.account.domain;

import java.io.Serializable;

/**
 * 认证
 * @author qiuxu
 */
public class Identity implements Serializable {
    private static final long serialVersionUID = -8901976829947677641L;
    /**
     * 主体id
     */
    private Long principalId;
    /**
     * 证件号
     */
    private String code;
    /**
     * 类型
     */
    private String type;
    /**
     * 正面图片
     */
    private String frontage;
    /**
     * 背面图片
     */
    private String opposite;

    /**
     * 认证状态
     */
    private CertStatus certStatus;

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrontage() {
        return frontage;
    }

    public void setFrontage(String frontage) {
        this.frontage = frontage;
    }

    public String getOpposite() {
        return opposite;
    }

    public void setOpposite(String opposite) {
        this.opposite = opposite;
    }

    public CertStatus getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(CertStatus certStatus) {
        this.certStatus = certStatus;
    }
}
