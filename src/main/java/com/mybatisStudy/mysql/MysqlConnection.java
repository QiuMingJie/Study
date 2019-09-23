package com.mybatisStudy.mysql;

import java.sql.*;

/**
 * @author QiuMingJie
 * @date 2019-09-23 14:16
 * @Description mysql连接
 */

public class MysqlConnection {

    private static String url = "jdbc:mysql://localhost:3306/test";
    private static String userName = "root";
    private static String password = "123456";

    public static ResultSet executeSql(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection.prepareStatement(sql).executeQuery();
    }


}
