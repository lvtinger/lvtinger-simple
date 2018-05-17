package com.lvtinger.test;

import com.lvtinger.assembly.ClassBuilder;
import com.lvtinger.converter.Converter;
import com.lvtinger.converter.ConverterFactory;
import jdk.internal.org.objectweb.asm.Type;
import org.junit.Test;

public class ConverterTest extends ClassLoader{

    @Test
    public void test(){
        AccountVO vo = new AccountVO();
        vo.setId(123456L);
        vo.setPrincipalId(654321L);
        vo.setUsername("risesun");
        Converter<AccountVO, Account> converter = ConverterFactory.get(AccountVO.class, Account.class);
        Account account = converter.convert(vo);
        System.out.println(account);
    }

    @Test
    public void testHello() throws IllegalAccessException, InstantiationException {
        Class<?> defineClass = ClassBuilder.init("Account")
                .property("userId", Long.class)
                .property("username", String.class)
                .property("password", String.class)
                .build();
        Object instance = defineClass.newInstance();
        System.out.println(instance);
    }

    @Test
    public void testString(){
        System.out.println(Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Object.class)));
    }


}
