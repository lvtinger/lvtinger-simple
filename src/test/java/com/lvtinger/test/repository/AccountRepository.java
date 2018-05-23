package com.lvtinger.test.repository;

import com.lvtinger.database.core.Database;
import com.lvtinger.test.domain.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    private Database database;

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public boolean insert(Account account) {

        String sql = "INSERT INTO account(id, createTime, updateTime, status, username, principal) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = database.prepare(sql);
        try {
            statement.setLong(1, account.getId());
            statement.setLong(2, account.getCreateTime());
            statement.setLong(3, account.getUpdateTime());
            statement.setLong(4, account.getStatus());
            statement.setString(5, account.getUsername());
            statement.setLong(6, account.getPrincipalId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public boolean update(Account account){
        String sql = "UPDATE account SET updateTime = ?, status = ?, username = ?, principal = ? WHERE id = ?";
        PreparedStatement statement = database.prepare(sql);

        try {
            statement.setLong(1, account.getUpdateTime());
            statement.setInt(2, account.getStatus());
            statement.setString(3, account.getUsername());
            statement.setLong(4, account.getPrincipalId());
            statement.setLong(5, account.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Account getById(Long accountId) {
        String sql = "SELECT id, createTime, updateTime, status, username, principal FROM account WHERE id = ?";
        PreparedStatement statement = database.prepare(sql);
        try {
            statement.setLong(1, accountId);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                Account account = new Account();
                account.setId(set.getLong(0));
                account.setCreateTime(set.getLong(1));
                account.setUpdateTime(set.getLong(2));
                account.setStatus(set.getInt(3));
                account.setUsername(set.getString(4));
                account.setPrincipalId(set.getLong(5));
                return account;
            }
            return null;
        } catch (SQLException e) {
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}