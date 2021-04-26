package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark04_RDD_Transform1 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
//        val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4))


        // RDD转换算子 - flatMap ，扁平化操作
        //val flatMapRDD: RDD[Int] = numRDD.flatMap(x=>1 to x)
        //flatMapRDD.collect().foreach(println)

        //List("Hello World")
        val list = sc.makeRDD(List(List(1,2), List(3,4)))

        val flatMapRDD: RDD[Int] = list.flatMap(x=>x)
//        flatMapRDD.collect().foreach(println)

        // RDD转换算子 - glom 将分区当成一个数组
        val numRDD: RDD[Int] = sc.parallelize(1 to 16,4)

        val glomRDD: RDD[Array[Int]] = numRDD.glom()
        val mapRDD: RDD[Int] = glomRDD.map(_.max)

        println(mapRDD.collect().min)
    }
}
