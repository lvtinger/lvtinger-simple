package com.lvtinger.database.mysql;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class TingerConnection extends ConnectionImpl implements Connection {
    @Override
    public void close() throws SQLException {

    }
}
