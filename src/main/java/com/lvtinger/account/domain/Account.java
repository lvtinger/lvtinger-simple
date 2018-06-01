package com.lvtinger.account.domain;

import java.io.Serializable;

/**
 * 账户
 * @author qiuxu
 */
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
     * 状态
     */
    private AccountStatus status;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus principalStatus) {
        this.status = principalStatus;
    }
}
