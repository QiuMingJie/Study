package com.atguigu.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object Spark18_RDD_Action3 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        val numRDD = sc.makeRDD(List(1,2,3,4),2)
        val kvRDD = sc.makeRDD(List((1,1)))

        //numRDD.saveAsTextFile("output")
        //numRDD.saveAsObjectFile("output1")
        //numRDD.saveAs
        kvRDD.saveAsSequenceFile("output2")
        //kvRDD.sa

    }
}
