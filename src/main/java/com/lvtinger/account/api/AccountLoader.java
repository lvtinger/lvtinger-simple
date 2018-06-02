package com.lvtinger.account.api;

import com.lvtinger.account.domain.Account;
import com.lvtinger.account.domain.Identity;
import com.lvtinger.account.domain.Principal;

import java.util.List;

public interface AccountLoader {
    Boolean exists(String username);
    Principal getPrincipalById(Long principalId);
    List<Account> getAccountById(Long principalId);
    Identity getIdentityById(Long principalId);
}