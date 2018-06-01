package com.lvtinger.account.domain;

/**
 * 认证状态
 * @author qiuxu
 */
public enum CertStatus {
    normal(0, "默认"), reject(2, "拒绝"), passed(3, "认证");
    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    CertStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
