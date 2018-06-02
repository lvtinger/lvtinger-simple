package com.lvtinger.account.domain;

import lombok.Getter;

/**
 * 账户类型
 */
@Getter
public enum AccountType {
    /**
     * 名称
     */
    named(1, "命名"),
    /**
     * 手机
     */
    phone(2, "电话"),

    /**
     * 邮箱
     */
    email(3, "邮箱");

    private int value;
    private String name;


    AccountType(int value, String name) {
        this.value = value;
        this.name = name;
    }
}