package com.lvtinger.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 账户
 *
 * @author qiuxu
 */
@Setter
@Getter
public class Account implements Serializable {
    private static final long serialVersionUID = 5023377117225980716L;
    /**
     * 账户id
     */
    private Long accountId;

    /**
     * 用户id
     */
    private Long principalId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 类型
     */
    private AccountType type;

    /**
     * 状态
     */
    private AccountStatus status;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}
