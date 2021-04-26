package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark16_RDD_Action1 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // 准备数据
        val numRDD: RDD[Int] = sc.makeRDD(List(1,4,3,2))

        // 行动算子 - reduce
        //List(1,2,3,4).max

        // 算子中的逻辑操作一定是在executor中执行，所以需要考虑分区内，分区间的操作
        /*
        val i: Int = numRDD.reduce(_+_)
        */

        // 行动算子 - count
        //println("i = " + numRDD.count())

        // 行动算子 - first
        //println("i = " + numRDD.first())

        // 行动算子 - take
        //println("i = " + numRDD.take(3))

        // 行动算子 - takeOrdered
        numRDD.takeOrdered(3).foreach(println)

    }
}
