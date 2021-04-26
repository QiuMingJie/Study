package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark17_RDD_Action2 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // 准备数据
        //val kvRDD: RDD[(String, Int)] = sc.makeRDD(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),2)

        // aggregateByKey的初始值只在分区内应用
        //val aggregateRDD: RDD[(String, Int)] = kvRDD.aggregateByKey(10)(_+_, _+_)

        val numRDD = sc.makeRDD(List(1,2,3,4),2)

        //aggregate的初始值在分区内，分区间都会应用
        //val i: Int = numRDD.aggregate(10)(_+_, _+_)

        // 行动算子 - fold,等同于aggregate的简化
        val i: Int = numRDD.fold(10)(_+_)


        println(i)

    }
}
