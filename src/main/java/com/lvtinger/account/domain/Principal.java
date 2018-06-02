package com.lvtinger.account.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 主体
 *
 * @author qiuxu
 */
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

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public PrincipalStatus getStatus() {
        return status;
    }

    public void setStatus(PrincipalStatus status) {
        this.status = status;
    }
}
