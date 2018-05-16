package com.lvtinger.test;

import com.lvtinger.converter.Converter;
import com.lvtinger.converter.ConverterFactory;
import org.junit.Test;

public class ConverterTest {

    @Test
    public void test(){
        AccountVO vo = new AccountVO();
        Converter<AccountVO, Account> converter = ConverterFactory.get(AccountVO.class, Account.class);
        Account account = converter.convert(vo);
        System.out.println(account);
    }

}
