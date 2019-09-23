package com.mybatisStudy;

import com.mybatisStudy.mybatis.Mybatis;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author QiuMingJie
 * @date 2019-09-23 12:16
 * @Description
 */
public class test {
    public static void main(String[] args) throws SQLException, IOException {
//        ResultSet resultSet = MysqlConnection.executeSql("select * from stu");
//        while (resultSet.next()) {
//            System.out.println( resultSet.getString("id"));
//        }

        /**
         * 测试mybatis
         */
        Mybatis mybatis = new Mybatis();
    }



}
