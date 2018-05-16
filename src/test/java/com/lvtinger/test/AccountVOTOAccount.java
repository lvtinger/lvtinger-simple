package com.lvtinger.test;

import com.lvtinger.converter.Converter;

public class AccountVOTOAccount implements Converter<AccountVO,Account> {

    public Account convert(AccountVO target) {
        Account account = new Account();
        return account;
    }
}
