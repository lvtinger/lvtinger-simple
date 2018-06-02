package com.lvtinger.account.domain;

import lombok.Getter;

/**
 * 性别
 *
 * @author qiuxu
 */
@Getter
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

    Gender(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
