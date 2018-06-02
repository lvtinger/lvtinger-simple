package com.lvtinger.account.domain;

import lombok.Getter;

/**
 * 认证状态
 *
 * @author qiuxu
 */
@Getter
public enum CertStatus {
    normal(0, "默认"), reject(2, "拒绝"), passed(3, "认证");
    private int value;
    private String name;

    CertStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
