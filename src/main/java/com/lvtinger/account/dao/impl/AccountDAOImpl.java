package com.lvtinger.account.dao.impl;

import com.lvtinger.account.dao.AccountDAO;
import com.lvtinger.account.domain.Account;

import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public boolean insert(Account account) {
        return false;
    }

    @Override
    public Account getByUsername(String username) {
        return null;
    }

    @Override
    public List<Account> getByPrincipalId(Long principalId) {
        return null;
    }

    @Override
    public boolean updateStatus(Account account) {
        return false;
    }
}
