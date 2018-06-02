package com.lvtinger.account.domain;

/**
 * 账户状态
 *
 * @author qiuxu
 */
public enum AccountStatus {
    /**
     * 默认
     */
    normal(1, "默认"),

    /**
     * 激活
     */
    active(2, "激活"),

    /**
     * 删除
     */
    delete(3, "删除");

    /**
     * 值
     */
    private int value;

    /**
     * 名称
     */
    private String name;

    AccountStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}