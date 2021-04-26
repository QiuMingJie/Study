package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark21_Checkpoint {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // 设置检查点的路径
        sc.setCheckpointDir("cp")

        val rdd: RDD[String] = sc.parallelize(Array("atguigu"))

        val ch = rdd.map(_+System.currentTimeMillis)

        // cache方法不会改变RDD的血缘关系
        // checkpoint会改变RDD的血缘关系,因为检查点需要保证不会删除，这样，数据不会丢失，当然就可以改变血缘关系
        ch.checkpoint()

        ch.collect().foreach(println)
        ch.collect().foreach(println)
        ch.collect().foreach(println)
        ch.collect().foreach(println)
        ch.collect().foreach(println)

        println(ch.toDebugString)

    }
}
