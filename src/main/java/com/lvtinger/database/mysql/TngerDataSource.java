package com.lvtinger.database.mysql;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class TngerDataSource extends MysqlDataSource {

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }
}