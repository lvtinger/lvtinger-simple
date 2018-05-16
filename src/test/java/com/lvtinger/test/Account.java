package com.lvtinger.test;

import com.lvtinger.value.PersistentObject;

public class Account extends PersistentObject<Long> {
    private String username;
    private Long principalId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(Long principalId) {
        this.principalId = principalId;
    }

    public Account() {
        this.setId(1L);
        this.username = "risesun";
        this.principalId = 123456L;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", principalId=" + principalId +
                "} " + super.toString();
    }
}
