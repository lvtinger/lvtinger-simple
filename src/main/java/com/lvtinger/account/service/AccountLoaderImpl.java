package com.lvtinger.account.service;

import com.lvtinger.account.api.AccountLoader;
import com.lvtinger.account.domain.Account;
import com.lvtinger.account.domain.Identity;
import com.lvtinger.account.domain.Principal;

import java.util.List;

public class AccountLoaderImpl implements AccountLoader {
    @Override
    public Boolean exists(String username) {
        return null;
    }

    @Override
    public Principal getPrincipalById(Long principalId) {
        return null;
    }

    @Override
    public List<Account> getAccountById(Long principalId) {
        return null;
    }

    @Override
    public Identity getIdentityById(Long principalId) {
        return null;
    }
}
