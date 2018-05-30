package com.lvtinger.test.repository;

import com.lvtinger.exception.DatabaseException;
import com.lvtinger.test.domain.Account;
import com.lvtinger.value.PersistentObject;

import java.sql.*;

public class AccountRepositoryImpl implements AccountRepository {
    private Connection connection;

    public AccountRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(Account po) {
        Long timestamp = System.currentTimeMillis();
        po.setCreateTime(timestamp);
        po.setUpdateTime(timestamp);
        po.setStatus(PersistentObject.STATUS_NORMAL);

        String sql = "INSERT INTO account(createTime, updateTime, status, username, principalId) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, po.getCreateTime());
            statement.setLong(2, po.getUpdateTime());
            statement.setInt(3, po.getStatus());
            statement.setString(4, po.getUsername());
            statement.setLong(5, po.getPrincipalId());
            statement.executeUpdate();
            set = statement.getGeneratedKeys();
            if (set.next()) {
                po.setId(set.getLong(1));
            }
            return true;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public boolean update(Account po) {
        Long timestamp = System.currentTimeMillis();
        po.setUpdateTime(timestamp);

        String sql = "UPDATE account SET updateTime = ?, status = ?, username = ?, principalId = ? WHERE id = ?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, po.getUpdateTime());
            statement.setInt(2, po.getStatus());
            statement.setString(3, po.getUsername());
            statement.setLong(4, po.getPrincipalId());
            statement.setLong(5, po.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public boolean delete(Account po) {
        Long timestamp = System.currentTimeMillis();
        po.setUpdateTime(timestamp);
        po.setStatus(PersistentObject.STATUS_DELETE);

        String sql = "UPDATE account SET updateTime = ?, status = ? WHERE id = ?;";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, po.getUpdateTime());
            statement.setInt(2, po.getStatus());
            statement.setLong(3, po.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
        }
    }

    @Override
    public Account getById(Long id) {
        String sql = "SELECT id, username, principalId, status, createTime, updateTime FROM account WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();
            Account account = null;
            if(set.next()){
                account = new Account();
                account.setId(set.getLong(0));
                account.setUsername(set.getString(1));
                account.setPrincipalId(set.getLong(2));
                account.setStatus(set.getInt(3));
                account.setCreateTime(set.getLong(4));
                account.setUpdateTime(set.getLong(5));
            }
            return account;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    //ignore;
                }
            }
        }
    }
}
