package com.lvtinger.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 认证
 *
 * @author qiuxu
 */
@Getter
@Setter
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
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 认证状态
     */
    private CertStatus certStatus;

}
