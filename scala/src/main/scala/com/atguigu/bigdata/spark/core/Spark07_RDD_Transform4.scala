package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark07_RDD_Transform4 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val numRDD: RDD[Int] = sc.makeRDD(1 to 16, 4)

        // 合并分区
        // 合并时，不采用shuffle操作
        //val coalesceRDD: RDD[Int] = numRDD.coalesce(3)
        // 合并时，采用shuffle操作,

        /*
        // 转换算子 - coalesce （合并分区）
        val coalesceRDD: RDD[Int] = numRDD.coalesce(3, true)
        */

        // 转换算子 - repartition （重分区）
        // 从源码角度来讲，repartition其实就是coalesce一个特例，肯定会用到shuffle操作
        val repartitionRDD: RDD[Int] = numRDD.repartition(1)

        val mapRDD: RDD[(Int, Int)] = repartitionRDD.mapPartitionsWithIndex {
            (ind, datas) => {
                datas.map {
                    (ind, _)
                }
            }
        }
        mapRDD.collect().foreach(println)




    }
}
