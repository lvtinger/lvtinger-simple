package com.lvtinger.account.domain;

/**
 * 性别
 * @author qiuxu
 */
public enum Gender {
    /**
     * 男士
     */
    male(1, "男士"),
    /**
     * 女士
     */
    lady(2, "女士");

    /**
     * 值
     */
    private int value;
    /**
     * 名
     */
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
