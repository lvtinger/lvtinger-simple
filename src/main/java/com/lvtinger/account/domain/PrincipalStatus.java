package com.lvtinger.account.domain;

/**
 * 主体状态
 *
 * @author qiuxu
 */
public enum PrincipalStatus {
    /**
     * 默认
     */
    normal(0, "默认"),
    /**
     * 激活
     */
    active(1, "激活"),
    /**
     * 锁定
     */
    locked(2, "锁定");

    private int value;
    private String name;

    PrincipalStatus(int value, String name) {
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