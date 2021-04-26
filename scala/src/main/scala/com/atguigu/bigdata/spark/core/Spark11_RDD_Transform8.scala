package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object Spark11_RDD_Transform8 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val numRDD = sc.makeRDD(List( ("a",1),("b",2),("c",3),("d",4) ))

        //numRDD.partitionBy()


    }
}
