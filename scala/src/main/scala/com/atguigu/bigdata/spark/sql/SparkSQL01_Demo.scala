package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}

object SparkSQL01_Demo {

    def main(args: Array[String]): Unit = {

        // 第一个SparkSQL的小例子

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkSQL01_Demo").setMaster("local[*]")

        // SparkSQL上下文环境对象
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 创建DataFrame
        val df: DataFrame = sparkSession.read.json("input/user.json")

        // 将DataFrame转换为一张临时表用于访问
        //frame.show()
        df.createOrReplaceTempView("user")

        // 使用SQL语法访问数据
        //sparkSession.sql("select avg(age) from user").show

        // 使用DSL语法访问数据
        df.select("age").show()

        // 释放资源
        sparkSession.stop()
    }
}
