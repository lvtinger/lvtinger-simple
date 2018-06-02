package com.lvtinger.account.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 主体
 *
 * @author qiuxu
 */
@Getter
@Setter
public class Principal implements Serializable {
    private static final long serialVersionUID = 407668278033160713L;
    /**
     * 主体id
     */
    private Long principalId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别
     */
    private Gender gender;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 介绍
     */
    private String summary;
    /**
     * 状态
     */
    private PrincipalStatus status;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
}
