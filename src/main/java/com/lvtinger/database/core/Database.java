package com.lvtinger.database.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface Database {
    void connect();

    PreparedStatement prepare(String sql);

    void dispose(PreparedStatement statement);

    void dispose(ResultSet set);

    void transact();

    void commit();

    void rollback();

    void closed();
}