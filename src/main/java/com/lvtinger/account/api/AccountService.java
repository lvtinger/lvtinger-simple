package com.lvtinger.account.api;

public interface AccountService {
    void register(String username, String password);
    void login(String username, String password);
    void change(Long principalId, String password);
    void found(Long principalId);
}