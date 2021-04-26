package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark08_RDD_Transform5 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        //val numRDD: RDD[Int] = sc.makeRDD(List(5,7,6,3,4,1,2))
        val numRDD = sc.makeRDD(List(("a", 1), ("c", 3), ("d", 4), ("b", 2)))


        // 转换算子 - sortBy （排序）
        numRDD.sortBy(t=>t._2, false).collect().foreach(println)





    }
}
