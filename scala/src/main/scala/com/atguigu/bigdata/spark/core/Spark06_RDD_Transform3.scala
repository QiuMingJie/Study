package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark06_RDD_Transform3 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,4,5),2)

        numRDD.mapPartitionsWithIndex((x,y)=>{y.map(k=>(x,k))}).collect().foreach(println)
        // 转换算子 - sample （抽样）
        /*
        //val sampleRDD: RDD[Int] = numRDD.sample(false, 0.5)
        val sampleRDD: RDD[Int] = numRDD.sample(true, 2)

        //sampleRDD.collect().foreach(println)
        */

        // 转换算子 - distinct （去重）
//        // 数据在去重后会打乱重组
//        val distinctRDD: RDD[Int] = numRDD.distinct(4)
//        distinctRDD.collect().foreach(println)


    }
}
