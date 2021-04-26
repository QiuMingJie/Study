package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 1. 从内存中创建

        // makeRDD方法其实底层调用的就是parallelize
        val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4))
        // makeRDD的第二个参数表示并行度，其实指的是分区的数量，所以多少就是多少，而        val fileRDD: RDD[String] = sc.textFile("input/3.txt", 2)是最少的分区数量，所以可能+1
        //val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4), 3)
        //val numRDD: RDD[Int] = sc.parallelize(List(1,2,3,4))
        numRDD.collect().foreach(println)
        //numRDD.saveAsTextFile("output")

        // 2. 从存储系统中创建
        // 默认情况下，路径为相对路径，指向项目的根路径
        // textFile了可以设定文件的路径，读取数据时和hadoop读取文件一致
        val fileRDD: RDD[String] = sc.textFile("input/3.txt", 2)

        //fileRDD.collect().foreach(println)
        fileRDD.saveAsTextFile("output")
    }
}
