package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark09_RDD_Transform6 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        //val numRDD: RDD[Int] = sc.makeRDD(List(5,7,6,3,4,1,2))
        val numRDD1 = sc.makeRDD(List(1,2,3,4),4)
        val numRDD2 = sc.makeRDD(List(4,5,6,7),3)

        // 双value类型RDD操作
        // 并集
        //val rdd: RDD[Int] = numRDD1.union(numRDD2)
        // 差集
        //val rdd: RDD[Int] = numRDD1.subtract(numRDD2)
        // 交集
        //val rdd: RDD[Int] = numRDD1.intersection(numRDD2)

        // 乘集
        //val rdd: RDD[(Int, Int)] = numRDD1.cartesian(numRDD2)

        // 拉链
        // 1. 每一个分区的数据量相同
        // 2. 拉链的两个RDD的分区数量应该相同
        val rdd: RDD[(Int, Int)] = numRDD1.zip(numRDD2)

        rdd.collect().foreach(println)




    }
}
