package com.atguigu.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object Spark19_RDD_Action4 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)


        val kvRDD = sc.makeRDD(List(("a",1),("a",1),("a",1),("a",1)))

        kvRDD.countByKey().foreach(println)


    }
}
