package com.lvtinger.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 密码
 *
 * @author qiuxu
 */
@Getter
@Setter
public class Cipher implements Serializable {
    private static final long serialVersionUID = -5995550957681473712L;
    /**
     * 用户id
     */
    private Long principalId;
    /**
     * 密码
     */
    private String password;
    /**
     * 混码
     */
    private String mixedCode;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;

}
