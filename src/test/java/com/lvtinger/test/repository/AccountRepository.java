package com.lvtinger.test.repository;

import com.lvtinger.database.core.Database;
import com.lvtinger.test.domain.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
            return false;
        } finally {
            database.dispose(statement);
        }
    }

    public boolean delete(Account account){
        String sql = "UPDATE account SET status = 1 WHERE id = ?";
        PreparedStatement statement = database.prepare(sql);
        try {
            statement.setLong(0, account.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }finally {
            database.dispose(statement);
        }
    }

    public boolean update(Account account) {
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
            return false;
        }finally {
            database.dispose(statement);
        }
    }

    public Account getById(Long accountId) {
        String sql = "SELECT id, createTime, updateTime, status, username, principal FROM account WHERE status = 1 AND id = ?";
        PreparedStatement statement = database.prepare(sql);
        ResultSet set = null;
        try {
            statement.setLong(1, accountId);
            set = statement.executeQuery();
            if (set.next()) {
                return convert(set);
            }
            return null;
        } catch (SQLException e) {
            return null;
        } finally {
            database.dispose(set);
            database.dispose(statement);
        }
    }

    public List<Account> getAll(){
        String sql = "SELECT id, createTime, updateTime, status, username, principal FROM account WHERE status = 1";
        PreparedStatement statement = database.prepare(sql);
        ResultSet set = null;
        try {
            set = statement.executeQuery();
            List<Account> list = new LinkedList<>();
            while (set.next()) {
                list.add(convert(set));
            }
            return list;
        } catch (SQLException e) {
            return Collections.EMPTY_LIST;
        } finally {
            database.dispose(set);
            database.dispose(statement);
        }
    }

    protected Account convert(ResultSet set){
        Account account = null;
        try {
            account = new Account();
            account.setId(set.getLong(0));
            account.setCreateTime(set.getLong(1));
            account.setUpdateTime(set.getLong(2));
            account.setStatus(set.getInt(3));
            account.setUsername(set.getString(4));
            account.setPrincipalId(set.getLong(5));
        } catch (SQLException e) {

        }
        return account;
    }
}