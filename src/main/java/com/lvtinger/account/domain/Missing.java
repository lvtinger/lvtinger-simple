package com.lvtinger.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 密码找回
 */
@Getter
@Setter
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
}
