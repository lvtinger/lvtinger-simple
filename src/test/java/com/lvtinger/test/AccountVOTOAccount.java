package com.lvtinger.test;

import com.lvtinger.converter.Converter;

public class AccountVOTOAccount implements Converter<AccountVO, Account> {

    @Override
    public Account convert(AccountVO target) {
        Account account = new Account();
        account.setId(target.getId());
        account.setPrincipalId(target.getPrincipalId());
        account.setUsername(target.getUsername());
        return account;
    }
}
