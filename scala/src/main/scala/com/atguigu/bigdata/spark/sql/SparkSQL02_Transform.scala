package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}



object SparkSQL02_Transform {

    def main(args: Array[String]): Unit = {

        // RDD, DataFrame, DataSet之间的转换

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkSQL01_Demo").setMaster("local[*]")

        // SparkSQL上下文环境对象
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
        // 将RDD转换DF, DS时，需要进行隐式转换，所以需要导入相应的功能
        // 下面的导入语句，即使不使用，也最好加上。
        import sparkSession.implicits._

        // 准备RDD
        val rdd: RDD[(Int, String, Int)] = sparkSession.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 40), (3, "wangwu", 20)))

        /*
        // 将RDD转换为DataFrame
        val df: DataFrame = rdd.toDF("id", "name", "age")

        // 将DataFrame转换为DataSet
        val ds: Dataset[User] = df.as[User]

        ds.show()
        */

        // 将RDD直接转换DataSet
        // 将数据转换为对应的样例类对象

        val userRDD: RDD[User] = rdd.map {
            case (id, name, age) => {
                User(id, name, age)
            }
        }
        val ds: Dataset[User] = userRDD.toDS()

        // 将DataSet转换为DataFrame

        // 给类起别名
        //type ttt = String

        val df: DataFrame = ds.toDF()
        val rdd1: RDD[User] = ds.rdd
        val rdd2: RDD[Row] = df.rdd

        // 释放资源
        sparkSession.stop()
    }
}
// 声明样例类
case class User( id:Int, name:String, age:Int )
