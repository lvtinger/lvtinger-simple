package com.lvtinger.test.repository;

import com.lvtinger.test.domain.Account;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRepository {
    private DataSource source;

    public AccountRepository() {
    }

    public DataSource getSource() {
        return source;
    }

    public void setSource(DataSource source) {
        this.source = source;
    }

    public boolean insert(Account account) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = source.getConnection();
            String sql = "INSERT INTO account(id, createTime, updateTime, status, username, principal) VALUES (?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setLong(1, account.getId());
            statement.setLong(2, account.getCreateTime());
            statement.setLong(3, account.getUpdateTime());
            statement.setLong(4, account.getStatus());
            statement.setString(5, account.getUsername());
            statement.setLong(6, account.getPrincipalId());
            int i = statement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            //ignore
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }


        return true;
    }
}
