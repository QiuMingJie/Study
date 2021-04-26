package com.atguigu.bigdata.spark.core

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark05_RDD_Transform2 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4))

        // RDD转换算子 - groupBy
        /*
        val groupByRDD: RDD[(Int, Iterable[Int])] = numRDD.groupBy(x=>x%2)

        groupByRDD.collect().foreach(println)
        */

        // RDD转换算子 - filter
        //var sourceFilter = sc.parallelize(Array("xiaoming","xiaojiang","xiaohe","dazhi"))

        //val filterRDD: RDD[String] = sourceFilter.filter(name=>name.contains("xiao"))

        //filterRDD.collect().foreach(println)
        val strRDD: RDD[String] = sc.makeRDD(List("1", "2", "3", "4"))

        val filterRDD: RDD[String] = strRDD.filter(x=>x.contains("1"))
        filterRDD.sample(false,.1)
        filterRDD.collect().foreach(println)
    }
}
