package com.lvtinger.account.service;

import com.lvtinger.account.api.AccountService;
import com.lvtinger.account.dao.AccountDAO;
import com.lvtinger.account.dao.CipherDAO;
import com.lvtinger.account.dao.IdentityDAO;
import com.lvtinger.account.dao.PrincipalDAO;
import com.lvtinger.account.value.*;

public class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;
    private CipherDAO cipherDAO;
    private IdentityDAO identityDAO;
    private PrincipalDAO principalDAO;

    @Override
    public RegisterResult register(String username, String password) {
        return null;
    }

    @Override
    public LoginResult login(String username, String password) {
        return null;
    }

    @Override
    public ValidateResult validate(Long principalId, String password) {
        return null;
    }

    @Override
    public ChangeResult change(Long principalId, String original, String replace) {
        return null;
    }

    @Override
    public FoundResult found(String username) {
        return null;
    }

    @Override
    public ResetResult reset(String password, String validateCode, String signKey) {
        return null;
    }
}