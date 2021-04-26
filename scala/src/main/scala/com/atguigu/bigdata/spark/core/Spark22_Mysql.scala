package com.atguigu.bigdata.spark.core

import java.sql.{DriverManager, PreparedStatement}

import org.apache.spark.rdd.{JdbcRDD, RDD}
import org.apache.spark.{SparkConf, SparkContext}

object Spark22_Mysql {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)


        // 通过RDD访问Mysql


        val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://linux1:3306/rdd"
        val userName = "root"
        val passWd = "000000"

        /*
        // 查询mysql数据
        val mysqlRDD = new JdbcRDD(
            sc,
            ()=>{
                Class.forName(driver)
                DriverManager.getConnection(url, userName, passWd)
            },
            "select * from user where id >= ? and id <= ?",
            0,
            3,
            2, // 分区数
            (rs)=>{
                println(rs.getString("name") + "," + rs.getInt("age"))
            }
        )

        println(mysqlRDD.count())
        */

        // 向Mysql增加数据
        val dataRDD = sc.makeRDD(List( (1, "zhangsan", 30), (2, "lisi", 20), (3, "wangwu", 25) ))

        //dataRDD.map
        /*
        dataRDD.foreach{
            case ( id, name, age ) => {
                Class.forName(driver)
                val connection = DriverManager.getConnection(url, userName, passWd)
                val sql = "insert into user (id,name,age) values (?, ?, ?)";
                val statement: PreparedStatement = connection.prepareStatement(sql)
                statement.setInt(1, id)
                statement.setString(2, name)
                statement.setInt(3, age)
                statement.executeUpdate()
                statement.close()
                connection.close()
            }
        }
        */

        /*
        // 错误的写法，连接对象和操作对象没有办法序列化
        Class.forName(driver)
        val connection = DriverManager.getConnection(url, userName, passWd)
        val sql = "insert into user (id,name,age) values (?, ?, ?)";
        val statement: PreparedStatement = connection.prepareStatement(sql)
        dataRDD.foreach{
            case ( id, name, age ) => {

                statement.setInt(1, id)
                statement.setString(2, name)
                statement.setInt(3, age)
                statement.executeUpdate()

            }
        }
        statement.close()
        connection.close()
        */

        dataRDD.foreachPartition(datas=>{
            Class.forName(driver)
            val connection = DriverManager.getConnection(url, userName, passWd)
            val sql = "insert into user (id,name,age) values (?, ?, ?)";
            val statement: PreparedStatement = connection.prepareStatement(sql)

            datas.foreach{
                case ( id, name, age ) => {

                    statement.setInt(1, id)
                    statement.setString(2, name)
                    statement.setInt(3, age)
                    statement.executeUpdate()

                }
            }

            statement.close()
            connection.close()
        })

        // 关闭资源
        sc.stop()
    }
}
