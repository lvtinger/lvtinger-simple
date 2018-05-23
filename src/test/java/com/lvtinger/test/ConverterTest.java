package com.lvtinger.test;

import com.lvtinger.assembly.ClassBuilder;
import com.lvtinger.converter.Converter;
import com.lvtinger.converter.ConverterFactory;
import com.lvtinger.test.domain.Account;
import com.lvtinger.test.value.AccountVO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConverterTest extends ClassLoader {

    @Test
    public void test() {
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
    public void testConverter() {
        String className = "com.lvtinger.test.AccountConverter";
    }

    public void jdbcTest() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/test";

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, "root", "root");

        String sql = "INSERT INTO account" +
                "(id, createTime, updateTime, status, username, principal) " +
                "VALUES (?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        Long timestamp = System.currentTimeMillis();
        statement.setLong(1, 1L);
        statement.setLong(2, timestamp);
        statement.setLong(3, timestamp);
        statement.setLong(4, 0);
        statement.setString(5, "risesun");


    }


}