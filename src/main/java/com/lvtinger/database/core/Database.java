package com.lvtinger.database.core;

import java.sql.PreparedStatement;

public interface Database {
    void connect();

    PreparedStatement prepare(String sql);

    void transact();

    void commit();

    void rollback();

    void closed();
}